package home_search;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Search {
   private static WebEmailservice mailservice;
	List<Homeinformation> homeResult;
	boolean flag;
	GeneralSpec spec;
	 List<Homeinformation> homeArray1;
	Homeinformation home;
	String emailAddress="hayasam@najah.edu";

	public static final Logger LOGGER = Logger.getLogger(Search.class.getName());
	
	public Search(ArrayList<Homeinformation> homeArray) {
		homeArray1=new ArrayList<Homeinformation>(homeArray);
		homeResult=new ArrayList<Homeinformation>();
		
	
	

	}
	public static void setemail(WebEmailservice webemail1) {
		
		mailservice=webemail1;
		}


	


	public List<Homeinformation> byType(String type) {
		 spec = new ByTypeSpec (type);
		
		 
		 mailservice.sendMail(emailAddress, checkSpec(spec));
		return checkSpec(spec);
	}


	public List<Homeinformation> byPlacement(String place) {
		
		spec = new ByPlaceSpec (place);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
		
	}
	

	
	public List<Homeinformation> printResult() {
		

		if (homeResult.isEmpty()) {
			LOGGER.info("There is no house with such specifications :( ");	
		}
		else
		{	
		for (Homeinformation home2 : homeResult) {
			home2.printHomeInfo();
			
		}
		}
		
		return  homeResult;
	}

	
	
	
	public List<Homeinformation> byPrice(int price) {
		
	 spec = new ByPriceBelowSpec (price);
	 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}
	
	
	
	

	public  List<Homeinformation> byMaterial(String material) {
		 spec = new ByMaterialSpec (material);
		mailservice.sendMail(emailAddress,checkSpec(spec));

		return checkSpec(spec);

	}

	public List<Homeinformation> byNumberOfBedrooms(int numberOfBedrooms) {
		 spec = new ByNumberOfBedroomsSpec (numberOfBedrooms);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public List<Homeinformation> byNumberOfBathrooms(int numberOfBathrooms) {
		
		 spec = new ByNumberOfBathroomsSpec ( numberOfBathrooms);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public List<Homeinformation> betweenRangeOfPrice(int lowPrice, int highPrice) {
		
		 spec = new ByRangeOfPriceSpec ( lowPrice,highPrice);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public List<Homeinformation> betweenRangeOfarea(int lowArea, int highArea) {
		
		
		 spec = new ByRangeOfAreaSpec ( lowArea,highArea);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}

	public  List<Homeinformation> byAreaBelow(int area1) {
		 
		 spec = new ByAreaBelowSpec ( area1);
		
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);
	}



	public  List<Homeinformation>  byAllowingPets(boolean pets) {
		
		 spec = new ByAllowingPetsSpec ( pets);
	 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);

	}


	public  List<Homeinformation> byLeaseLength(int leaseLength) {
		
		 spec = new ByLeaseLengthSpec ( leaseLength);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		
		
		return checkSpec(spec);

	}

	public List<Homeinformation> byAmenities(String amenity) {
		
		 spec = new ByAmenitySpec ( amenity);
		 mailservice.sendMail(emailAddress, checkSpec(spec));

		return checkSpec(spec);

	}

	public  void bycombination(List<Homeinformation> a) {
		
		

		 mailservice.sendMail(emailAddress, a);

		
		
		

	}


	public List<Homeinformation> checkSpec(GeneralSpec spec) {
		
		
		for(Homeinformation a:homeArray1 )
			{
			 
			if (spec.isSpecMatch(a))
				homeResult.add(a);
		}
		return  homeResult;
	}

}
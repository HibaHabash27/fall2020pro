package home_search;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class Search {
   private static webEmailservice mailservice;
	ArrayList<home_information> homeResult;
	boolean flag;
	GeneralSpec spec;
	 ArrayList<home_information> homeArray1;
	home_information home;


	public Search(ArrayList<home_information> homeArray) {
		homeArray1=new ArrayList<home_information>();
		homeResult=new ArrayList<home_information>();
		
		for(int i=0;i<homeArray.size();i++)
		{
			homeArray1.add(homeArray.get(i));
			
			
		}
	

	}
	public void setemail(webEmailservice webemail) {
		
		this.mailservice=webemail;
		}


	


	public ArrayList<home_information> byType(String type) {
		 spec = new ByTypeSpec (type);
		
		 
		return checkSpec(spec);
	}


	public ArrayList<home_information> byPlacement(String place) {
		
		spec = new ByPlaceSpec (place);
		return checkSpec(spec);
		
	}
	

	
	public ArrayList<home_information> printResult() {
		

		if (homeResult.isEmpty()) {
			System.out.println("There is no house with such specifications :( ");	
		}
		else
			
		for (home_information home : homeResult) {
			home.printHomeInfo();
			
		}
		
		return homeResult;
	}

	
	
	
	public ArrayList<home_information> byPrice(int price) {
		
	 spec = new ByPriceBelowSpec (price);
	 return checkSpec(spec);
	}
	
	
	
	

	public  ArrayList<home_information> byMaterial(String material) {
		 spec = new ByMaterialSpec (material);
		return checkSpec(spec);

	}

	public ArrayList<home_information> byNumberOfBedrooms(int numberOfBedrooms) {
		 spec = new ByNumberOfBedroomsSpec (numberOfBedrooms);
		return checkSpec(spec);
	}

	public ArrayList<home_information> byNumberOfBathrooms(int numberOfBathrooms) {
		
		 spec = new ByNumberOfBathroomsSpec ( numberOfBathrooms);
		return checkSpec(spec);
	}

	public ArrayList<home_information> betweenRangeOfPrice(int lowPrice, int highPrice) {
		
		 spec = new ByRangeOfPriceSpec ( lowPrice,highPrice);
		 
		return checkSpec(spec);
	}

	public ArrayList<home_information> betweenRangeOfarea(int lowArea, int highArea) {
		
		
		 spec = new ByRangeOfAreaSpec ( lowArea,highArea);
		 
		return checkSpec(spec);
	}

	public  ArrayList<home_information> byAreaBelow(int area1) {
		 
		 spec = new ByAreaBelowSpec ( area1);
		
		 

		return checkSpec(spec);
	}



	public  ArrayList<home_information>  byAllowingPets(boolean pets) {
		
		 spec = new ByAllowingPetsSpec ( pets);
	     

		return checkSpec(spec);

	}


	public  ArrayList<home_information> byLeaseLength(int leaseLength) {
		
		 spec = new ByLeaseLengthSpec ( leaseLength);
		 

		
		
		return checkSpec(spec);

	}

	public ArrayList<home_information> byAmenities(String amenity) {
		
		 spec = new ByAmenitySpec ( amenity);
		

		return checkSpec(spec);

	}

	public  ArrayList<home_information> bycombination(ArrayList<home_information> a) {
		
		

		 mailservice.sendMail("hayasam@najah.edu", a);

		
		
		return a;

	}


	private ArrayList<home_information> checkSpec(GeneralSpec spec) {
		//if (homeResult.isEmpty()) return homeResult;
		
		for(home_information a:homeArray1 )
			{
			 
			if (spec.isSpecMatch(a))
				homeResult.add(a);
			
		}
		//mailservice.setReceiverEmailID("hayasam@najah.edu");
		mailservice.sendMail("hayasam@najah.edu", homeResult);
		return homeResult;
	}

	



	

}
package home_search;

import java.util.concurrent.CopyOnWriteArrayList;

public class Search {
   private webEmailservice mailservice;
	CopyOnWriteArrayList<home_information> homeResult;
	boolean flag;
	GeneralSpec spec;


	public Search(CopyOnWriteArrayList<home_information> homeArray) {
		homeResult = homeArray;

	}

	


	public CopyOnWriteArrayList<home_information> byType(String type) {
		 spec = new ByTypeSpec (type);
		mailservice.sendMail("rahafnawas6@gmail.com", checkSpec(spec));
		return checkSpec(spec);
	}









	public CopyOnWriteArrayList<home_information> byPlacement(String place) {
		
		spec = new ByPlaceSpec (place);
		
		return checkSpec(spec);
		
	}
	

	
	public CopyOnWriteArrayList<home_information> printResult() {
		

		if (homeResult.isEmpty()) {
			System.out.println("There is no house with such specifications :( ");	
		}
		else
			
		for (home_information home : homeResult) {
			home.printHomeInfo();
			
		}
		
		return homeResult;
	}

	
	
	
	public CopyOnWriteArrayList<home_information> byPrice(int price) {
		
	 spec = new ByPriceBelowSpec (price);
		
		return checkSpec(spec);
	}
	
	
	
	

	public  CopyOnWriteArrayList<home_information> byMaterial(String material) {
		 spec = new ByMaterialSpec (material);
		
		return checkSpec(spec);

	}

	public CopyOnWriteArrayList<home_information> byNumberOfBedrooms(int numberOfBedrooms) {
		 spec = new ByNumberOfBedroomsSpec (numberOfBedrooms);

		return checkSpec(spec);
	}

	public  CopyOnWriteArrayList<home_information> byNumberOfBathrooms(int numberOfBathrooms) {
		
		 spec = new ByNumberOfBathroomsSpec ( numberOfBathrooms);
		
		return checkSpec(spec);
	}

	public CopyOnWriteArrayList<home_information> betweenRangeOfPrice(int lowPrice, int highPrice) {
		
		 spec = new ByRangeOfPriceSpec ( lowPrice,highPrice);
		
		return checkSpec(spec);
	}

	public CopyOnWriteArrayList<home_information> betweenRangeOfarea(int lowArea, int highArea) {
		
		
		 spec = new ByRangeOfAreaSpec ( lowArea,highArea);
		
		return checkSpec(spec);
	}

	public  CopyOnWriteArrayList<home_information> byAreaBelow(int area1) {
		 
		 spec = new ByAreaBelowSpec ( area1);
		
		
		return checkSpec(spec);
	}



	public  CopyOnWriteArrayList<home_information>  byAllowingPets(boolean pets) {
		
		 spec = new ByAllowingPetsSpec ( pets);
		
		return checkSpec(spec);

	}


	public  CopyOnWriteArrayList<home_information> byLeaseLength(int leaseLength) {
		
		 spec = new ByLeaseLengthSpec ( leaseLength);

		
		
		return checkSpec(spec);

	}

	public CopyOnWriteArrayList<home_information> byAmenities(String amenity) {
		
		 spec = new ByAmenitySpec ( amenity);
		
		return checkSpec(spec);

	}




	private CopyOnWriteArrayList<home_information> checkSpec(GeneralSpec spec) {
		if (homeResult.isEmpty()) return homeResult;
		for (home_information home : homeResult) {
			if (!spec.isSpecMatch(home))
				homeResult.remove(home);
		}
		return homeResult;
	}




	public void setemail(webEmailservice webemail) {
		
		this.mailservice=webemail;
	}


}
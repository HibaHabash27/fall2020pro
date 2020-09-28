package home_search;


import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search_home {
	ArrayList<home_information> home_inf = new ArrayList<home_information>();
	String type;
	int price_less;
	String placement;
	String material  ;
	int number_of_bedroom, lease_len ;
	int number_of_bathroom;
	int low_price , high_price , home_area , low_area , high_area  ;
	boolean pets ; 
   	java.util.List<java.util.List<String>> list;

	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(io.cucumber.datatable.DataTable dataTable) {
		//type [0]*-material [1]* -placement [2]* -pets [3]* - amenties [4] -price [0] -area [1] -bedrooms [2] -bathrooms [3] -leaselength [4]
		
			 String temp = null;
		
			 list=dataTable.asLists();
			 for(int i=0;i<list.size();i++)
				  {temp=list.get(i).toString();
				  java.util.List<String> list2=list.get(i);
				  String ss=list2.get(0);
				  String s2=list2.get(1);
				  String [] tokens=ss.split("_"); 
				  String [] tokens2=s2.split("_");
				  home_information home=new home_information();
					 home.type=tokens[0];
					 home.material=tokens[1];
					 home.placement=tokens[2];
					 if (tokens[3].equalsIgnoreCase("yes"))
						 home.allowing_pets=true;
					 else home.allowing_pets= false ;
					 String[] am = tokens[4].split(",");
					 home.amenties=am;
					 home.price=Integer.parseInt(tokens2[0]);
					 home.area = Integer.parseInt(tokens2[1]);
					 home.number_of_bedrooms=Integer.parseInt(tokens2[2]);
					 home.number_of_bathrooms=Integer.parseInt(tokens2[3]);
					 home.lease_length = Integer.parseInt(tokens2[4]);
					 home_inf.add(home);

				  }


	}

	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
		type = string;

	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		for (home_information home : home_inf) {
			if (home.type.equalsIgnoreCase(type))
				System.out.print(home.placement);
		}

	}

	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer int1) {

		price_less = int1;
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		for (home_information home : home_inf) {
			if (home.price < price_less)
				System.out.print(home.placement);
		}
	}

	@When("i search about home by_placement {string}")
	public void iSearchAboutHomeByPlacement(String string) {
		placement = string;
	}

	@Then("A list of homes that matches the  placement specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		for (home_information home : home_inf) {
			if (home.placement.equalsIgnoreCase(placement))
				System.out.print(home.placement);
		}
	}

	@When("I search about home by_material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		material = string;
	}

	@Then("A list of homes that matches the  material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		for (home_information home : home_inf) {
			if (home.material.equalsIgnoreCase(material))
				System.out.print(home.placement);
		}
	}

	@When("I search about home by_number_of_bedroom {string}")
	public void iSearchAboutHomeByNumberOfBedroom(String string) {
		number_of_bedroom = Integer.parseInt(string);
	}

	@Then("A list of homes that matches the  number_of_bedroom specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBedroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		for (home_information home : home_inf) {
			if (home.number_of_bedrooms == number_of_bedroom)
				System.out.print(home.placement);
		}
	}

	@When("I search about home by_number_of_bathroom {string}")
	public void iSearchAboutHomeByNumberOfBathroom(String string) {
		number_of_bathroom = Integer.parseInt(string);

	}

	@Then("A list of homes that matches the  number_of_bathroom specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBathroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		for (home_information home : home_inf) {
			if (home.number_of_bathrooms == number_of_bathroom)
				System.out.print(home.placement);
		}
	}
	
	
		@When("I search about home between {int} and {int}")
		public void iSearchAboutHomeBetweenAnd(Integer int1, Integer int2) {
		    
		    low_price = int1; 
		    high_price = int2;
		}


		

		@Then("A list of homes that matches the  range of price specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheRangeOfPriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			for (home_information home : home_inf) {
				if (home.price <= high_price && home.price>= low_price)
					System.out.print(home.placement);
		}
		}
		
		

			@When("I search home below area {int}")
			public void iSearchHomeBelowArea(Integer int1) {
			    home_area = int1; 
			}


			

			@Then("A list of homes that matches the area specification should be returned and printed on the console")
			public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
				for (home_information home : home_inf) {
					if (home.area <= home_area )
						System.out.print(home.placement);
			}}
			

				@When("I search about home by_Alolowing pets {string}")
				public void iSearchAboutHomeByAlolowingPets(String string) {
				   if (string.equalsIgnoreCase("yes"))
					   pets = true ;
				   else pets = false ; 
				}


				

				@Then("A list of homes that matches the  Allowing pets specification should be returned and printed on the console")
				public void aListOfHomesThatMatchesTheAllowingPetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
						if (pets = true  )
							{for (home_information home : home_inf) {
								if (home.allowing_pets  )
									System.out.print(home.placement);}}
						else 
							{for (home_information home : home_inf)
								if (home.allowing_pets==false)
								System.out.print(home.placement);}
							
				}
				
				
				
				
				
					@When("I search about home area between {int} and {int}")
					public void iSearchAboutHomeAreaBetweenAnd(Integer int1, Integer int2) {
					   low_area = int1; 
					   high_area = int2 ;
					}


					
					@Then("A list of homes that matches the  range of area specification should be returned and printed on the console")
					public void aListOfHomesThatMatchesTheRangeOfAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
						for (home_information home : home_inf) {
							if (home.area <= high_area && home.area>= low_area)
								System.out.print(home.placement);
						
					}}	
					
					
					

						@When("I search about home by lease length {string}")
						public void iSearchAboutHomeByLeaseLength(String string) {
						    if (string.equalsIgnoreCase("short"))
						       lease_len= 6;
						    else lease_len = 12 ;
						    
						}



						@Then("A list of homes that matches the  lease length specification should be returned and printed on the console")
						public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
							for (home_information home : home_inf) {
								if (home.lease_length==lease_len)
									System.out.print(home.placement);
						}}



							@When("I search about home by Amenities {string}")
							public void iSearchAboutHomeByAmenities(String string) {
							
							}



							@Then("A list of homes that matches the  Amenities specification should be returned and printed on the console")
							public void aListOfHomesThatMatchesTheAmenitiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
							   
							   
							}



					
					
					
					
					
}













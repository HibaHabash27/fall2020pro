package home_search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CopyOnWriteArrayList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search_home {
	CopyOnWriteArrayList<home_information> home_inf = new CopyOnWriteArrayList<home_information>();
	String type;
	int price_less;
	int arealess;
	String placement;
	String material;
	String amenities;
	int numberOfBedroom2, leaseLen;
	int numberOfBathroom2;
	int lowPrice2, highPrice2, homeArea2, lowArea2, highArea2;
	boolean pets;
	String leaseLength;
	java.util.List<java.util.List<String>> list;
	Search search;

	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(io.cucumber.datatable.DataTable dataTable) {
		


		list = dataTable.asLists();
		for (int i = 0; i < list.size(); i++) {
			
			java.util.List<String> list2 = list.get(i);
			String ss = list2.get(0);
			String s2 = list2.get(1);
			String[] tokens = ss.split("_");
			String[] tokens2 = s2.split("_");
			home_information home = new home_information();
			home.setId(i+1);
			home.setType(tokens[0]);
			home.setMaterial(tokens[1]);
			home.setPlacement(tokens[2]);
			if (tokens[3].equalsIgnoreCase("yes"))
				home.setAllowingPets(true);
			
			else
				home.setAllowingPets(false);
			String[] am = tokens[4].split(",");
			home.setAmenties(am);
			home.setPrice(Integer.parseInt(tokens2[0]));
			home.setArea(Integer.parseInt(tokens2[1]));
			home.setNumberOfBathrooms(Integer.parseInt(tokens2[3]));
			home.setNumberOfBedrooms(Integer.parseInt(tokens2[2]));
			home.setLeaseLength(Integer.parseInt(tokens2[4]));
			
			
			home_inf.add(home);
			
			

		}
		search = new Search(home_inf);

	}
	CopyOnWriteArrayList<home_information> check = new CopyOnWriteArrayList<home_information>();
	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
		type=string;
		check=null;
		check=search.byType(string);
		for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.type, type);
			
		}

	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by type: "+type);
		search.printResult();
		

	}

	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer int1) {
       price_less=int1;
       check=null;
		check=search.byPrice(int1);
		for(home_information homeCheck:check)
		{
			assertTrue(homeCheck.price<int1);
			
		}
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by price less than "+price_less);
		search.printResult();
	}

	@When("i search about home by_placement {string}")
	public void iSearchAboutHomeByPlacement(String string) {
		placement=string;
		check=null;
		check=search.byPlacement(string);
		for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.placement, placement);
			
		}
	}

	@Then("A list of homes that matches the  placement specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by placement :"+ placement);
        search.printResult();
	}

	@When("I search about home by_material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		material=string;
		check=null;
		check=search.byMaterial(string);
		for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.material, material);
			
		}
	}

	@Then("A list of homes that matches the  material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by material :" +material);
		search.printResult();
	}

	
		@When("I search about home by_number_of_bedroom {string}")
		public void iSearchAboutHomeByNumberOfBedroom(String string) {
			numberOfBedroom2 = Integer.parseInt(string);
			check=null;
			check=search.byNumberOfBedrooms(numberOfBedroom2);
			for(home_information homeCheck:check)
			{
				assertEquals(homeCheck.numberOfBedroom,numberOfBedroom2);
				
			}
			
		}



		@Then("A list of homes that matches the  number_of_bedroom specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheNumberOfBedroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			System.out.println("Search by number of bedrooms :" +numberOfBedroom2);
			search.printResult();
		}


		@When("I search about home by_number_of_bathroom {string}")
		public void iSearchAboutHomeByNumberOfBathroom(String string) {
			numberOfBathroom2 = Integer.parseInt(string);
			
		}


	
		@Then("A list of homes that matches the  number_of_bathroom specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheNumberOfBathroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			System.out.println("Search by number of bathrooms :" +numberOfBathroom2);
			check=null;
			check=search.byNumberOfBathrooms(numberOfBathroom2);
			for(home_information homeCheck:check)
			{
				assertTrue(homeCheck.numberOfBathroom1==numberOfBathroom2);
				
			}
			search.printResult();
		}

	@When("I search about home between {int} and {int}")
	public void iSearchAboutHomeBetweenAnd(Integer int1, Integer int2) {
		lowPrice2 = int1;
		highPrice2 = int2;
		search.betweenRangeOfPrice(lowPrice2, highPrice2);

	}

	@Then("A list of homes that matches the  range of price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfPriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by price between "+ lowPrice2 +","+ highPrice2);
		check=null;
		check=search.betweenRangeOfPrice(lowPrice2, highPrice2);
		for(home_information homeCheck:check)
		{
			assertTrue(homeCheck.price>lowPrice2 && homeCheck.price<highPrice2);
			
		}
		search.printResult();
	}

	@When("I search home below area {int}")
	public void iSearchHomeBelowArea(Integer int1) {
		arealess=int1;
		//search.byAreaBelow(arealess.intValue());
	}

	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by area less than "+arealess);
		check=null;
		check=search.byAreaBelow(arealess);
		for(home_information homeCheck:check)
		{
			assertTrue(homeCheck.area<arealess);
			
		}
		search.printResult();
	}

	@When("I search about home by_Alolowing pets {string}")
	public void iSearchAboutHomeByAlolowingPets(String string) {
		if (string.equalsIgnoreCase("yes"))
			pets = true;
		else
			pets = false;
		
	}

	@Then("A list of homes that matches the  Allowing pets specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAllowingPetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by allowing pets");
        check=null;
        check=search.byAllowingPets(pets);
        for(home_information homeCheck:check)
		{
			assertEquals(homeCheck.allowingPets1,pets);
			
		}
		search.printResult();

	}

	@When("I search about home area between {int} and {int}")
	public void iSearchAboutHomeAreaBetweenAnd(Integer int1, Integer int2) {
		lowArea2 = int1;
		highArea2 = int2;

	}

	@Then("A list of homes that matches the  range of area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by area between "+lowArea2+" , "+highArea2);
		check=null;
		check=search.betweenRangeOfarea(lowArea2, highArea2);
		 for(home_information homeCheck:check)
			{
				assertTrue(homeCheck.area>lowArea2&&homeCheck.area<highArea2);
				
			}
		search.printResult();

	}

	@When("I search about home by lease length {string}")
	public void iSearchAboutHomeByLeaseLength(String string) {
		leaseLength=string;
		if (string.equalsIgnoreCase("short"))
			leaseLen = 6;
		else
			leaseLen = 12;

	}

	@Then("A list of homes that matches the  lease length specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by lease length :" +leaseLength);
		check=null;
		check=search.byLeaseLength(leaseLen);
		for(home_information homeCheck:check)
		{
			assertEquals(leaseLen,homeCheck.leaseLength1);
			
		}
		search.printResult();
	}

	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String string) {
		amenities = string;
		search.byAmenities(amenities);

	}

	@Then("A list of homes that matches the  Amenities specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAmenitiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by amenities :"+ amenities);
		search.printResult();

	}
	
	

		@Then("A list of homes that matches the previous specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesThePreviousSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			System.out.println("Search more than one attribute");

			search.printResult();

		}




}






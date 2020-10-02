package home_search;

import java.util.concurrent.CopyOnWriteArrayList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search_home {
	CopyOnWriteArrayList<home_information> home_inf = new CopyOnWriteArrayList<home_information>();
	String type;
	int price_less;
	String placement;
	String material;
	String amenities;
	int number_of_bedroom, lease_len;
	int number_of_bathroom;
	int low_price, high_price, home_area, low_area, high_area;
	boolean pets;
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
				home.setAllowing_pets(true);
			
			else
				home.setAllowing_pets(false);
			String[] am = tokens[4].split(",");
			home.setAmenties(am);
			home.setPrice(Integer.parseInt(tokens2[0]));
			home.setArea(Integer.parseInt(tokens2[1]));
			home.setNumber_of_bathrooms(Integer.parseInt(tokens2[3]));
			home.setNumber_of_bedrooms(Integer.parseInt(tokens2[2]));
			home.setLease_length(Integer.parseInt(tokens2[4]));
			
			
			home_inf.add(home);
			
			

		}
		search = new Search(home_inf);

	}

	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
		search.searchByType(string);

	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();

	}

	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer int1) {

		search.searchByPrice(int1);
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("i search about home by_placement {string}")
	public void iSearchAboutHomeByPlacement(String string) {
		search.searchByPlacement(string);
	}

	@Then("A list of homes that matches the  placement specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search about home by_material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		search.searchByMaterial(string);
	}

	@Then("A list of homes that matches the  material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search about home by_number_of_bedroom {string}")
	public void iSearchAboutHomeByNumberOfBedroom(String string) {
		number_of_bedroom = Integer.parseInt(string);
		search.searchByNumberOfBedrooms(number_of_bedroom);
	}

	@Then("A list of homes that matches the  number_of_bedroom specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBedroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search about home by_number_of_bathroom {string}")
	public void iSearchAboutHomeByNumberOfBathroom(String string) {
		number_of_bathroom = Integer.parseInt(string);
		search.searchByNumberOfBathrooms(number_of_bathroom);

	}

	@Then("A list of homes that matches the  number_of_bathroom specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBathroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search about home between {int} and {int}")
	public void iSearchAboutHomeBetweenAnd(Integer int1, Integer int2) {
		low_price = int1;
		high_price = int2;
		search.searchBetweenRangeOfPrice(low_price, high_price);

	}

	@Then("A list of homes that matches the  range of price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfPriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search home below area {int}")
	public void iSearchHomeBelowArea(Integer int1) {
		search.searchByAreaBelow(int1.intValue());
	}

	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search about home by_Alolowing pets {string}")
	public void iSearchAboutHomeByAlolowingPets(String string) {
		if (string.equalsIgnoreCase("yes"))
			pets = true;
		else
			pets = false;
		search.searchByAllowingPets(pets);
	}

	@Then("A list of homes that matches the  Allowing pets specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAllowingPetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();

	}

	@When("I search about home area between {int} and {int}")
	public void iSearchAboutHomeAreaBetweenAnd(Integer int1, Integer int2) {
		low_area = int1;
		high_area = int2;
		search.searchBetweenRangeOfarea(low_area, high_area);

	}

	@Then("A list of homes that matches the  range of area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();

	}

	@When("I search about home by lease length {string}")
	public void iSearchAboutHomeByLeaseLength(String string) {
		if (string.equalsIgnoreCase("short"))
			lease_len = 6;
		else
			lease_len = 12;
		search.byLeaseLength(lease_len);

	}

	@Then("A list of homes that matches the  lease length specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();
	}

	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String string) {
		amenities = string;
		search.searchByAmenities(amenities);

	}

	@Then("A list of homes that matches the  Amenities specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAmenitiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		search.printResult();

	}
	
	

		@Then("A list of homes that matches the previous specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesThePreviousSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
			search.printResult();

		}




}






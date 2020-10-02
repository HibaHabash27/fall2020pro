package home_search;

import java.util.concurrent.CopyOnWriteArrayList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search_home {
	CopyOnWriteArrayList<home_information> home_inf = new CopyOnWriteArrayList<home_information>();
	String type;
	int price_less;
	int area_less;
	String placement;
	String material;
	String amenities;
	int number_of_bedroom, lease_len;
	int number_of_bathroom;
	int low_price, high_price, home_area, low_area, high_area;
	boolean pets;
	String lease_length;
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
		type=string;
		search.byType(string);

	}

	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by type: "+type);
		search.printResult();

	}

	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer int1) {
       price_less=int1;
		search.byPrice(int1);
	}

	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by price less than "+price_less);
		search.printResult();
	}

	@When("i search about home by_placement {string}")
	public void iSearchAboutHomeByPlacement(String string) {
		placement=string;
		search.byPlacement(string);
	}

	@Then("A list of homes that matches the  placement specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePlacementSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by placement :"+ placement);
        search.printResult();
	}

	@When("I search about home by_material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		material=string;
		search.byMaterial(string);
	}

	@Then("A list of homes that matches the  material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by material :" +material);
		search.printResult();
	}

	@When("I search about home by_number_of_bedroom {string}")
	public void iSearchAboutHomeByNumberOfBedroom(String string) {
		number_of_bedroom = Integer.parseInt(string);
		search.byNumberOfBedrooms(number_of_bedroom);
	}

	@Then("A list of homes that matches the  number_of_bedroom specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBedroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by number of bedrooms :" +number_of_bedroom);
		search.printResult();
	}

	@When("I search about home by_number_of_bathroom {string}")
	public void iSearchAboutHomeByNumberOfBathroom(String string) {
		number_of_bathroom = Integer.parseInt(string);
		search.byNumberOfBathrooms(number_of_bathroom);

	}

	@Then("A list of homes that matches the  number_of_bathroom specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheNumberOfBathroomSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by number of bathrooms :" +number_of_bathroom);
		search.printResult();
	}

	@When("I search about home between {int} and {int}")
	public void iSearchAboutHomeBetweenAnd(Integer int1, Integer int2) {
		low_price = int1;
		high_price = int2;
		search.betweenRangeOfPrice(low_price, high_price);

	}

	@Then("A list of homes that matches the  range of price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfPriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by price between "+ low_price +","+ high_price);
		search.printResult();
	}

	@When("I search home below area {int}")
	public void iSearchHomeBelowArea(Integer int1) {
		area_less=int1;
		search.byAreaBelow(int1.intValue());
	}

	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by area less than "+area_less);

		search.printResult();
	}

	@When("I search about home by_Alolowing pets {string}")
	public void iSearchAboutHomeByAlolowingPets(String string) {
		if (string.equalsIgnoreCase("yes"))
			pets = true;
		else
			pets = false;
		search.byAllowingPets(pets);
	}

	@Then("A list of homes that matches the  Allowing pets specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheAllowingPetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by allowing pets");

		search.printResult();

	}

	@When("I search about home area between {int} and {int}")
	public void iSearchAboutHomeAreaBetweenAnd(Integer int1, Integer int2) {
		low_area = int1;
		high_area = int2;
		search.betweenRangeOfarea(low_area, high_area);

	}

	@Then("A list of homes that matches the  range of area specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheRangeOfAreaSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by area between "+low_area+" , "+high_area);
		search.printResult();

	}

	@When("I search about home by lease length {string}")
	public void iSearchAboutHomeByLeaseLength(String string) {
		lease_length=string;
		if (string.equalsIgnoreCase("short"))
			lease_len = 6;
		else
			lease_len = 12;
		search.byLeaseLength(lease_len);

	}

	@Then("A list of homes that matches the  lease length specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheLeaseLengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		System.out.println("Search by lease length :" +lease_length);
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






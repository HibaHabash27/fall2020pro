package home_search;

public class ByNumberOfBedroomsSpec implements GeneralSpec {

	private int numberOfBedrooms;

	public ByNumberOfBedroomsSpec(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
		// TODO Auto-generated constructor stub
	}

	public boolean isSpecMatch(home_information home) {
		return home.numberOfBedroom == numberOfBedrooms;

	}

}

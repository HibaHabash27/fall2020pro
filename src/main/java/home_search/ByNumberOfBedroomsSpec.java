package home_search;

public class ByNumberOfBedroomsSpec implements GeneralSpec {

	private int numberOfBedrooms;

	public ByNumberOfBedroomsSpec(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public boolean isSpecMatch(Homeinformation home) {
		
		
		return home.numberOfBedroom == numberOfBedrooms;

	}

}

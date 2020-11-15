package home_search;

public class ByNumberOfBathroomsSpec implements GeneralSpec {

	private int numberOfBathrooms;

	public ByNumberOfBathroomsSpec(int numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public boolean isSpecMatch(Homeinformation home) {
		return home.numberOfBathroom1 == numberOfBathrooms;

	}

}

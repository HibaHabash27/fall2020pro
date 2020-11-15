package home_search;

public class ByPlaceSpec implements GeneralSpec {

	private String place;

	public ByPlaceSpec(String place) {
		this.place = place;
		
	}

public boolean isSpecMatch(Homeinformation home) {
	return home.placement.equalsIgnoreCase(this.place);

}

}

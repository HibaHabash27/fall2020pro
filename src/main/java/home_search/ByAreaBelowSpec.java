package home_search;

public class ByAreaBelowSpec implements GeneralSpec {

	private int area1;

	public ByAreaBelowSpec(int area1) {
		this.area1 = area1;
		
	}

	public boolean isSpecMatch(home_information home) {
		// TODO Auto-generated method stub
		return home.area < area1;
	}

}

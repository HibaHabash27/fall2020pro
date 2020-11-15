package home_search;

public class ByTypeSpec implements GeneralSpec {

	private String type;

	public ByTypeSpec(String type) {
		this.type = type;
		
	}
	
	public boolean isSpecMatch(Homeinformation home) {
		return home.type.equalsIgnoreCase(this.type);
	}

}

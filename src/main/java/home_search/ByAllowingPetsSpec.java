package home_search;

public class ByAllowingPetsSpec implements GeneralSpec {

	private boolean pets;

	public ByAllowingPetsSpec(boolean pets) {
		this.pets = pets;
		
	}

	public boolean isSpecMatch(Homeinformation home) {
		
		return (home.allowingPets1==pets);	
		}

}

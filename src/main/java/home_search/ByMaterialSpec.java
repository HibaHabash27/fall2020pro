package home_search;

public class ByMaterialSpec implements GeneralSpec {

	private String material;

	public ByMaterialSpec(String material) {
		this.material = material;
	}

	  public boolean isSpecMatch(Homeinformation home) {
			return home.material.equalsIgnoreCase(material);

			
	}
	}



package home_search;

public class ByMaterialSpec implements GeneralSpec {

	private String material;

	public ByMaterialSpec(String material) {
		this.material = material;
		// TODO Auto-generated constructor stub
	}

	  public boolean isSpecMatch(home_information home) {
			return home.material.equalsIgnoreCase(material);

	}
	}



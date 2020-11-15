package home_search;

public class ByPriceBelowSpec implements GeneralSpec {

	private int price;

	public ByPriceBelowSpec(int price) {
		this.price = price;
		
	}

	public boolean isSpecMatch(Homeinformation home) {
		return home.price<=this.price;

	}
}

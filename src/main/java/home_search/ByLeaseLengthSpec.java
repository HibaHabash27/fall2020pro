package home_search;

public class ByLeaseLengthSpec implements GeneralSpec {

	private int leaseLength;

	public ByLeaseLengthSpec(int leaseLength) {
		this.leaseLength = leaseLength;
		
	}

	public boolean isSpecMatch(Homeinformation home) {
		return home.leaseLength1 == leaseLength;
	}
}

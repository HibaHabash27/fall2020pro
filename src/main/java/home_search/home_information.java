package home_search;

public class home_information {
	int id ;
	String type;
	String placement;
	int price;
	int area;
	boolean lessAreaYes;
	boolean betweenAreaYes;
	boolean lessPriceYes;
	boolean betweenPriceYes;
	String material;
	int numberOfBedroom;
	int numberOfBathroom1;
	boolean allowingPets1 ; 
	int leaseLength1;
	String[]amenties;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlacement() {
		return placement;
	}
	public void setPlacement(String placement) {
		this.placement = placement;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getNumberOfBedrooms() {
		return numberOfBedroom;
	}
	public void setNumberOfBedrooms(int numberOfBedroom) {
		this.numberOfBedroom = numberOfBedroom;
	}
	public int getNumberOfBathrooms() {
		return numberOfBathroom1;
	}
	public void setNumberOfBathrooms(int numberOfBathroom1) {
		this.numberOfBathroom1 = numberOfBathroom1;
	}
	public boolean isAllowingPets() {
		return allowingPets1;
	}
	public void setAllowingPets(boolean allowingPets1) {
		this.allowingPets1 = allowingPets1;
	}
	public int getLeaseLength() {
		return leaseLength1;
	}
	public void setLeaseLength(int leaseLength1) {
		this.leaseLength1 = leaseLength1;
	}
	public String[] getAmenties() {
		return amenties;
	}
	public void setAmenties(String[] amenties) {
		this.amenties = amenties;
	}
	

}

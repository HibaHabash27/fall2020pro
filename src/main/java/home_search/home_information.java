package home_search;

public class home_information {
	int id ;
	String type;
	String placement;
	int price;
	int area;
	String material;
	int number_of_bedrooms;
	int number_of_bathrooms;
	boolean allowing_pets ; 
	int lease_length;
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
	public int getNumber_of_bedrooms() {
		return number_of_bedrooms;
	}
	public void setNumber_of_bedrooms(int number_of_bedrooms) {
		this.number_of_bedrooms = number_of_bedrooms;
	}
	public int getNumber_of_bathrooms() {
		return number_of_bathrooms;
	}
	public void setNumber_of_bathrooms(int number_of_bathrooms) {
		this.number_of_bathrooms = number_of_bathrooms;
	}
	public boolean isAllowing_pets() {
		return allowing_pets;
	}
	public void setAllowing_pets(boolean allowing_pets) {
		this.allowing_pets = allowing_pets;
	}
	public int getLease_length() {
		return lease_length;
	}
	public void setLease_length(int lease_length) {
		this.lease_length = lease_length;
	}
	public String[] getAmenties() {
		return amenties;
	}
	public void setAmenties(String[] amenties) {
		this.amenties = amenties;
	}
	

}

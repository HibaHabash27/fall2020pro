package home_search;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Search {
	CopyOnWriteArrayList<home_information> home_result;
	boolean flag;

	public Search(CopyOnWriteArrayList<home_information> home_array) {
		home_result = home_array;
	}

	public void searchByType(String type) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.type.equalsIgnoreCase(type))
				continue;
			else
				home_result.remove(home);
		}

	}

	public void searchByPlacement(String place) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.placement.equalsIgnoreCase(place))
				continue;
			else
				home_result.remove(home);
		}
	}

	public CopyOnWriteArrayList<home_information> printResult() {
		
		System.out.println();
		System.out.println();
		if (home_result.isEmpty()) {
			System.out.println("There is no house with such specifications :( ");
		}
		else
		for (home_information home : home_result) {
			System.out.println("Home [ id="+home.id+ " , type:" +home.type + " , Material:" + home.material + " , Placement:" + home.placement+ " ]");
			// type [0]*-material [1]* -placement [2]* -pets [3]* - amenties [4] -price [0]
			// -area [1] -bedrooms [2] -bathrooms [3] -leaselength [4]
		}
		return home_result;
	}

	public void searchByPrice(int price) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.price < price)
				continue;
			else
				home_result.remove(home);
		}
	}

	public void searchByMaterial(String string) {
		for (home_information home : home_result) {
			if (home.material.equalsIgnoreCase(string))
				continue;
			else
				home_result.remove(home);
		}

	}

	public void searchByNumberOfBedrooms(int NOB) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.number_of_bedrooms == NOB)
				continue;
			else
				home_result.remove(home);
		}
	}

	public void searchByNumberOfBathrooms(int NOB) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.number_of_bathrooms == NOB)
				continue;
			else
				home_result.remove(home);
		}
	}

	public void searchBetweenRangeOfPrice(int low_price, int high_price) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.price <= high_price && home.price >= low_price)
				continue;
			else
				home_result.remove(home);

		}
	}

	public void searchBetweenRangeOfarea(int low_area, int high_area) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.area <= high_area && home.area >= low_area)
				continue;
			else
				home_result.remove(home);

		}
	}

	public void searchByAreaBelow(int Area) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.area <= Area)
				continue;
			else
				home_result.remove(home);

		}
	}

	public void searchByAllowingPets(boolean pets) {
		if (home_result.isEmpty()) return;
		if (pets = true) {
			for (home_information home : home_result) {
				if (home.allowing_pets)
					continue;
				else
					home_result.remove(home);
			}
		} else {
			for (home_information home : home_result)
				if (home.allowing_pets == false)
					continue;
				else
					home_result.remove(home);
		}

	}

	public void byLeaseLength(int lease_len) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.lease_length == lease_len)
				continue;
			else
				home_result.remove(home);
		}

	}

	public void searchByAmenities(String amenities) {
		if (home_result.isEmpty()) return;
		flag = false;
		for (home_information home : home_result) {
			for (String am : home.amenties) {
				if (amenities.equalsIgnoreCase(am)) {
					flag = true;
					break;
				}

			}
			if (flag == true)
				continue;
			else
				home_result.remove(home);
		}

	}


}
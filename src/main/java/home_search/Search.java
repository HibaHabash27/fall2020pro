package home_search;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Search {
	CopyOnWriteArrayList<home_information> home_result;
	boolean flag;

	public Search(CopyOnWriteArrayList<home_information> home_array) {
		home_result = home_array;
	}

	public void byType(String type) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.type.equalsIgnoreCase(type))
				continue;
			else
				home_result.remove(home);
		}

	}

	public void byPlacement(String place) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.placement.equalsIgnoreCase(place))
				continue;
			else
				home_result.remove(home);
		}
	}

	public CopyOnWriteArrayList<home_information> printResult() {
		

		if (home_result.isEmpty()) {
			System.out.println("There is no house with such specifications :( ");
		}
		else
		for (home_information home : home_result) {
			System.out.println("Home[id="+home.id+ " ,type:" +home.type + " ,Material:" + home.material + " ,Placement:" + home.placement+"  ,price:"+home.price+" ,area:"+home.area+" ,number of bathrooms"+ home.number_of_bathrooms+",number of bedrooms:"+home.number_of_bedrooms+"  ,lease length :" +home.lease_length+"  ,allowing pets :"+home.allowing_pets+",amenties :");
			
			for(int i=0;i<home.amenties.length;i++)	
		    {
				System.out.print(home.amenties[i]+"_");
		    }
			System.out.print("]");
			System.out.println();
			System.out.println();
			
		}
		return home_result;
	}

	public void byPrice(int price) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.price < price)
				continue;
			else
				home_result.remove(home);
		}
	}

	public void byMaterial(String string) {
		for (home_information home : home_result) {
			if (home.material.equalsIgnoreCase(string))
				continue;
			else
				home_result.remove(home);
		}

	}

	public void byNumberOfBedrooms(int NOB) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.number_of_bedrooms == NOB)
				continue;
			else
				home_result.remove(home);
		}
	}

	public void byNumberOfBathrooms(int NOB) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.number_of_bathrooms == NOB)
				continue;
			else
				home_result.remove(home);
		}
	}

	public void betweenRangeOfPrice(int low_price, int high_price) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.price <= high_price && home.price >= low_price)
				continue;
			else
				home_result.remove(home);

		}
	}

	public void betweenRangeOfarea(int low_area, int high_area) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.area <= high_area && home.area >= low_area)
				continue;
			else
				home_result.remove(home);

		}
	}

	public void byAreaBelow(int Area) {
		if (home_result.isEmpty()) return;
		for (home_information home : home_result) {
			if (home.area <= Area)
				continue;
			else
				home_result.remove(home);

		}
	}

	public void byAllowingPets(boolean pets) {
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

	public void byAmenities(String amenities) {
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
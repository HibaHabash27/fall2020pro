package home_search;

import java.util.concurrent.CopyOnWriteArrayList;

public class Search {

	CopyOnWriteArrayList<home_information> homeresult;
	boolean flag;

	public Search(CopyOnWriteArrayList<home_information> homearray) {
		homeresult = homearray;
	}

	public CopyOnWriteArrayList<home_information> byType(String type) {
		
		if (homeresult.isEmpty())
			return homeresult;
		for (home_information home : homeresult) {
			if (!home.type.equalsIgnoreCase(type))
				homeresult.remove(home);
			
		}
		 return homeresult;

	}

	public CopyOnWriteArrayList<home_information> byPlacement(String place) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (!home.placement.equalsIgnoreCase(place))
				homeresult.remove(home);
		}
		 return homeresult;
		
	}

	public CopyOnWriteArrayList<home_information> printResult() {
		

		if (homeresult.isEmpty()) {
			System.out.println("There is no house with such specifications :( ");
			
		}
		else
		{
		for (home_information home : homeresult) {
			System.out.println("Home[id="+home.id+ " ,type:" +home.type + " ,Material:" + home.material + " ,Placement:" + home.placement+"  ,price:"+home.price+" ,area:"+home.area+" ,number of bathrooms"+ home.numberOfBathroom1+",number of bedrooms:"+home.numberOfBedroom+"  ,lease length :" +home.leaseLength1+"  ,allowing pets :"+home.allowingPets1+",amenties :");
			
			for(int i=0;i<home.amenties.length;i++)	
		    {
				System.out.print(home.amenties[i]+"_");
		    }
			System.out.print("]");
			System.out.println();
			System.out.println();
			
		}
		
		}
		return homeresult;
	}

	public CopyOnWriteArrayList<home_information> byPrice(int price) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (home.price >= price)
		
				homeresult.remove(home);
		}
		 return homeresult;
	}

	public  CopyOnWriteArrayList<home_information> byMaterial(String string) {
		for (home_information home : homeresult) {
			if (!home.material.equalsIgnoreCase(string))
			
				homeresult.remove(home);
		}
		return homeresult;

	}

	public CopyOnWriteArrayList<home_information> byNumberOfBedrooms(int nob) {
	
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (home.numberOfBedroom != nob)
				homeresult.remove(home);
		}
		return homeresult;
	}

	public  CopyOnWriteArrayList<home_information> byNumberOfBathrooms(int nob) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (home.numberOfBathroom1 != nob)
				homeresult.remove(home);
		}
		return homeresult;
	}

	public CopyOnWriteArrayList<home_information> betweenRangeOfPrice(int lowprice, int highprice) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (!(home.price <= highprice && home.price >= lowprice))
				homeresult.remove(home);
			

		}
		return homeresult;
	}

	public CopyOnWriteArrayList<home_information> betweenRangeOfarea(int lowarea, int higharea) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (!(home.area <= higharea && home.area >= lowarea))
				homeresult.remove(home);
			

		}
		return homeresult;
	}

	public  CopyOnWriteArrayList<home_information> byAreaBelow(int area1) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (home.area > area1)
				homeresult.remove(home);
			

		}
		return homeresult;
	}

	public  CopyOnWriteArrayList<home_information>  byAllowingPets(boolean pets) {
		if (homeresult.isEmpty()) return homeresult;
		if (pets) {
			for (home_information home : homeresult) {
				if (!home.allowingPets1)
		
					homeresult.remove(home);
			}
		} else {
			for (home_information home : homeresult)
				if (home.allowingPets1 )
					homeresult.remove(home);
		}
		
		return homeresult;

	}

	public  CopyOnWriteArrayList<home_information> byLeaseLength(int leaselen) {
		if (homeresult.isEmpty()) return homeresult;
		for (home_information home : homeresult) {
			if (home.leaseLength1 != leaselen)
		
				homeresult.remove(home);
		}
		return homeresult;

	}

	public CopyOnWriteArrayList<home_information> byAmenities(String amenities) {
		if (homeresult.isEmpty()) return homeresult;
		flag = false;
		for (home_information home : homeresult) {
			for (String am : home.amenties) {
				if (amenities.equalsIgnoreCase(am)) {
					flag = true;
					break;
				}

			}
			if (!flag)
		
				homeresult.remove(home);
		}
		return homeresult;

	}


}
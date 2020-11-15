package home_search;

import java.util.ArrayList;

public class MultiSpec implements GeneralSpec {

	static ArrayList<home_information> resultarrays= new ArrayList<home_information> ();
	private int areaLow;
	private int areahigh;
	private int priceLow;
	private int pricehigh;
	private int numberOfBedroom;
	private int numberOfBathroom;
	private int leaselength;
	private static webEmailservice mailservice;
	private GeneralSpec spec ;
//Rename arrayList to home repository
	public void searchMore(ArrayList<home_information> arrayLists ,String attributes,String ... valuesToCompare)
	{
		
		if(attributes.equalsIgnoreCase("areaRange"))
		{	 
			

			areaLow=Integer.parseInt(valuesToCompare[0]);
		     areahigh=Integer.parseInt(valuesToCompare[1]);
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				if(a.area <= areahigh && a.area >= areaLow)
					{
					   resultarrays.add(a);
					}
			}
			


		}
		
		else if(attributes.equalsIgnoreCase("priceRange"))
		{	 
			

			priceLow=Integer.parseInt(valuesToCompare[0]);
		    pricehigh=Integer.parseInt(valuesToCompare[1]);
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				if(a.price <= pricehigh && a.price >= priceLow)
					{
					   resultarrays.add(a);
					}
			}
			


		}
		else if(attributes.equalsIgnoreCase("leaseLength"))
		{	 
			
			if(valuesToCompare[0].equalsIgnoreCase("short"))
			       leaselength=6;
			else
				 leaselength=12;
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				if(a.leaseLength1==leaselength)
					{
					   resultarrays.add(a);
					}
			}
			


		}
		
		else if(attributes.equalsIgnoreCase("amenities"))
		{	 
			
            String amenities=valuesToCompare[0];
			
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				for(String amenity:a.amenities)
				{
					if(amenity.equalsIgnoreCase(amenities))
						resultarrays.add(a);
						
				}
			}
			


		}
		else	if(attributes.equalsIgnoreCase("lowprice"))
		{	 
			

			priceLow=Integer.parseInt(valuesToCompare[0]);
		   
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				if(a.price<=priceLow)
					{
					   resultarrays.add(a);
					}
			}
			


		}
		else	if(attributes.equalsIgnoreCase("number_of_bedroom"))
		{	 
			

			numberOfBedroom=Integer.parseInt(valuesToCompare[0]);
		   
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				if(a.numberOfBedroom==numberOfBedroom)
					{
					   resultarrays.add(a);
					}
			}
			


		}
		else if(attributes.equalsIgnoreCase("material"))
		{
			

			
			String material=valuesToCompare[0];
			resultarrays.clear();
			 					
			
			

			for(home_information a:arrayLists)
			{  					

				if(a.material.equalsIgnoreCase(material))
					{

					resultarrays.add(a);
					
					}
				
				
			}

		}
		else	if(attributes.equalsIgnoreCase("number_of_bathroom"))
		{	 
			

			numberOfBathroom=Integer.parseInt(valuesToCompare[0]);
		   
				resultarrays.clear();

			for(home_information a:arrayLists)
			{
				if(a.numberOfBathroom1==numberOfBathroom)
					{
					   resultarrays.add(a);
					}
			}
			


		}
		
		else if(attributes.equalsIgnoreCase("placement"))
		{
			

			String placement=valuesToCompare[0];
			resultarrays.clear();
			System.out.println(placement);

			for(home_information a:arrayLists)
			{
				if(a.placement.equalsIgnoreCase(placement))
				{
					resultarrays.add(a);
				}
			}

		}
		
		else if(attributes.equalsIgnoreCase("lessarea"))
		{
			

			int lessarea=Integer.parseInt(valuesToCompare[0]);
			resultarrays.clear();
			

			for(home_information a:arrayLists)
			{
				if(a.area<=lessarea)
				{
					resultarrays.add(a);
				}
			}

		}
		
		else if(attributes.equalsIgnoreCase("allowingPets"))
		{
			
            spec = ByAllowingPetsSpec ();
			Boolean allowingPets = false;
			if(valuesToCompare[0].equalsIgnoreCase("YES"))
			 allowingPets=true;
			resultarrays.clear();
			 					
			
			

			for(home_information a:arrayLists)
			{  					

				if(a.allowingPets1==allowingPets)
					{

					resultarrays.add(a);
					
					}
				
				
			}
		

		}
		
		
		
		
	}


	public ArrayList<home_information> returnArray()
	{
		

		return resultarrays;
		}
	public void print()
	{

		if (resultarrays.isEmpty()) {
			System.out.println("There is no house with such specifications :( ");	
		}
		else
			
		for (home_information home : resultarrays) {
			home.printHomeInfo();
			
		}
	}


	public boolean isSpecMatch(home_information home) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}

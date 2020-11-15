package home_search;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MultiSpecHandler {
     List<GeneralSpec> specList;
     Search search;
     List<Homeinformation> resultArrayList;
	private List<Homeinformation> homeArray;
	boolean firstSpec = true;
	 public static final Logger LOGGER = Logger.getLogger(MultiSpecHandler.class.getName());
	public MultiSpecHandler(List<GeneralSpec> specList , List<Homeinformation> homeArray) {
		super();
		this.specList = new ArrayList<GeneralSpec>(specList);
		this.homeArray= new ArrayList<Homeinformation>(homeArray);
		
		
	}

	

	public List<Homeinformation> result(){
		
		
		for (GeneralSpec spec : specList) {
			
			if (firstSpec) {
			for (int i=0;i<homeArray.size();i++) {
				search= new Search ((ArrayList<Homeinformation>) homeArray);
				resultArrayList=search.checkSpec(spec);
			
			} firstSpec=false;}
			else 
			{
				for (int j=0;j<resultArrayList.size();j++) {
			     search= new Search((ArrayList<Homeinformation>) resultArrayList);
			     resultArrayList=search.checkSpec(spec);
						
			}
			}
		}
		
		
		
		search.bycombination( resultArrayList);
		return resultArrayList;
	}




	public void print() {
		if (resultArrayList.isEmpty()) {
			LOGGER.info("There is no house with such specifications :( ");	
		}
		else
		{	
		for (Homeinformation home : resultArrayList) {
			home.printHomeInfo();
			
		}
		}
		
	} 
	
	
	
	
	
	
}

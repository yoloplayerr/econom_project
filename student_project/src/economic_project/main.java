package economic_project;

import java.util.ArrayList;

public class main {

	public static double mnk(ArrayList<String> text) {
		ArrayList<Double> be=new ArrayList<>();
		double y=0;	
			
			for (int i=0;i<text.size();i++) {
				be.add(Double.parseDouble(text.get(i)));
			}
	       for (int i=0;i<text.size();i++) {
	    	y+=be.get(i);
	       }
	      
		
	       return y;
	    }	
    
	}



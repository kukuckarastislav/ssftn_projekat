package util;

import java.util.Comparator;

public class StudIndeksComparator implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		String indesk1[] = arg0.split("-");
		String indesk2[] = arg1.split("-");
		
		int redniBroj1 = Integer.parseInt(indesk1[1]);
		int redniBroj2 = Integer.parseInt(indesk2[1]);
		
		int godina1 = Integer.parseInt(indesk1[2]);
		int godina2 = Integer.parseInt(indesk2[2]);
		
		// uporedimo smerove ako su oba studenta istog smera npr RA onda treba brojke poredjivati
		int retVal = indesk1[0].compareTo(indesk2[0]);
		if(retVal == 0) {
			// uporedimo godine upisa
			retVal = godina1 - godina2;
			// ako su iste godine, onda uporedimo redne brojeve
			if(retVal == 0) {
				retVal = redniBroj1 - redniBroj2;
			}
		}
		
		return retVal;
	}
	
}
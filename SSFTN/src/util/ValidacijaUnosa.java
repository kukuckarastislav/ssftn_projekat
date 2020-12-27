package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaProfesori;
import model.BazaStudenti;

public class ValidacijaUnosa {
	
	public static boolean validImePrz(String text) {
		if(text == null) return false;
		// za ime i prezime vazi isto, validna su slova, a ne smeju se javljati brojevi
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		// provera dal se javlja number
		for(int i = 0; i < text.length(); i++) {
			if(Character.isDigit(text.charAt(i))){
				return false;
			}
		}
		return true;
		
	}

	public static boolean validDatum(String text) {
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		


		String sEl[] = text.split("\\.");

		if(sEl.length != 3) return false;
		
		if(sEl[0].length() > 2) return false;
		if(sEl[1].length() > 2) return false;
		
		for(int i = 0; i < sEl[0].length(); i++) {
			if( !Character.isDigit(sEl[0].charAt(i)) ) return false;
		}				
		for(int i = 0; i < sEl[1].length(); i++) {
			if( !Character.isDigit(sEl[1].charAt(i)) ) return false;
		}	
		for(int i = 0; i < sEl[2].length(); i++) {
			if( !Character.isDigit(sEl[2].charAt(i)) ) return false;
		}
		
		if(Integer.parseInt(sEl[2])>2020) return false;
		
		int dan= Integer.parseInt(sEl[0]);
		int mjesec= Integer.parseInt(sEl[1]);
		int god= Integer.parseInt(sEl[2]);
		
		if(dan>31) return false;
		if(mjesec>12) return false;
		if(god>2020) return false;
		
		
		
		// Referenca: https://beginnersbook.com/2013/05/java-date-format-validation/
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		Date datumRodjenja = null;
		try {
			datumRodjenja = dateFormat.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		

		return true;
	}

	public static boolean validBrTel(String text) {
		// dozvoljavamo samo brojeve da unese 
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validBrLicne(String text) {
		// dozvoljavamo tacno 9 brojeva 
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		if(text.length()!=9)
			return false;
		if(!BazaProfesori.getInstance().jedinstvenBrLicne(text))
			return false;
		
		return true;
	}
	
	
	
	

	public static boolean validEmail(String text) {
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		// email mora poceti nekim slovom posle moze da bude bilo sta osim praznih karaktera
		// mora da sadrzi jedan karakter @ posle kojeg sledi bar jedan bilo koji karakter
		if( !Character.isAlphabetic(text.charAt(0)) ) return false;
		
		int nMajmuna = 0;
		int indeksMajmuna = -1;
		
		for(int i = 0; i < text.length(); i++) {
			if( Character.isSpaceChar(text.charAt(i)) ) {
				return false;
			}
			if( text.charAt(i) == '@' ) {
				nMajmuna++;
				indeksMajmuna = i;
			}
		}
		
		if(nMajmuna != 1) return false;
		
		//if(Character.isAlphabetic( text.charAt(indeksMajmuna+1) ) ) return false;
		
		return true;
			
	}

	public static boolean validIndeks(String text) {
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		String sEl[] = text.split("-");
		if(sEl.length != 3) return false;
		
		for(int i = 0; i < sEl[0].length(); i++) {
			if( !Character.isAlphabetic( sEl[0].charAt(i) ) ) return false;
		}
		
		for(int i = 0; i < sEl[1].length(); i++) {
			if( !Character.isDigit( sEl[1].charAt(i) ) ) return false;
		}
		
		for(int i = 0; i < sEl[2].length(); i++) {
			if( !Character.isDigit( sEl[2].charAt(i) ) ) return false;
		}
		
		if(!BazaStudenti.getInstance().jedinstvenIndeks(text)) {
			return false;
		}
		
		
		return true;
	}

	public static boolean validGodUpisa(String text) {
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		// ne sme da se unese nista razlicito od brojeva i prva cifra ne sme biti 0
		// broj ne sme imati vise ili manje cifara od 4   npr god upisa 985 haha ili godina upisa 12400
		if( text.length() != 4) return false;
		
		for(int i = 0; i < text.length(); i++) {
			if( !Character.isDigit( text.charAt(i) ) ) return false;
		}
		
		if( text.charAt(0) == '0' ) return false;
		
		
		return true;
	}

	public static boolean validAdresa(String text) {
		if(text == null) return false;
		if(text.isEmpty() || text.isBlank()) {
			return false;
		}
		return true;
	}
	
	
	
	
	

	

}

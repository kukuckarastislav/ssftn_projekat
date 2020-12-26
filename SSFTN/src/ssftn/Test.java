package ssftn;

import java.util.ArrayList;

import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;

public class Test {

	public static void main(String[] args) {
		System.out.println("Pozz SSFTN");
		System.out.println("test test");
		System.out.println("Drugi komit");

		for(int i = 0; i < 10; i++){
			System.out.println("test");			
		}
		
	
		
		
		Profesor prof1 = new Profesor("petrovic", "velko", "1970", "negde", "000", "v@", "NTP111", "333", "prof", "dr");
		
		
		Predmet pr1 = new Predmet("34s", "OS", model.Semestar.LETNJI, 2, prof1, 8);
		

		
		
	}

}

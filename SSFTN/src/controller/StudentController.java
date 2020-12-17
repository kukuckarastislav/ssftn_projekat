package controller;

import model.BazaStudenti;
import model.Student;
import view.Frame1;

public class StudentController {
	
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if(instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {
		
	}
	
	
	public void dodajStudenta(Student st1) {
		//Student st1 = new Student("Kukucka", "Rastislav", "07.01.2020", "BackiPetrovac", 
		//		  "324", "ras@gmail.com", "RA129/2018", 2018, 3, model.Status.B);
		
		BazaStudenti.getInstance().dodajStudenta(st1);
		Frame1.getInstance().azurirajPrikazTabeleStudenata("DODAT", 1);
	}
	
	public void izmeniStudenta() {
		
	}
	
	public void izbrisiStudenta() {
		
	}

}

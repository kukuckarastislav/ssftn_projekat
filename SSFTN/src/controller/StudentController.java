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
		BazaStudenti.getInstance().dodajStudenta(st1);
		Frame1.getInstance().azurirajPrikazTabeleStudenata("DODAT", 1);
	}
	
	public void izmeniStudenta() {
		
	}
	
	public void izbrisiStudenta(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
			return;
		}
		Student student = BazaStudenti.getInstance().getStudent(rowSelectedIndex);
		BazaStudenti.getInstance().izbrisiStudenta(student); 		// mogli smo i indeks poslati al ovako je EFIKASNIJE :)
		
		Frame1.getInstance().azurirajPrikazTabeleStudenata("UKLONJEN", 2);
	}

}

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
	
	public void izmeniStudenta(Student st1, Student st2) {
		st1.setIme(st2.getIme());
		st1.setPrezime(st2.getPrezime());
		st1.setDatumRodjenja(st2.getDatumRodjenja());
		st1.setAdresa(st2.getAdresa());
		st1.setKontaktTelefon(st2.getKontaktTelefon());
		st1.setEmail(st2.getEmail());
		st1.setIndeks(st2.getIndeks());
		st1.setTrenGodStudija(st2.getTrenGodStudija());
		st1.setGodinaUpisa(st2.getGodinaUpisa());
		st1.setStatus(st2.getStatus());
		
		Frame1.getInstance().azurirajPrikazTabeleStudenata("IZMENJEN", 3);
		
	}
	
	public void izbrisiStudenta(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
			return;
		}
		Student student = BazaStudenti.getInstance().getStudent(rowSelectedIndex);
		BazaStudenti.getInstance().izbrisiStudenta(student); 		// mogli smo i indeks poslati al ovako je EFIKASNIJE :)
		
		Frame1.getInstance().azurirajPrikazTabeleStudenata("UKLONJEN", 2);
	}
	
	public Student getStudent(int indexRow) {
		Student student = BazaStudenti.getInstance().getStudent(indexRow);
		return student;
	}

}

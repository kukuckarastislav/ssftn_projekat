package controller;

import java.util.Date;

import model.BazaProfesori;
import model.BazaStudenti;
import model.Profesor;
import model.Student;
import model.Titula;
import model.Zvanje;
import view.Frame1;

public class ProfesorController {
	
	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if(instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {
		
	}
	
	
	public void dodajProfesora(Profesor st1) {
		
		BazaProfesori.getInstance().dodajProfesora(st1);
		Frame1.getInstance().azurirajPrikazTabeleProfesora("DODAT", 1);
	}
	
	public void izmeniProfesora(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		
		BazaProfesori.getInstance().izmeniProfesora(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, adresaKancelarije, brojLicneKarte, titula, zvanje);
		Frame1.getInstance().azurirajPrikazTabeleProfesora("IZMENJEN", 1);
	}
	
	public void izbrisiProfesora(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
			return;
		}
		Profesor prof = BazaProfesori.getInstance().getProfesor(rowSelectedIndex);
		BazaProfesori.getInstance().izbrisiProfesora(prof); 		// mogli smo poslati i licnu kartu ali moze i ovako
	
		Frame1.getInstance().azurirajPrikazTabeleProfesora("UKLONJEN", 2);
	}
	
	public Profesor getProfesor(int rowIndex) {
		
		Profesor p=BazaProfesori.getInstance().getProfesor(rowIndex);		
		return p;
	}

}

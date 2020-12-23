package controller;

import model.BazaProfesori;
import model.Profesor;
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
	
	public void izmeniProfesora(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		
		BazaProfesori.getInstance().izmeniProfesora(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, adresaKancelarije, brojLicneKarte, titula, zvanje);
		Frame1.getInstance().azurirajPrikazTabeleProfesora("IZMENJEN", 1);
	}
	
	public void izbrisiProfesora() {
		
	}
	
	public Profesor getProfesor(int rowIndex) {
		
		Profesor p=BazaProfesori.getInstance().getProfesor(rowIndex);		
		return p;
	}

}

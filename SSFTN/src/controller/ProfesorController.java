package controller;

import java.util.Date;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
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
	public void izmeniProfesora(Profesor aktuelniProfesor, Profesor noviProfesor) {
		aktuelniProfesor.setIme(noviProfesor.getIme());
		aktuelniProfesor.setPrezime(noviProfesor.getPrezime());
		aktuelniProfesor.setDatumRodjenja(noviProfesor.getDatumRodjenja());
		aktuelniProfesor.setAdresaStanovanja(noviProfesor.getAdresaStanovanja());
		aktuelniProfesor.setKontaktTelefon(noviProfesor.getKontaktTelefon());
		aktuelniProfesor.setEmail(noviProfesor.getEmail());
		aktuelniProfesor.setAdresaKancelarije(noviProfesor.getAdresaKancelarije());
		aktuelniProfesor.setBrojLicneKarte(noviProfesor.getBrojLicneKarte());
		aktuelniProfesor.setTitula(noviProfesor.getTitula());
		aktuelniProfesor.setZvanje(noviProfesor.getZvanje());
		
		Frame1.getInstance().azurirajPrikazTabeleProfesora("IZMENEJ", 1);
	}
	
	public void izbrisiProfesora(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
			return;
		}
		Profesor prof = BazaProfesori.getInstance().getProfesor(rowSelectedIndex);
		BazaProfesori.getInstance().izbrisiProfesora(prof); 		// mogli smo poslati i licnu kartu ali moze i ovako
	
		Frame1.getInstance().azurirajPrikazTabeleProfesora("UKLONJEN", 2);
	}
	public void izbrisiProfesoraByLicnaKarta(String licnaKarta) {
		if(licnaKarta != null) {
			Profesor profesor = BazaProfesori.getInstance().getProfesorByLicnaKarta(licnaKarta);
			
			// kad brisemo profesora treba i u predmetu da ga obrisemo u kojima on predaje
			BazaProfesori.getInstance().izbrisiProfesora(profesor);
			
			Frame1.getInstance().azurirajPrikazTabeleProfesora("UKLONJEN", 2);
		}
	}
	
	public Profesor getProfesor(int rowIndex) {
		
		Profesor p=BazaProfesori.getInstance().getProfesor(rowIndex);		
		return p;
	}
	
	public void dodajPredmetProfesoru(Profesor pro,Predmet pre) {
		
		BazaProfesori.getInstance().dodajPredmetProfesoru(pro,pre);
	}

	public Profesor getProfesorByLicnaKarta(String licnaKarta) {
		Profesor prof = BazaProfesori.getInstance().getProfesorByLicnaKarta(licnaKarta);
		return prof;
	}



}

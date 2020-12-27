package model;

import java.util.ArrayList;
import java.util.Date;

public class BazaProfesori {
	
private static BazaProfesori instance = null;
	
	public static BazaProfesori getInstance() {
		if(instance == null) {
			instance = new BazaProfesori();
		}
		return instance;
	}
	
	private ArrayList<Profesor> alProfesori;
	private ArrayList<String> alKolone;
	
	
	private BazaProfesori() {
		
		
		// initProfesors() 	
		alProfesori = new ArrayList<Profesor>();
		
		
		alKolone = new ArrayList<String>();
		alKolone.add("Ime");
		alKolone.add("Prezime");
		alKolone.add("Titula");
		alKolone.add("Zvanje");

	}
	
	
	public ArrayList<Profesor> getProfesori(){
		return alProfesori;
	}
	
	public void setProfesori(ArrayList<Profesor> Profesori) {
		alProfesori = Profesori;
	}
	
	public int getBrKolona() {
		return 4;
	}
	
	public String getNazivKolona(int index) {
		return alKolone.get(index);
	}
	
	public Profesor getProfesor(int rowIndex) {
		return alProfesori.get(rowIndex);
	}
	
	public String getVrednostU(int x, int y) {
		Profesor profesor = alProfesori.get(x);
		switch (y) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getTitula().toString();
		case 3:
			return profesor.getZvanje().toString();
			
		default:
			return null;
		}
	}
	
	public void dodajProfesora(Profesor Profesor) {
		alProfesori.add(Profesor);
	}
	
	public void dodajProfesora(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
							   String email, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) 
	{
		Profesor Profesor = new Profesor(prezime, ime, datumRodjenja, adresaStanovanja,
										 kontaktTelefon,email, adresaKancelarije, brojLicneKarte,titula, zvanje);
		alProfesori.add(Profesor);
	}
	
	
	
	public void izbrisiProfesora(String brLicneKarte) {
		for (Profesor Profesor : alProfesori) {
			if(Profesor.getBrojLicneKarte().equals(brLicneKarte)) {
				alProfesori.remove(Profesor);
				break;
			}
		}
	}
	
	
	public void izmeniProfesora(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) 
	{
		for (Profesor profesor : alProfesori) {
			if(profesor.getBrojLicneKarte().equals(brojLicneKarte)) {
				
				profesor.setPrezime(prezime);
				profesor.setIme(ime);
				profesor.setDatumRodjenja(datumRodjenja);
				profesor.setAdresaStanovanja( adresaStanovanja);
				profesor.setKontaktTelefon(kontaktTelefon);
				profesor.setEmail(email);
				profesor.setAdresaKancelarije(adresaKancelarije);
				profesor.setBrojLicneKarte(brojLicneKarte);
				profesor.setTitula(titula);
				profesor.setZvanje(zvanje);
				
				break;
			}
		}
		
	}
	
	public boolean jedinstvenBrLicne(String brLicne) {
		for (Profesor profesor : alProfesori) {
			if(profesor.getBrojLicneKarte().equals(brLicne)) {
				return false;
			}
		}
		return true;
	}
	

	
	

}

package model;

import java.util.ArrayList;

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
		
		
		// initProfesors() 		// neka metoda koja ce da ucita u bazu Profesore pri paljenju app
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
		Profesor Profesor = alProfesori.get(x);
		switch (y) {
		case 0:
			return Profesor.getIme();
		case 1:
			return Profesor.getPrezime();
		case 2:
			return Profesor.getTitula();
		case 3:
			return Profesor.getZvanje();
		default:
			return null;
		}
	}
	
	public void dodajProfesora(Profesor Profesor) {
		alProfesori.add(Profesor);
	}
	
	public void dodajProfesora(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) 
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
	
	
	public void izmeniProfesora(String prezime, String ime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) 
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
	

	
	

}

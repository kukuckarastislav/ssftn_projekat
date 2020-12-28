package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	private ArrayList<Profesor> trazeniProfesori;
	private boolean SearchMode;



	private BazaProfesori() {
		
		
		// initProfesors() 	
		alProfesori = new ArrayList<Profesor>();
		
		
		alKolone = new ArrayList<String>();
		alKolone.add("Ime");
		alKolone.add("Prezime");
		alKolone.add("Titula");
		alKolone.add("Zvanje");

	}
	
	public void init() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		Date datumRodjenja = null;
		try {
			datumRodjenja = dateFormat.parse("7.1.2000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Profesor p1=new Profesor("Petrovic", "Veljko",datumRodjenja, "Novi sad", "66666",
				"helou@gmail","Radnicka 30", "123456789", Titula.dr, Zvanje.redovni_profesor);
		Profesor p2=new Profesor("Erdeljan", "Alex",datumRodjenja, "Novi sad", "55555",
				"helddou@gmail","Radnicka 333", "123456787", Titula.dr, Zvanje.redovni_profesor);		
		Profesor p3=new Profesor("Vrbaski", "Dunja",datumRodjenja, "Novi sad", "55455",
				"dunjciu@gmail","Radnicka 3334", "723456787", Titula.BSc, Zvanje.profesor_emeritus);
		
		alProfesori.add(p1);
		alProfesori.add(p2);
		alProfesori.add(p3);
		
		
		
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
		
		if(SearchMode == false) {
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
		}else {
			if(trazeniProfesori.size()!=0) {
			Profesor profesor = trazeniProfesori.get(x);
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
			
		}
		return null;
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


	public void izbrisiProfesora(Profesor prof) {
		alProfesori.remove(prof);
	}
	
	
	
	public ArrayList<Profesor> getTrazeniProfesori() {
		return trazeniProfesori;
	}
	public void setTrazeniProfesori(ArrayList<Profesor> trazeni) {
		this.trazeniProfesori = trazeni;
	}
	

	public boolean isSearchMode() {
		return SearchMode;
	}
	public void setSearchMode(boolean searchMode) {
		SearchMode = searchMode;
	}




}

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
		alKolone.add("LicnaKarta");

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
		
		Predmet pr4 = new Predmet("ARH", "Arhitektura Racunara", Semestar.LETNJI, 1, 9);
		Predmet pr5 = new Predmet("MISS", "Modelovanje i simulacija sistema", Semestar.ZIMSKI, 2, 8);
		ArrayList<Predmet> predmeti=new ArrayList<>();
		predmeti.add(pr4);
		predmeti.add(pr5);
		
		
		
		Profesor p1=new Profesor("Petrovic", "Veljko",datumRodjenja, "Novi sad", "66666",
				"helou@gmail","Radnicka 30", "123456789", Titula.dr, Zvanje.redovni_profesor);
		//p1.setPredmetiNaKojimaJeProfesor(predmeti);
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
		return 4+1; 	// +1 neviljdiva
	}
	
	public String getNazivKolona(int index) {
		return alKolone.get(index);
	}
	
	public Profesor getProfesor(int rowIndex) {
		return alProfesori.get(rowIndex);
	}
	
	public Profesor getProfesor(String brLicne) {
		Profesor ret=new Profesor();
		for(Profesor p: alProfesori) {
			if(p.getBrojLicneKarte().equals(brLicne))
				ret=p;
		}
		return ret;
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
		case 4:
			return profesor.getBrojLicneKarte(); 			// jedno polje koje cemo koristi da dobijemo licnu kartu
			
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
			case 4:
				return profesor.getBrojLicneKarte(); 
				
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
		// ako ima neke predemte na kojima on predaje treba tamo setovati null
		if(prof == null) return;
		
		for (Predmet predmet : prof.getPredmetiNaKojimaJeProfesor()) {
			predmet.setPredmetniProfesor(null); 	// nece biti vise toga profesora
		}
		alProfesori.remove(prof);
		
		// takodje ako smo u search modu treba i iz te liste obrisati
		if(SearchMode) {
			trazeniProfesori.remove(prof);
		}
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
	
	public void dodajPredmetProfesoru(Profesor pro,Predmet pre) {

		if(pro == null || pre == null) return;
		
		// proverimo da li vec prof predaje taj predmet
		for (Predmet predmet : pro.getPredmetiNaKojimaJeProfesor()) {
			if(predmet.equals(pre)) {
				return; 		// ok prof vec predaje ovaj predmet
			}
		}
		// prof taj predmet ne predaje zato cemo mu ga dodati
		pro.dodajPredmetProfesoru(pre);
		return;
	}

	// poksajmo da nadjemo profesora pomocu licne karte
	public Profesor getProfesorByLicnaKarta(String licnaKarta) {
		if(licnaKarta == null) return null;
		
		for (Profesor profesor : alProfesori) {
			if(profesor.getBrojLicneKarte().equals(licnaKarta)) {
				return profesor;
			}
		}
		
		// ako nismo nasli profesora vracamo null
		return null;
	}
	

	public void izbrisiPredmetUnutarProfesora(String sifra) {
		int i1;
		for(Profesor p: alProfesori) {
			i1=p.getPredmetiNaKojimaJeProfesor().indexOf(BazaPredmeti.getInstance().getPredmet(sifra));
			if(i1>=0) p.getPredmetiNaKojimaJeProfesor().remove(i1);
		}
		
	}




}


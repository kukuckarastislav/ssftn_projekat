package model;

import java.util.ArrayList;

public class Student {
	
	// POLJA
	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresa;
	private String kontaktTelefon;
	private String email;
	private String indeks;
	
	private int godinaUpisa;
	private int trenGodStudija;
	
	private Status status;
	
	private double prosecnaOcena;
	
	private ArrayList<Ocena> lPolIspita;
	private ArrayList<Ocena> lNePolIspita;
	
	
	// KONSTRUKTORI
	// sva polja
	public Student(String prezime, String ime, String datumRodjenja, String adresa, String kontaktTelefon, String email,
			String indeks, int godinaUpisa, int trenGodStudija, Status status, double prosecnaOcena,
			ArrayList<Ocena> lPolIspita, ArrayList<Ocena> lNePolIspita) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.indeks = indeks;
		this.godinaUpisa = godinaUpisa;
		this.trenGodStudija = trenGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.lPolIspita = lPolIspita;
		this.lNePolIspita = lNePolIspita;
	}
	// Konstruktor za studenta koji nema ocene 
	public Student(String prezime, String ime, String datumRodjenja, String adresa, String kontaktTelefon, String email,
			String indeks, int godinaUpisa, int trenGodStudija, Status status) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.indeks = indeks;
		this.godinaUpisa = godinaUpisa;
		this.trenGodStudija = trenGodStudija;
		this.status = status;
		this.prosecnaOcena = 0;
		this.lPolIspita = new ArrayList<>();
		this.lNePolIspita = new ArrayList<>();
	}
	public Student() {}
	
	// Moje dodate metode
	// dodaj ispit  u listu polozenih ispita
	public void dodajPolozenIspit(Ocena oc) {
		lPolIspita.add(oc);
	}
	// dodaj ispit u listu ne polozenih ispita
	public void dodajNePolozenIspit(Ocena oc) {
		lNePolIspita.add(oc);
	}
	
	// GET I SET METODE GENERISANE
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public int getTrenGodStudija() {
		return trenGodStudija;
	}
	public void setTrenGodStudija(int trenGodStudija) {
		this.trenGodStudija = trenGodStudija;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public ArrayList<Ocena> getlPolIspita() {
		return lPolIspita;
	}
	public void setlPolIspita(ArrayList<Ocena> lPolIspita) {
		this.lPolIspita = lPolIspita;
	}
	public ArrayList<Ocena> getlNePolIspita() {
		return lNePolIspita;
	}
	public void setlNePolIspita(ArrayList<Ocena> lNePolIspita) {
		this.lNePolIspita = lNePolIspita;
	}
	
	// STRING
	@Override
	public String toString() {
		return info();
	}
	
	public String info() {
		String str = "Student: "+ime+" "+prezime+" "+datumRodjenja+" "+adresa+"\n"+
					 "tel: "+kontaktTelefon+"\nemail: "+email+"\nindeks: "+indeks+"\n"+
					 "godUpisa: "+godinaUpisa+"\ntrenGod: "+trenGodStudija+"\nstatus: "+status+"\n";
		
		
		if(!lPolIspita.isEmpty()) {
			str += "prosecnaOcena: "+prosecnaOcena+"\n"+
				   "=== LISTA POLOZENIH PREDMETA ==="+"\n";
			for (Ocena ocena : lPolIspita) {
				str += ocena.info() + "\n";
			}
		}
		
		if(!lNePolIspita.isEmpty()) {
			str += "=== LISTA NE POLOZENIH PREDMETA ==="+"\n";
			for (Ocena ocena : lNePolIspita) {
				str += ocena.getPredmet().getNazivPredmeta()+"\n";
			}
		}
		
		
		return str;
	}

	


	
	
}
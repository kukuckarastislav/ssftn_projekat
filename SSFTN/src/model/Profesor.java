package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Profesor implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	
	private ArrayList<Predmet> predmetiNaKojimaJeProfesor;
	 

	public Profesor(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
	}
	
	public Profesor() {}
	
	
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
	
	
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
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
	
	
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	
	
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}
	
	
	public Titula getTitula() {
		return titula;
	}
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	
	
	public Zvanje getZvanje() {
		return zvanje;
	}
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	
	
	public ArrayList<Predmet> getPredmetiNaKojimaJeProfesor() {
		return predmetiNaKojimaJeProfesor;
	}

	public void setPredmetiNaKojimaJeProfesor(ArrayList<Predmet> predmetiNaKojimaJeProfesor) {
		this.predmetiNaKojimaJeProfesor = predmetiNaKojimaJeProfesor;
	}

	

	@Override
	public String toString() {
		
		String s="Ime: "+this.getIme();
		s+="\nPrezime: "+this.getPrezime();
		s+="\nAdresa stanovanja :"+this.getAdresaStanovanja();
		s+="\nAdresa kancelarije :"+this.getAdresaKancelarije();
		s+="\nKontakt telefon: "+this.getKontaktTelefon();
		s+="\nEmail: "+this.getEmail();
		s+="\nBroj licne karte: "+this.getBrojLicneKarte();
		s+="\nTitula: "+this.getTitula().toString();
		s+="\nZvanje: "+this.getZvanje().toString();
		s+="\nLista predmeta na kojima je profesor:";
		/*
		if(!this.getPredmetiNaKojimaJeProfesor().isEmpty()) {
		for(Predmet p: this.getPredmetiNaKojimaJeProfesor())
			s+="\t"+p.getSifraPredmeta();
		}
		*/
		
		return s;
	}

}
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudijaUKojojSePredmetIzvodi;
	private Profesor predmetniProfesor;
	private int brojESPBbodova;
	
	private ArrayList<Student> studentiKojiSuPolozili;
	private ArrayList<Student> studentiKojiNisuPolozili;
	


	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBbodova) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudijaUKojojSePredmetIzvodi = godinaStudijaUKojojSePredmetIzvodi;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPBbodova = brojESPBbodova;
	}
	//bez profesora
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, int brojESPBbodova) {
		super();
		predmetniProfesor = null;
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudijaUKojojSePredmetIzvodi = godinaStudijaUKojojSePredmetIzvodi;
		this.brojESPBbodova = brojESPBbodova;
	}

	public Predmet() {}
	
	
	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	
	public Semestar getSemestar() {
		return semestar;
	}
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	
	
	public int getGodinaStudijaUKojojSePredmetIzvodi() {
		return godinaStudijaUKojojSePredmetIzvodi;
	}
	public void setGodinaStudijaUKojojSePredmetIzvodi(int godinaStudijaUKojojSePredmetIzvodi) {
		this.godinaStudijaUKojojSePredmetIzvodi = godinaStudijaUKojojSePredmetIzvodi;
	}
	
	
	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	
	
	public int getBrojESPBbodova() {
		return brojESPBbodova;
	}
	public void setBrojESPBbodova(int brojESPBbodova) {
		this.brojESPBbodova = brojESPBbodova;
	}
	
	public ArrayList<Student> getStudentiKojiSuPolozili() {
		return studentiKojiSuPolozili;
	}
	public void setStudentiKojiSuPolozili(ArrayList<Student> studentiKojiSuPolozili) {
		this.studentiKojiSuPolozili = studentiKojiSuPolozili;
	}
	
	
	public ArrayList<Student> getStudentiKojiNisuPolozili() {
		return studentiKojiNisuPolozili;
	}
	public void setStudentiKojiNisuPolozili(ArrayList<Student> studentiKojiNisuPolozili) {
		this.studentiKojiNisuPolozili = studentiKojiNisuPolozili;
	}
	
	
	@Override
	public String toString() {
		
		
		String s="Sifra predmeta : "+this.getSifraPredmeta();
		s+="\nNaziv predmeta : "+this.getNazivPredmeta();
		s+="\nGodina studija u kojoj se predmet izvodi : "+this.getGodinaStudijaUKojojSePredmetIzvodi();
		s+="\nBroj ESPB bodova je :  "+this.getBrojESPBbodova();
		s+="\nSemestar: "+this.getSemestar().toString();
		s+="\nPredmetni profesor je :";
		if(this.getPredmetniProfesor() != null) {
			s+=this.getPredmetniProfesor().getIme()+" "+this.getPredmetniProfesor().getPrezime();
		}
		s+="\nLista studenata koji su polozili:";
		
		if(this.studentiKojiSuPolozili != null)
			for(Student student :this.studentiKojiSuPolozili)
				s+="\t"+student.getIme()+" "+student.getPrezime();
		
		s+="\nLista studenata koji nisu polozili:";
		if(this.studentiKojiNisuPolozili != null)
			for(Student student :this.studentiKojiNisuPolozili)
				s+="\t"+student.getIme()+" "+student.getPrezime();
		
		return s;
	}



}

package model;

enum Semestar{letnji,zimski}

public class Predmet {
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudijaUKojojSePredmetIzvodi;
	private Profesor predmetniProfesor;
	private int brojESPBbodova;
	
	
	
	//Spisak studenata koji su položili predmet
	//Spisak studenata koji nisu položili predmet

	
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
	




}

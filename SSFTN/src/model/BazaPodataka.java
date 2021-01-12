package model;

import java.io.Serializable;
import java.util.ArrayList;

import view.Frame1;

public class BazaPodataka implements Serializable{
	

	private static final long serialVersionUID = 6297821499922242209L;
	
	private ArrayList<Student> alStudenti;
	private ArrayList<Profesor> alProfesori;
	private ArrayList<Predmet> alPredmeti;
	
	public BazaPodataka() {	
		alStudenti = new ArrayList<Student>();
		alProfesori = new ArrayList<Profesor>();
		alPredmeti = new ArrayList<Predmet>();
	}

	public BazaPodataka(ArrayList<Student> alStudenti, ArrayList<Profesor> alProfesori, ArrayList<Predmet> alPredmeti) {
		super();
		this.alStudenti = alStudenti;
		this.alProfesori = alProfesori;
		this.alPredmeti = alPredmeti;
	}


	public ArrayList<Student> getAlStudenti() {
		return alStudenti;
	}


	public void setAlStudenti(ArrayList<Student> alStudenti) {
		this.alStudenti = alStudenti;
	}


	public ArrayList<Profesor> getAlProfesori() {
		return alProfesori;
	}


	public void setAlProfesori(ArrayList<Profesor> alProfesori) {
		this.alProfesori = alProfesori;
	}


	public ArrayList<Predmet> getAlPredmeti() {
		return alPredmeti;
	}


	public void setAlPredmeti(ArrayList<Predmet> alPredmeti) {
		this.alPredmeti = alPredmeti;
	}



}

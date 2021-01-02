package util;

import java.util.ArrayList;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.Frame1;

public class Search {
	
	
	
	public Search() {}
	
	
	public boolean searchProfesor(String text) {
	
	BazaProfesori.getInstance().setSearchMode(true);
	if(text.isBlank() || text.isEmpty()) {
		BazaProfesori.getInstance().setSearchMode(false);
	}
	
	ArrayList<Profesor> trazeniProfesori=new ArrayList<>();
	
	String sEl[] = text.split(" ");
	if(sEl.length > 2) return false;

	
	
	if(sEl.length == 2) {	
		for(Profesor p: BazaProfesori.getInstance().getProfesori()) {
			if(p.getPrezime().toLowerCase().contains(sEl[0].toLowerCase()) && p.getIme().toLowerCase().contains(sEl[1].toLowerCase()))
					trazeniProfesori.add(p);			
			}
	}else {
		for(Profesor p: BazaProfesori.getInstance().getProfesori())	{
			  if(p.getPrezime().toLowerCase().contains(text.toLowerCase()))
				trazeniProfesori.add(p);		
		}
	}
	
			
	BazaProfesori.getInstance().setTrazeniProfesori(trazeniProfesori);
	//BazaProfesori.getInstance().setSearchMode(true);
	Frame1.getInstance().azurirajPrikazTabeleProfesora("PRONADJEN", 1);
	if(trazeniProfesori.size()==0) return false;
	return true;
	}
		
	public boolean searchPredmet(String text) {
		
		ArrayList<Predmet> trazeniPredmeti=new ArrayList<>();
		
		for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
			if(p.getNazivPredmeta().toLowerCase().contains(text.toLowerCase()))
			trazeniPredmeti.add(p);
			
		}
		
	BazaPredmeti.getInstance().setTrazeniPredmeti(trazeniPredmeti);
	BazaPredmeti.getInstance().setSearchMode(true);
	Frame1.getInstance().azurirajPrikazTabelePredmeta("PRONADJEN", 1);
	if(trazeniPredmeti.size()==0) return false;
	return true;	
	}


	public void searchStudent(String text) {
		
		if(text.isBlank() || text.isEmpty()) {
			BazaStudenti.getInstance().setSearchMode(false);
			Frame1.getInstance().azurirajPrikazTabeleStudenata("NAKON SEARCH", -1);
		}else {
			BazaStudenti.getInstance().setSearchMode(true);
		}
		
		ArrayList<Student> trazeniStudenti = new ArrayList<Student>();
		
		// povecamo sva slova da ne brinemo o malim i velikim slovima
		text = text.toUpperCase();
		
		String sEl[] = text.split(" ");
		//String sEl[] = text.split("\\s");
		if(sEl.length > 3) {
			BazaStudenti.getInstance().setSearchMode(true);
			Frame1.getInstance().azurirajPrikazTabeleStudenata("NAKON SEARCH", -1);
		}
		
		if(sEl.length == 3) {			//PREZIME IME INDEKS
			for (Student student : BazaStudenti.getInstance().getStudenti()) {
				if(student.getPrezime().toUpperCase().contains(sEl[0])
				   && student.getIme().toUpperCase().contains(sEl[1])
				   && student.getIndeks().toUpperCase().contains(sEl[2])) {
					
						trazeniStudenti.add(student);
				}
			}
		}else if(sEl.length == 2) {
			for (Student student : BazaStudenti.getInstance().getStudenti()) {
				if(student.getPrezime().toUpperCase().contains(sEl[0])
				   && student.getIme().toUpperCase().contains(sEl[1]) ) {	
					trazeniStudenti.add(student);
				}
			}
		}else if(sEl.length == 1) {
			for (Student student : BazaStudenti.getInstance().getStudenti()) {
				if(student.getPrezime().toUpperCase().contains(sEl[0])) {
					
						trazeniStudenti.add(student);
				}
			}
		}else {
			BazaStudenti.getInstance().setSearchMode(false);
		}
		
		BazaStudenti.getInstance().setTrazeniStudenti(trazeniStudenti);
		Frame1.getInstance().azurirajPrikazTabeleStudenata("NAKON SEARCH", -1);
		
		
		
	}
	
	
	
	
	

}

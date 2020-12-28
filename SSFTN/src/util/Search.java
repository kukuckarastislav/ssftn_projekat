package util;

import java.util.ArrayList;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;
import view.Frame1;

public class Search {
	
	
	
	public Search() {}
	
	
	public boolean searchProfesor(String text) {
	
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
	BazaProfesori.getInstance().setSearchMode(true);
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
	
	
	
	
	

}

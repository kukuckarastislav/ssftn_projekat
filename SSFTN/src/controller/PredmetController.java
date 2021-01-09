package controller;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
import model.Profesor;
import view.Frame1;

public class PredmetController {
	
	private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if(instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {
		
	}
	
	
	public void dodajPredmet(Predmet predmet) {
		
		BazaPredmeti.getInstance().dodajPredmet(predmet);
		Frame1.getInstance().azurirajPrikazTabelePredmeta("DODAT", 1);
	}
	
	public void izmeniPredmet() {
		
	}
	
	public void izbrisiPredmet(String sifra) {
		
		BazaStudenti.getInstance().izbrisiPredmetUnutarStudenta(sifra);
		BazaProfesori.getInstance().izbrisiPredmetUnutarProfesora(sifra);
		BazaPredmeti.getInstance().izbrisiPredmet(sifra);
	}

	public Predmet getPredmet(int rowIndex) {
		Predmet p=BazaPredmeti.getInstance().getPredmet(rowIndex);		
		return p;
	}

	public Predmet getPredmetBySifra(String sifraPredmeta) {
		Predmet p = BazaPredmeti.getInstance().getPredmet(sifraPredmeta);
		return p;
	}

	public void izmeniPredmet(Predmet predmet, Predmet noviPredmet) {
		if(predmet != null && noviPredmet != null) {
			
			predmet.setSifraPredmeta(noviPredmet.getSifraPredmeta());
			predmet.setNazivPredmeta(noviPredmet.getNazivPredmeta());
			predmet.setGodinaStudijaUKojojSePredmetIzvodi(noviPredmet.getGodinaStudijaUKojojSePredmetIzvodi());
			predmet.setBrojESPBbodova(noviPredmet.getBrojESPBbodova());
			predmet.setPredmetniProfesor(noviPredmet.getPredmetniProfesor());
			predmet.setSemestar(noviPredmet.getSemestar());
			
			Frame1.getInstance().azurirajPrikazTabelePredmeta("IZMENA", 0);
			
		}
	}

	public void ukloniProfesoraSaPredmeta(Profesor aktuelniProfesor, Predmet predmet) {
		BazaPredmeti.getInstance().ukloniProfesoraSaPredmeta(aktuelniProfesor, predmet);
	}

}

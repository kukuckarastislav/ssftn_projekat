package controller;

import model.BazaPredmeti;
import model.Predmet;
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
	
	
	public void dodajPredmet(Predmet st1) {
		
		BazaPredmeti.getInstance().dodajPredmet(st1);
		Frame1.getInstance().azurirajPrikazTabelePredmeta("DODAT", 1);
	}
	
	public void izmeniPredmet() {
		
	}
	
	public void izbrisiPredmet() {
		
	}

}

package view;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.BazaPodataka;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import util.Deserijalizacija;


public class GlavniProzor {

	public static void main(String[] args) {
		
		BazaPodataka bazaPodataka = Deserijalizacija.bazaDeserijalizacija();
		
		BazaStudenti.getInstance();
		BazaProfesori.getInstance();
		BazaPredmeti.getInstance();
		
		// deserijalizacija
		if(bazaPodataka != null) {
			BazaStudenti.getInstance().setStudenti(bazaPodataka.getAlStudenti());
			BazaProfesori.getInstance().setProfesori(bazaPodataka.getAlProfesori());
			BazaPredmeti.getInstance().setPredmeti(bazaPodataka.getAlPredmeti());
		}
		
		StudentController.getInstance();
		ProfesorController.getInstance();
		PredmetController.getInstance();
	
		
		Frame1.getInstance();
		
	}

}

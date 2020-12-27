package view;

import controller.ProfesorController;
import controller.StudentController;
import model.BazaProfesori;
import model.BazaStudenti;

public class GlavniProzor {

	public static void main(String[] args) {
		
		BazaStudenti.getInstance();
		BazaProfesori.getInstance();
		
		StudentController.getInstance();
		ProfesorController.getInstance();
		
		
		Frame1.getInstance();
		
	}

}

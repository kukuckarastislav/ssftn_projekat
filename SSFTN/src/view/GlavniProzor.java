package view;

import controller.StudentController;
import model.BazaStudenti;

public class GlavniProzor {

	public static void main(String[] args) {
		
		BazaStudenti.getInstance();
		StudentController.getInstance();
		
		
		Frame1.getInstance();
		
	}

}

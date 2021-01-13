package view;

import java.io.FileNotFoundException;
import java.io.IOException;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import util.Serijalizacija;

public class GlavniProzor {

	public static void main(String[] args) {
		
		BazaStudenti.getInstance();
		BazaProfesori.getInstance();
		BazaPredmeti.getInstance();
		
		StudentController.getInstance();
		ProfesorController.getInstance();
		PredmetController.getInstance();
		
		/*
		 * ovo treba pre izlaska iz programa
		try {
			Serijalizacija.writeToFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Frame1.getInstance();
		
	}

}

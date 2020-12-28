package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Serijalizacija{


	//nisam sigurna za ovo dal se radi preko Buffer Writer ili preko OutputStream, ali zasad ovo


	public static void writeToFile() throws FileNotFoundException, IOException {
		

		FileWriter fws = new FileWriter("BazaStudenti.txt");
		FileWriter fwp = new FileWriter("BazaProfesori.txt");
		FileWriter fwpp = new FileWriter("BazaPredmeti.txt");
		
		BufferedWriter bws = new BufferedWriter(fws);
		BufferedWriter bwp = new BufferedWriter(fwp);
		BufferedWriter bwpp = new BufferedWriter(fwpp);

		for(Student s: BazaStudenti.getInstance().getStudenti()) {			
			 bws.write(s.toString());         						
		}
		bws.close();
		fws.close();
		
		for(Profesor p: BazaProfesori.getInstance().getProfesori()) {			
			 bwp.write(p.toString());	         						
		}
		bwp.close();
		fwp.close();
		
		for(Predmet p: BazaPredmeti.getInstance().getPredmeti()) {			
			 bwpp.write(p.toString());         						
		}
		bwpp.close();
		fwpp.close();


		}
	
	
		
		
	}
	
	
	
	
	
	

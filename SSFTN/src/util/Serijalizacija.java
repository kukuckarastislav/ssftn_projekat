package util;

import java.io.BufferedOutputStream;
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
		

		File fstudenti = new File("podaci"+File.separator+"BazaStudenti.txt");
		ObjectOutputStream oosSt = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fstudenti)));
		try {
			oosSt.writeObject(BazaStudenti.getInstance().getStudenti());
		} finally {
			oosSt.close(); //Zatvara i tok nizeg nivoa.
		}
		
		File fprof = new File("podaci"+File.separator+"BazaProfesori.txt");
		ObjectOutputStream oosProf = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fprof)));
		try {
			oosProf.writeObject(BazaProfesori.getInstance().getProfesori());
		} finally {
			oosProf.close(); //Zatvara i tok nizeg nivoa.
		}
		
		File fpredmeti = new File("podaci"+File.separator+"BazaPredmeti.txt");
		ObjectOutputStream oosPred = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fpredmeti)));
		try {
			oosPred.writeObject(BazaPredmeti.getInstance().getPredmeti());
		} finally {
			oosPred.close(); //Zatvara i tok nizeg nivoa.
		}
		
		

		}
	
	
		
		
	}
	
	
	
	
	
	

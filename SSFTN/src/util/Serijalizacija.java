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

import model.BazaPodataka;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Serijalizacija{


	//nisam sigurna za ovo dal se radi preko Buffer Writer ili preko OutputStream, ali zasad ovo


	public static void writeToFile(BazaPodataka bazaPodataka) throws FileNotFoundException, IOException {
		File f = new File("podaci"+File.separator+"BazaPodataka.txt");
		ObjectOutputStream oosSt = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oosSt.writeObject(bazaPodataka);
		} finally {
			oosSt.close(); //Zatvara i tok nizeg nivoa.
		}
				
	}
	
	
		
		
}
	
	
	
	
	
	

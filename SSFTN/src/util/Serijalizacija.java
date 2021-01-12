package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


import model.BazaPodataka;


public class Serijalizacija{

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
	
	
	
	
	
	

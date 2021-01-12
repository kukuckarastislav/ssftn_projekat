package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.BazaPodataka;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Deserijalizacija {

	public Deserijalizacija() {}
	
	public static BazaPodataka bazaDeserijalizacija() {
		BazaPodataka bp = null;
		File f = new File("podaci"+File.separator+"BazaPodataka.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
				bp = (BazaPodataka) ois.readObject();
				return bp;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				ois.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

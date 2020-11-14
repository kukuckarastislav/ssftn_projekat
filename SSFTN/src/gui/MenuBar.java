package gui;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {
	}
	
	
	public MenuBar() {
		/*
		 	NAPOMENA:
		 	u konstrurkot treba ubaciti iconicu
		 	trbea koristiti metode
		 	setAccelerator()			// jos nismo radili action lisenere dodacemo na kraju
		 	setMnemonic()
		 	
		 	Takodje u delu Help treba napraviti na neki nacin da se otvori neki novi prozorcic gde ce 
		 	biti informacije o funkcionalnostima
		 	takodje i za About neki novi prozor da se otvori gde ce pisati biografija
		*/
		JMenu file = new JMenu("File");
		JMenuItem miNew   = new JMenuItem("New"); //new ImageIcon("images/unnamed.png")
		JMenuItem miClose = new JMenuItem("Close"); // treba u konstruktoru dodati slike
	
		
		miNew.setToolTipText("Dodavanje novog entiteta u sistem");
		miClose.setToolTipText("Zatvaranje aplikacije");
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
				
		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit   = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		
		miEdit.setToolTipText("Izmena postojeceg entiteta");
		miDelete.setToolTipText("Brisanje postojeceg entiteta");
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		
		
		
		
		add(file);
		add(edit);
		add(help);
		
		
	}

}

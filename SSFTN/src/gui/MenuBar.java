package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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

	
	
	public MenuBar() {
		/*
		 	NAPOMENA:
		 	
		 	trbea koristiti metode
		 	setAccelerator()			// jos nismo radili action lisenere dodacemo na kraju
		 	setMnemonic()
		 	
		 	Takodje u delu Help treba napraviti na neki nacin da se otvori neki novi prozorcic gde ce 
		 	biti informacije o funkcionalnostima
		 	takodje i za About neki novi prozor da se otvori gde ce pisati biografija
		*/
		
		//setBackground(new Color(255,255,255));
		
		JMenu file = new JMenu("File");
		JMenuItem miNew   = new JMenuItem("New", new ImageIcon("images/iconPlus16x16.png")); 
		JMenuItem miClose = new JMenuItem("Close"); 
		
		file.setMnemonic(KeyEvent.VK_F);
		
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		miNew.setToolTipText("Dodavanje novog entiteta u sistem");
		miClose.setToolTipText("Zatvaranje aplikacije");
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
				
		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit   = new JMenuItem("Edit", new ImageIcon("images/iconEdit16x16.png"));
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("images/iconDelete16x16.png"));
		
		edit.setMnemonic(KeyEvent.VK_E);
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		miEdit.setToolTipText("Izmena postojeceg entiteta");
		miDelete.setToolTipText("Brisanje postojeceg entiteta");
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		help.setMnemonic(KeyEvent.VK_H);
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		
		
		
		
		add(file);
		add(edit);
		add(help);
		
		
	}

}

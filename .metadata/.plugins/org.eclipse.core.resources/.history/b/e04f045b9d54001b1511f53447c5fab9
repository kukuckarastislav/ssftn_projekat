package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.Predmet;
import model.Profesor;
import model.Student;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public MenuBar(final JFrame parent) {
		/*
		 	NAPOMENA:
		 	
		*/
		
		//setBackground(new Color(255,255,255));
		
		JMenu file = new JMenu("File");
		JMenuItem miNew   = new JMenuItem("New", new ImageIcon("images"+File.separator+"iconPlus16x16.png")); 
		JMenuItem miClose = new JMenuItem("Close", new ImageIcon("images"+File.separator+"iconClose16x16.png")); 
		
		file.setMnemonic(KeyEvent.VK_F);
		
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.setMnemonic(KeyEvent.VK_N);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setMnemonic(KeyEvent.VK_C);
		
		miNew.setToolTipText("Dodavanje novog entiteta u sistem");
		miClose.setToolTipText("Zatvaranje aplikacije");
		
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			int tab = Frame1.getInstance().getSelectedTab();
			
			if(tab == 0) {
				DodavanjeStudentaDialog stdDia = new DodavanjeStudentaDialog(parent, "Dodavanje Studenta");
				stdDia.setVisible(true);
			}else if(tab == 1) {
				DodavanjeProfesora dp = new DodavanjeProfesora(parent, "Dodavanje Profesora");
				dp.setVisible(true);
			}else if(tab == 2) {
				DodavanjePredmetaDialog dodPredDia = new DodavanjePredmetaDialog(parent);
				dodPredDia.setVisible(true);
			}
			
			}
		});
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
				
		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit   = new JMenuItem("Edit", new ImageIcon("images"+File.separator+"iconEdit16x16.png"));
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("images"+File.separator+"iconDelete16x16.png"));
		
		edit.setMnemonic(KeyEvent.VK_E);
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.setMnemonic(KeyEvent.VK_D);
		
		miEdit.setToolTipText("Izmena postojeceg entiteta");
		miDelete.setToolTipText("Brisanje postojeceg entiteta");
		
		miEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int tab = Frame1.getInstance().getSelectedTab();
				
				if(tab == 0) {
					int selStud = Frame1.getInstance().getSelectedStudentIndexInTable();
					if(selStud == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Studenta kojeg želite izmeniti", "Upozorenje", 0, null);
					}else {
						Student student = StudentController.getInstance().getStudentByIndex
								(Frame1.getInstance().getSelectedStudentByIndeks());
						
						IzmenaStudentaDialog izmStudDia = new IzmenaStudentaDialog(parent, student);
						izmStudDia.setVisible(true);
					}
					
				}else if(tab == 1) {
					// Milica #izmena_profesora
					int selProf = Frame1.getInstance().getSelectedProfesor();
					if(selProf == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Profesora kojeg želite izmeniti", "Upozorenje", 0, null);
					}else {
						String licnaKarta = Frame1.getInstance().getSelectedProfesorByLicnaKarta();
						Profesor prof = ProfesorController.getInstance().getProfesorByLicnaKarta(licnaKarta);
						IzmenaProfesora ip = new IzmenaProfesora(parent, "Izmena Profesora",prof);
						ip.setVisible(true);
					}
					
				}else if(tab == 2) {
					int selPredmet = Frame1.getInstance().getSelectedPredmet();
					if(selPredmet == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Predmet koji želite izmeniti", "Upozorenje", 0, null);
					}else {
						String sifraPredmeta = Frame1.getInstance().getSelectedPredmetBySifraPredmeta();
						Predmet predmet = PredmetController.getInstance().getPredmetBySifra(sifraPredmeta);
						IzmenaPredmetaDialog ipd = new IzmenaPredmetaDialog(parent, predmet);
						ipd.setVisible(true);
					}
				}
				
			}
		});
		
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int tab = Frame1.getInstance().getSelectedTab();
				
				if(tab == 0) {
					int selStud = Frame1.getInstance().getSelectedStudentIndexInTable();
					if(selStud == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Studenta kojeg želite obrisati", "Upozorenje", 0, null);
					}else {
						String poruka = "Da li ste sigurni da zelite da obrišete studenta?";
						Object[] opcije = {"Da","Ne"};
						int option = JOptionPane.showOptionDialog(parent, poruka, "Brisanje studenta", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, opcije, null);
						if(option == JOptionPane.YES_OPTION) {
							String indeks = Frame1.getInstance().getSelectedStudentByIndeks();
							StudentController.getInstance().izbrisiStudentaByIndex(indeks);
						}
					}
				}else if(tab == 1) {
					int selProf = Frame1.getInstance().getSelectedProfesor();
					if(selProf == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Profesora kojeg želite obrisati", "Upozorenje", 0, null);
					}else {
						String poruka = "Da li ste sigurni da želite da obrišete profesora?";
						Object[] opcije = {"Da","Ne"};
						int option = JOptionPane.showOptionDialog(parent, poruka, "Brisanje profesora", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, opcije, null);
						if(option == JOptionPane.YES_OPTION) {
							String licnaKarta = Frame1.getInstance().getSelectedProfesorByLicnaKarta();
							ProfesorController.getInstance().izbrisiProfesoraByLicnaKarta(licnaKarta);
						}
					}
	
				}else if(tab == 2) {
					int iPred=Frame1.getInstance().getSelectedPredmet();
					if(iPred==-1) {
						JOptionPane.showMessageDialog(null, "Selektujte Predmet koji želite obrisati", "Upozorenje", 0, null);
					}else {
						String poruka = "Da li ste sigurni da želite da obrišete predmet?";
						Object[] opcije = {"Da","Ne"};
						int option = JOptionPane.showOptionDialog(parent, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, opcije, null);					
						if(option == JOptionPane.YES_OPTION) {
							String sifraPredmeta = Frame1.getInstance().getSelectedPredmetBySifraPredmeta();
							PredmetController.getInstance().izbrisiPredmet(sifraPredmeta);
							Frame1.getInstance().azurirajPrikazTabelePredmeta("IZBRISAN", 1);
						  }
					}
					
				}
			}
		});
		
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("images"+File.separator+"iconHelp16x16.png"));
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("images"+File.separator+"iconAbout16x16.png"));
		
		help.setMnemonic(KeyEvent.VK_H);
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.setMnemonic(KeyEvent.VK_A);
		
		miHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HelpDialog helpDialog = new HelpDialog(parent, "Help");
				helpDialog.setVisible(true);
			}
		});
		
		miAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AboutDialog aboutDialog = new AboutDialog(parent, "About");
				aboutDialog.setVisible(true);
			}
		});
		
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		
		
		
		
		add(file);
		add(edit);
		add(help);
		
		
	}

}

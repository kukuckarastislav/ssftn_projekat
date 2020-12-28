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

import controller.ProfesorController;
import controller.StudentController;
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
					int selStud = Frame1.getInstance().getSelectedStudent();
					if(selStud == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Studenta kojeg zelite izmeniti", "Upozorenje", 0, null);
					}else {
						Student student = StudentController.getInstance().getStudent(selStud);
						
						IzmenaStudentaDialog izmStudDia = new IzmenaStudentaDialog(parent, student);
						izmStudDia.setVisible(true);
					}
					
				}else if(tab == 1) {
					// Milica #izmena_profesora
					int selProf = Frame1.getInstance().getSelectedProfesor();
					if(selProf == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Profesora kojeg zelite izmeniti", "Upozorenje", 0, null);
					}else {
						Profesor p=ProfesorController.getInstance().getProfesor(selProf);
						
						IzmenaProfesora ip = new IzmenaProfesora(parent, "Izmena Profesora",p);
						ip.setVisible(true);
					}
					
				}else if(tab == 2) {
					// izmena predmete rastislav
				}
				
			}
		});
		
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int tab = Frame1.getInstance().getSelectedTab();
				
				if(tab == 0) {
					int selStud = Frame1.getInstance().getSelectedStudent();
					if(selStud == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Studenta kojeg zelite obrisati", "Upozorenje", 0, null);
					}
					
					StudentController.getInstance().izbrisiStudenta(selStud);
					
				}else if(tab == 1) {
					int selProf = Frame1.getInstance().getSelectedProfesor();
					if(selProf == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Profesora kojeg zelite obrisati", "Upozorenje", 0, null);
					}
					
					ProfesorController.getInstance().izbrisiProfesora(selProf);
					
				}else if(tab == 2) {
					//brisi predmet
					// Milica
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

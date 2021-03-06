package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.Predmet;
import model.Profesor;
import model.Student;
import util.Search;


public class Toolbar extends JToolBar {

	private static final long serialVersionUID = 1209699209668701828L;

	private Search search=new Search();
	private JTextField searchTextField=new JTextField();
	
	public Toolbar(final JFrame parent) {
		

	
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		CustomButton btnNew = new CustomButton();
		btnNew.setIcon(new ImageIcon("images"+File.separator+"iconPlus24x24.png"));
		btnNew.setToolTipText("Create new entity");
		add(btnNew);
		
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			int tab = Frame1.getInstance().getSelectedTab();
			
			if(tab == 0) {
				DodavanjeStudentaDialog stdDia = new DodavanjeStudentaDialog(parent, "Dodavanje Studenta");
				stdDia.setVisible(true);
			}
			else if(tab == 1) {
				DodavanjeProfesora dp = new DodavanjeProfesora(parent, "Dodavanje Profesora");
				dp.setVisible(true);
			}	
			else if(tab == 2) {
				DodavanjePredmetaDialog dodPredDia = new DodavanjePredmetaDialog(parent);
				dodPredDia.setVisible(true);
			}
			
			
			
			}
		});
		
		addSeparator();
		CustomButton btnEdit = new CustomButton();
		btnEdit.setIcon(new ImageIcon("images"+File.separator+"iconEdit24x24.png"));
		btnEdit.setToolTipText("Edit entity");
		add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
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
				}
				else if(tab == 1) {
					
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

		addSeparator();
		
		CustomButton btnDelete = new CustomButton();
		btnDelete.setIcon(new ImageIcon("images"+File.separator+"iconDelete24x24.png"));
		btnDelete.setToolTipText("Delete entity");
		add(btnDelete);
		
		addSeparator();		
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int tab = Frame1.getInstance().getSelectedTab();
				
				if(tab == 0) {
					int selStud = Frame1.getInstance().getSelectedStudentIndexInTable();
					if(selStud == -1) {
						JOptionPane.showMessageDialog(null, "Selektujte Studenta kojeg zelite obrisati", "Upozorenje", 0, null);
					}else {
						String poruka = "Da li ste sigurni da želite da obrišete studenta?";
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
						JOptionPane.showMessageDialog(null, "Selektujte Profesora kojeg zelite obrisati", "Upozorenje", 0, null);
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
						JOptionPane.showMessageDialog(null, "Selektujte Predmet koji zelite obrisati", "Upozorenje", 0, null);
					}else {
						String poruka = "Da li ste sigurni da želite da obrišete predmet?";
						int option = JOptionPane.showConfirmDialog((JFrame)parent, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION);
						if(option == JOptionPane.YES_OPTION) {
							String sifraPredmeta = Frame1.getInstance().getSelectedPredmetBySifraPredmeta();
							PredmetController.getInstance().izbrisiPredmet(sifraPredmeta);
							Frame1.getInstance().azurirajPrikazTabelePredmeta("IZBRISAN", 1);
						  }
					}
				}
				
			}
		});
		
		
		CustomButton btnSearch = new CustomButton();
		btnSearch.setIcon(new ImageIcon("images"+File.separator+"iconSearch24x24.png"));
		btnSearch.setToolTipText("Search for entity");
		add(btnSearch);
				
		add(Box.createHorizontalGlue());
		
		
		searchTextField.setPreferredSize(new Dimension(200,24));
		searchTextField.setMaximumSize(searchTextField.getPreferredSize());
        add(searchTextField);
		
		add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			int tab = Frame1.getInstance().getSelectedTab();
			
			if(tab == 0) {
				search.searchStudent(searchTextField.getText());
			}else if(tab == 1) {
				search.searchProfesor(searchTextField.getText());
			}else if(tab == 2) {
				search.searchPredmet(searchTextField.getText());
				
			}
			
			}
		});



	}

}


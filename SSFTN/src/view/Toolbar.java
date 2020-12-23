package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ProfesorController;
import model.Profesor;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = 1209699209668701828L;

	public Toolbar(final JFrame parent) {
		

	
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		CustomButton btnNew = new CustomButton();
		btnNew.setIcon(new ImageIcon("images/iconPlus24x24.png"));
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
			if(tab == 1) {
				DodavanjeProfesora dp = new DodavanjeProfesora(parent, "Dodavanje Profesora");
				dp.setVisible(true);
			}			
			}
		});
		
		addSeparator();
		CustomButton btnEdit = new CustomButton();
		btnEdit.setIcon(new ImageIcon("images/iconEdit24x24.png"));
		btnEdit.setToolTipText("Edit entity");
		add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			int tab = Frame1.getInstance().getSelectedTab();
			
			if(tab == 0) {
				DodavanjeStudentaDialog stdDia = new DodavanjeStudentaDialog(parent, "Dodavanje Studenta");
				stdDia.setVisible(true);
			}
			if(tab == 1) {

				//Profesor profesor = new Profesor("petrovic", "velko", "1970", "negde", "000", "v@", "NTP111", "333333333", "prof", "dr");
				
				//ovo ne radi.. ali eto 
				
				int indexProfesora=Frame1.getInstance().getSelectedProfesor();
				Profesor p=ProfesorController.getInstance().getProfesor(indexProfesora);
				
				IzmenaProfesora ip = new IzmenaProfesora(parent, "Izmena Profesora",p);
				ip.setVisible(true);
			}			
			}
		});
		
		
		
		

		addSeparator();
		
		CustomButton btnDelete = new CustomButton();
		btnDelete.setIcon(new ImageIcon("images/iconDelete24x24.png"));
		btnDelete.setToolTipText("Delete entity");
		add(btnDelete);
		
		addSeparator();		
		
		
		CustomButton btnSearch = new CustomButton();
		btnSearch.setIcon(new ImageIcon("images/iconSearch24x24.png"));
		btnSearch.setToolTipText("Search for entity");
		add(btnSearch);
				
		add(Box.createHorizontalGlue());
		
		
		JTextField tf = new JTextField(15);
		tf.setPreferredSize(new Dimension(200,24));
        tf.setMaximumSize(tf.getPreferredSize());
        add(tf);
		
		add(btnSearch);



	}

}


package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
				DodavanjeStudentaDialog stdDia = new DodavanjeStudentaDialog(parent, "Dodavanje Studenta");
				stdDia.setVisible(true);
			}
			if(tab == 1) {
				
				int indexProfesora=Frame1.getInstance().getSelectedProfesor();
				Profesor p=ProfesorController.getInstance().getProfesor(indexProfesora);
				
				IzmenaProfesora ip = new IzmenaProfesora(parent, "Izmena Profesora",p);
				ip.setVisible(true);
						 }			
			}
		});
		
		
		
		

		addSeparator();
		
		CustomButton btnDelete = new CustomButton();
		btnDelete.setIcon(new ImageIcon("images"+File.separator+"iconDelete24x24.png"));
		btnDelete.setToolTipText("Delete entity");
		add(btnDelete);
		
		addSeparator();		
		
		
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
				
			}else if(tab == 1) {
				search.searchProfesor(searchTextField.getText());
			}else if(tab == 2) {
				search.searchPredmet(searchTextField.getText());
				
			}
			
			}
		});



	}

}


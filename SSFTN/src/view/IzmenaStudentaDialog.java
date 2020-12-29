package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import model.Student;

public class IzmenaStudentaDialog extends JDialog {

	private static final long serialVersionUID = 6500846341182743028L;
	
	private final Frame parent;
	private JTabbedPane tabPanel;
	
	public IzmenaStudentaDialog(Frame parent, final Student student) {
		super(parent,"Izmena Studenta",true);
		
		this.parent = parent;
		
		setSize(600,600);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		JPanel ukrasniGornjiPanel = new JPanel();
		ukrasniGornjiPanel.setBackground(Color.white);
		ukrasniGornjiPanel.setPreferredSize(new Dimension(26,26));
		
		JPanel ukrasniDonjiPanel = new JPanel();
		ukrasniDonjiPanel.setBackground(Color.white);
		ukrasniDonjiPanel.setPreferredSize(new Dimension(16,16));
		
		JPanel panelSaTabovima = new JPanel(new BorderLayout());
		panelSaTabovima.setBackground(Color.white);
	
		tabPanel = new JTabbedPane();
		panelSaTabovima.add(tabPanel, BorderLayout.CENTER);
		
		PanIzmenaStudentaInformacije panInfo = new PanIzmenaStudentaInformacije(student);
		PanIzmenaStudentaPolozeni panPolozeni = new PanIzmenaStudentaPolozeni();
		PanIzmenaStudentaNePolozeni panNePolozeni = new PanIzmenaStudentaNePolozeni(student);
		
		tabPanel.addTab("Informacije", panInfo);
		tabPanel.addTab("Polozeni", panPolozeni);
		tabPanel.addTab("Nepolozeni", panNePolozeni);
		
		

		
		add(ukrasniGornjiPanel, BorderLayout.NORTH);
		add(ukrasniDonjiPanel, BorderLayout.SOUTH);
		add(panelSaTabovima, BorderLayout.CENTER);
	
	}
	
	
}

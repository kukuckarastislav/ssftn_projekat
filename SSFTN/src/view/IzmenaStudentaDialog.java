package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		PanIzmenaStudentaPolozeni panPolozeni = new PanIzmenaStudentaPolozeni(parent, student);
		PanIzmenaStudentaNePolozeni panNePolozeni = new PanIzmenaStudentaNePolozeni(parent,student);
		
		tabPanel.addTab("Informacije", panInfo);
		tabPanel.addTab("Položeni", panPolozeni);
		tabPanel.addTab("Nepoloženi", panNePolozeni);
		
		// ovaj deo koda bi mogao da popravi problem da smanjuje i povecava dialog
		// u zavisnosti od taba kojeg gledamo ??? dal je ovo dobra ideja?
		tabPanel.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				int x = tabPanel.getSelectedIndex();
				//System.out.println(tabPanel.getSelectedIndex());
				if(x==0) {
					setSize(600,600);
					setLocationRelativeTo(parent);
				}else if(x==1) {
					setSize(1000,600);
					setLocationRelativeTo(parent);
					panPolozeni.azurirajPrikazTabelePolozeni();
				}else if(x==2) {
					setSize(1000,600);
					setLocationRelativeTo(parent);
					panNePolozeni.azurirajPrikazTabeleNePolozenihPredmetaZaStudenta();
				}
			}
		});
		
		add(ukrasniGornjiPanel, BorderLayout.NORTH);
		add(ukrasniDonjiPanel, BorderLayout.SOUTH);
		add(panelSaTabovima, BorderLayout.CENTER);
	
	}
	
	
}

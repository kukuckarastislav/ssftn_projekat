package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.Status;
import model.Student;

public class DodavanjeStudentaDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2196538883314033024L;

	public DodavanjeStudentaDialog(Frame parent, String naslov) {
		super(parent,naslov,true);
		
		setSize(450,600);
		setResizable(false);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		
		Dimension dimKomp = new Dimension(150,20);
		
		
		// IME
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dimKomp);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dimKomp);
		txtIme.setName("txtIme");
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		// PREZIME
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setPreferredSize(dimKomp);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dimKomp);
		txtPrezime.setName("txtPrezime");
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);

		// DATUM RODJENJA
		JLabel lblDatmR = new JLabel("Datum rodjenja*");
		lblDatmR.setPreferredSize(dimKomp);
		JTextField txtDatmR = new JTextField();
		txtDatmR.setPreferredSize(dimKomp);
		txtDatmR.setName("txtDatmR");
		JPanel panDatmR = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panDatmR.add(lblDatmR);
		panDatmR.add(txtDatmR);
		
		// ADRESA STANOVANJA
		JLabel lblAdrS = new JLabel("Adresa stanovanja*");
		lblAdrS.setPreferredSize(dimKomp);
		JTextField txtAdrS = new JTextField();
		txtAdrS.setPreferredSize(dimKomp);
		txtAdrS.setName("txtAdrS");
		JPanel panAdrS = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panAdrS.add(lblAdrS);
		panAdrS.add(txtAdrS);
		
		// BROJ TELEFONA
		JLabel lblBrTel = new JLabel("Broj telefona*");
		lblBrTel.setPreferredSize(dimKomp);
		JTextField txtBrTel = new JTextField();
		txtBrTel.setPreferredSize(dimKomp);
		txtBrTel.setName("txtBrTel");
		JPanel panBrTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panBrTel.add(lblBrTel);
		panBrTel.add(txtBrTel);
		
		// EMAIL
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dimKomp);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dimKomp);
		txtEmail.setName("txtEmail");
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);
		
		// BROJ INDEKSA
		JLabel lblIndeks = new JLabel("Broj indeksa*");
		lblIndeks.setPreferredSize(dimKomp);
		JTextField txtIndeks = new JTextField();
		txtIndeks.setPreferredSize(dimKomp);
		txtIndeks.setName("txtIndeks");
		JPanel panIndeks = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panIndeks.add(lblIndeks);
		panIndeks.add(txtIndeks);
		
		// GODINA UPISA
		JLabel lblGodUpisa = new JLabel("Godina Upisa*");
		lblGodUpisa.setPreferredSize(dimKomp);
		JTextField txtGodUpisa = new JTextField();
		txtGodUpisa.setPreferredSize(dimKomp);
		txtGodUpisa.setName("txtGodUpisa");
		JPanel panGodUpisa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panGodUpisa.add(lblGodUpisa);
		panGodUpisa.add(txtGodUpisa);
		
		// TRENUTNA GODINA STUDIJA
		JLabel lblTGS = new JLabel("Trenutna godina studija*");
		lblTGS.setPreferredSize(dimKomp);
		String[] godineStudije = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		JComboBox<String> TGS = new JComboBox<>(godineStudije);
		TGS.setName("TGS");	
		TGS.setPreferredSize(dimKomp);
		JPanel panTGS = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panTGS.add(lblTGS);
		panTGS.add(TGS);

		// NACIN FINANSIRANJA
		JLabel lblStatus = new JLabel("Nacin finansiranja*");
		lblStatus.setPreferredSize(dimKomp);
		String[] statusiFinansiranja = {"Budzet","Samofinansiranje"};
		JComboBox<String> CBStatus = new JComboBox<>(statusiFinansiranja);
		CBStatus.setName("CBStatus");	
		CBStatus.setPreferredSize(dimKomp);
		JPanel panStatus= new JPanel(new FlowLayout(FlowLayout.CENTER));
		panStatus.add(lblStatus);
		panStatus.add(CBStatus);
		
		
		
		
		
		
		JPanel panCentar = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCentar, BoxLayout.Y_AXIS);
		panCentar.setLayout(boxCenter);
		
		panCentar.add(Box.createVerticalGlue());
		panCentar.add(panIme);
		panCentar.add(panPrezime);
		panCentar.add(panDatmR);
		panCentar.add(panAdrS);
		panCentar.add(panBrTel);
		panCentar.add(panEmail);
		panCentar.add(panIndeks);
		panCentar.add(panGodUpisa);
		panCentar.add(panTGS);
		panCentar.add(panStatus);
		
		
		
		
		add(panCentar, BorderLayout.CENTER);
		
		JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		diaButtonPanel.setPreferredSize(new Dimension(60,60));
		//diaButtonPanel.setBackground(new Color(255,255,255));
		DiaButton btPotvrdi = new DiaButton("Potvrdi");
		DiaButton btOdustani = new DiaButton("Odustani");
		
		btPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Student student = new Student();
				student.setIme(txtIme.getText());
				student.setPrezime(txtPrezime.getText());
				student.setDatumRodjenja(txtDatmR.getText());
				student.setAdresa(txtAdrS.getText());
				student.setKontaktTelefon(txtBrTel.getText());
				student.setEmail(txtEmail.getText());
				student.setIndeks(txtIndeks.getText());
				student.setGodinaUpisa( Integer.parseInt(txtGodUpisa.getText()) );
				student.setTrenGodStudija( TGS.getSelectedIndex() + 1); 					// treba +1 jer je "I (prva)" na nultom indeksu
				if(CBStatus.getSelectedIndex() == 0) {
					student.setStatus( Status.B );											
				}else {
					student.setStatus( Status.S );											
				}
					
				
				StudentController.getInstance().dodajStudenta(student);
				dispose();
			}
		});
		
		btOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		
		diaButtonPanel.add(btPotvrdi);
		diaButtonPanel.add(Box.createHorizontalStrut(20));
		diaButtonPanel.add(btOdustani);
		
		add(diaButtonPanel, BorderLayout.SOUTH);

	}
	
	
}
package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.Status;
import model.Student;
import util.ValidacijaTextFieldFocusListener;
import util.ValidacijaUnosa;

public class DodavanjeStudentaDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2196538883314033024L;
	
	private final Frame parent;
	private DiaButton btPotvrdi;
	private DiaButton btOdustani;
	
	// ovaj niz booleanda nam govori dal su okej unosi za redom JTextField komponente
	private ArrayList<ValidacijaTextFieldFocusListener> lValid;
	public boolean svaPoljaValidna() {
		for (ValidacijaTextFieldFocusListener val : lValid) {
			if(val.getValidacija() == false) {
				//JOptionPane.showMessageDialog(this, "Greska pri unosu: "+val.getName(), "Upozorenje", 0, null);
				return false;
			}
		}
		// sve je validno okej :)
		return true;
	}
	
	public void omoguciDugmePotvrdi() {
		if(svaPoljaValidna()) {
			btPotvrdi.setEnabled(true);
		}else {
			btPotvrdi.setEnabled(false);
		}
	}
	
	

	public DodavanjeStudentaDialog(Frame parent, String naslov) {		
		super(parent,naslov,true);
		
		this.parent = parent;
		
		setSize(450,600);
		setResizable(false);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		
		Dimension dimKomp = new Dimension(150,20);
		
		lValid = new ArrayList<ValidacijaTextFieldFocusListener>();
		
		// IME
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setToolTipText("Ime je niz alfabetskih karaktera");
		lblIme.setPreferredSize(dimKomp);
		JTextField txtIme = new JTextField();
		txtIme.setToolTipText("Ime je niz alfabetskih karaktera");
		txtIme.setPreferredSize(dimKomp);
		txtIme.setName("txtIme");
		ValidacijaTextFieldFocusListener vtffl0 = new ValidacijaTextFieldFocusListener(lblIme, txtIme,this);
		txtIme.addFocusListener(vtffl0);
		txtIme.addKeyListener(vtffl0);
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		// PREZIME
		JLabel lblPrezime = new JLabel("Prezime*");
		lblPrezime.setToolTipText("Prezime je niz alfabetskih karaktera");
		lblPrezime.setPreferredSize(dimKomp);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setToolTipText("Prezime je niz alfabetskih karaktera");
		txtPrezime.setPreferredSize(dimKomp);
		txtPrezime.setName("txtPrezime");
		ValidacijaTextFieldFocusListener vtffl1 = new ValidacijaTextFieldFocusListener(lblPrezime, txtPrezime,this);
		txtPrezime.addFocusListener(vtffl1);
		txtPrezime.addKeyListener(vtffl1);
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);

		// DATUM RODJENJA
		JLabel lblDatmR = new JLabel("Datum rodjenja*");
		lblDatmR.setToolTipText("Trazen format: DD.MM.GGGG");
		lblDatmR.setPreferredSize(dimKomp);
		JTextField txtDatmR = new JTextField();
		txtDatmR.setToolTipText("Trazen format: DD.MM.GGGG");
		lblDatmR.setToolTipText("Trazen format: DD.MM.GGGG.");
		lblDatmR.setPreferredSize(dimKomp);
		txtDatmR.setToolTipText("Trazen format: DD.MM.GGGG.");
		txtDatmR.setPreferredSize(dimKomp);
		txtDatmR.setName("txtDatmR");
		ValidacijaTextFieldFocusListener vtffl2 = new ValidacijaTextFieldFocusListener(lblDatmR, txtDatmR,this);
		txtDatmR.addFocusListener(vtffl2);
		txtDatmR.addKeyListener(vtffl2);
		JPanel panDatmR = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panDatmR.add(lblDatmR);
		panDatmR.add(txtDatmR);
		
		// ADRESA STANOVANJA
		JLabel lblAdrS = new JLabel("Adresa stanovanja*");
		lblAdrS.setToolTipText("Unesite svoju Adresu stanovanja");
		lblAdrS.setPreferredSize(dimKomp);
		JTextField txtAdrS = new JTextField();
		txtAdrS.setToolTipText("Unesite svoju Adresu stanovanja");
		txtAdrS.setPreferredSize(dimKomp);
		txtAdrS.setName("txtAdrS");
		ValidacijaTextFieldFocusListener vtffl3 = new ValidacijaTextFieldFocusListener(lblAdrS, txtAdrS,this);
		txtAdrS.addFocusListener(vtffl3);
		txtAdrS.addKeyListener(vtffl3);
		JPanel panAdrS = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panAdrS.add(lblAdrS);
		panAdrS.add(txtAdrS);
		
		// BROJ TELEFONA
		JLabel lblBrTel = new JLabel("Broj telefona*");
		lblBrTel.setToolTipText("Broj telefona je niz od najmanje 3 a najvise 12 decimalnih cifara");
		lblBrTel.setPreferredSize(dimKomp);
		JTextField txtBrTel = new JTextField();
		txtBrTel.setToolTipText("Broj telefona je niz od najmanje 3 a najvise 12 decimalnih cifara");
		txtBrTel.setPreferredSize(dimKomp);
		txtBrTel.setName("txtBrTel");
		ValidacijaTextFieldFocusListener vtffl4 = new ValidacijaTextFieldFocusListener(lblBrTel, txtBrTel,this);
		txtBrTel.addFocusListener(vtffl4);
		txtBrTel.addKeyListener(vtffl4);
		JPanel panBrTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panBrTel.add(lblBrTel);
		panBrTel.add(txtBrTel);
		
		// EMAIL
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setToolTipText("Format emaila: korisnickoIme@domen");
		lblEmail.setPreferredSize(dimKomp);
		JTextField txtEmail = new JTextField();
		txtEmail.setToolTipText("Format emaila: korisnickoIme@domen");
		txtEmail.setPreferredSize(dimKomp);
		txtEmail.setName("txtEmail");
		ValidacijaTextFieldFocusListener vtffl5 = new ValidacijaTextFieldFocusListener(lblEmail, txtEmail,this);
		txtEmail.addFocusListener(vtffl5);
		txtEmail.addKeyListener(vtffl5);
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);
		
		// BROJ INDEKSA
		JLabel lblIndeks = new JLabel("Broj indeksa*");
		lblIndeks.setToolTipText("format smer-broj-godUpisa");
		lblIndeks.setPreferredSize(dimKomp);
		JTextField txtIndeks = new JTextField();
		txtIndeks.setToolTipText("format smer-broj-godUpisa");
		txtIndeks.setPreferredSize(dimKomp);
		txtIndeks.setName("txtIndeks");
		ValidacijaTextFieldFocusListener vtffl6 = new ValidacijaTextFieldFocusListener(lblIndeks, txtIndeks,this);
		txtIndeks.addFocusListener(vtffl6);
		txtIndeks.addKeyListener(vtffl6);
		JPanel panIndeks = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panIndeks.add(lblIndeks);
		panIndeks.add(txtIndeks);
		
		// GODINA UPISA
		JLabel lblGodUpisa = new JLabel("Godina Upisa*");
		lblGodUpisa.setToolTipText("Godina upisa format od 4 cifre");
		lblGodUpisa.setPreferredSize(dimKomp);
		JTextField txtGodUpisa = new JTextField();
		txtGodUpisa.setToolTipText("Godina upisa format od 4 cifre");
		txtGodUpisa.setPreferredSize(dimKomp);
		txtGodUpisa.setName("txtGodUpisa");
		ValidacijaTextFieldFocusListener vtffl7 = new ValidacijaTextFieldFocusListener(lblGodUpisa, txtGodUpisa,this);
		txtGodUpisa.addFocusListener(vtffl7);
		txtGodUpisa.addKeyListener(vtffl7);
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
		JLabel lblStatus = new JLabel("Način finansiranja*");
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
		
		lValid.add(vtffl0);
		lValid.add(vtffl1);
		lValid.add(vtffl2);
		lValid.add(vtffl3);
		lValid.add(vtffl4);
		lValid.add(vtffl5);
		lValid.add(vtffl6);
		lValid.add(vtffl7);
		
		
		
		add(panCentar, BorderLayout.CENTER);
		
		JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		diaButtonPanel.setPreferredSize(new Dimension(60,60));
		//diaButtonPanel.setBackground(new Color(255,255,255));
		btPotvrdi = new DiaButton("Potvrdi");
		btPotvrdi.setEnabled(false);
		btOdustani = new DiaButton("Odustani");
		
		btPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(svaPoljaValidna()) {

					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
					dateFormat.setLenient(false);
					Date datumRodjenja = null;
					try {
						datumRodjenja = dateFormat.parse(txtDatmR.getText());
					} catch (ParseException e) {
						e.printStackTrace();
					}
	

				
					Student student = new Student();
					student.setIme(txtIme.getText());
					student.setPrezime(txtPrezime.getText());
					student.setDatumRodjenja(datumRodjenja); 	//

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
				}else {
					// metoda svaPoljaValidna izbacuje malecki dialog gde nas upozorava da smo nesto lose uneli
				}
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

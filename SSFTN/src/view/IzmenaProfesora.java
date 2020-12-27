package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.ProfesorController;
import model.Profesor;
import util.ValidacijaTextFieldFocusListener;

public class IzmenaProfesora extends JDialog {
	
	private static final long serialVersionUID = 94580162855038262L;
	private JTabbedPane tpane;
	private JTable tabelaPredmetaProfesora;	
	private ArrayList<ValidacijaTextFieldFocusListener> validnost;
	public boolean svaPoljaValidna() {
		for (ValidacijaTextFieldFocusListener val : validnost) {
			if(val.getValidacija() == false) {
				JOptionPane.showMessageDialog(this, "Greska pri unosu: "+val.getName(), "Upozorenje", 0, null);
				return false;
			}
		}
		return true;
	}
	

	public IzmenaProfesora(Frame parent, String naslov,Profesor profesor) {		
		super(parent,naslov,true);
			
	
		setSize(490,550);
		setResizable(false);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		Dimension dim = new Dimension(120, 20);
		
		tpane = new JTabbedPane();
		this.add(tpane,BorderLayout.CENTER);
		
		JPanel panelProfesor = new JPanel();
		JPanel panelPredmeti = new JPanel();
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));			
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.setText(profesor.getPrezime());
		ValidacijaTextFieldFocusListener v1 = new ValidacijaTextFieldFocusListener(lblPrezime, txtPrezime,this);
		txtPrezime.addFocusListener(v1);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		//validnost.add(v1);
		
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.setText(profesor.getIme());
		ValidacijaTextFieldFocusListener v2 = new ValidacijaTextFieldFocusListener(lblIme, txtIme,this);
		txtIme.addFocusListener(v2);
		panIme.add(lblIme);
		panIme.add(txtIme);
		//validnost.add(v2);
		
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDatmR = new JLabel("Datum rodjenja*");
		lblDatmR.setPreferredSize(dim);
		JTextField txtDatmR = new JTextField();
		txtDatmR.setPreferredSize(dim);
		txtDatmR.setName("txtDatmR");
		//txtDatmR.setText(profesor.getDatumRodjenja());
		txtDatmR.setToolTipText("Na datumu cemo jos da poradimo..");
		ValidacijaTextFieldFocusListener v3 = new ValidacijaTextFieldFocusListener(lblDatmR, txtDatmR,this);
		txtDatmR.addFocusListener(v3);	
		panDatum.add(lblDatmR);
		panDatum.add(txtDatmR);
		//validnost.add(v3);
		
		JLabel lblAdrS = new JLabel("Adresa stanovanja*");
		lblAdrS.setPreferredSize(dim);
		JTextField txtAdrS = new JTextField();
		txtAdrS.setPreferredSize(dim);
		txtAdrS.setName("txtAdrS");
		txtAdrS.setText(profesor.getAdresaStanovanja());
		ValidacijaTextFieldFocusListener v4 = new ValidacijaTextFieldFocusListener(lblAdrS, txtAdrS,this);
		txtAdrS.addFocusListener(v4);
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panAdresa.add(lblAdrS);
		panAdresa.add(txtAdrS);
		//validnost.add(v4);
		
		JPanel panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBrTel = new JLabel("Kontakt telefon*");
		lblBrTel.setPreferredSize(dim);
		JTextField txtBrTel = new JTextField();
		txtBrTel.setPreferredSize(dim);
		txtBrTel.setName("txtBrTel");
		txtBrTel.setText(profesor.getKontaktTelefon());
		txtBrTel.setToolTipText("Broj telefona je niz od najmanje 3 a najvise 12 decimalnih cifara");
		ValidacijaTextFieldFocusListener v5 = new ValidacijaTextFieldFocusListener(lblBrTel, txtBrTel,this);
		txtBrTel.addFocusListener(v5);	
		panTel.add(lblBrTel);
		panTel.add(txtBrTel);
		//validnost.add(v5);
		
		JPanel panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setToolTipText("Format emaila: korisnickoIme@domen");
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		txtEmail.setText(profesor.getEmail());
		ValidacijaTextFieldFocusListener v6 = new ValidacijaTextFieldFocusListener(lblEmail, txtEmail,this);
		txtEmail.addFocusListener(v6);
		panMail.add(lblEmail);
		panMail.add(txtEmail);
		//validnost.add(v6);
		

		JPanel panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblAdrKan = new JLabel("Adresa kancelarije*");
		lblAdrKan.setPreferredSize(dim);
		JTextField txtAdrKan = new JTextField();
		txtAdrKan.setPreferredSize(dim);
		txtAdrKan.setName("txtAdrS");
		txtAdrKan.setText(profesor.getAdresaKancelarije());
		ValidacijaTextFieldFocusListener v7 = new ValidacijaTextFieldFocusListener(lblAdrKan, txtAdrS,this);
		txtAdrKan.addFocusListener(v7);
		panAdr.add(lblAdrKan);
		panAdr.add(txtAdrKan);
		//validnost.add(v7);
		
	
		JPanel panLicna = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbllicna = new JLabel("Broj licne karte*:");
		lbllicna.setPreferredSize(dim);
		JTextField txtlicna = new JTextField();
		txtlicna.setPreferredSize(dim);
		txtlicna.setName("txtlicna");
		txtlicna.setText(profesor.getBrojLicneKarte());
		txtBrTel.setToolTipText("Tacno 9 cifara");
		ValidacijaTextFieldFocusListener v8 = new ValidacijaTextFieldFocusListener(lbllicna,txtlicna,this);
		txtlicna.addFocusListener(v8);
		panLicna.add(lbllicna);
		panLicna.add(txtlicna);
		//validnost.add(v8);
		
		
		
		
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(dim);
		String[] titule = {"Doktor", "Magistar"};
		JComboBox<String> Titule = new JComboBox<>(titule);
		Titule.setName("Titule");	
		Titule.setPreferredSize(dim);
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panTitula.add(lblTitula);
		panTitula.add(Titule);	
	
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(dim);
		String[] zvanja = {"Redovni profesor", "Vanredni profesor"};
		JComboBox<String> Zvanja = new JComboBox<>(zvanja);
		Zvanja.setName("Zvanja");	
		Zvanja.setPreferredSize(dim);
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panZvanje.add(lblZvanje);
		panZvanje.add(Zvanja);
	
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		DiaButton btnPotvrdi=new DiaButton("Potvrdi");
		DiaButton btnOdustani=new DiaButton("Odustani");
		panButtons.add(btnPotvrdi);
		panButtons.add(btnOdustani);
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(svaPoljaValidna()) {
						String izabranaTitula = (String)Titule.getSelectedItem();
						String izabranoZvanje = (String)Zvanja.getSelectedItem();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						dateFormat.setLenient(false);
						Date datumRodjenja = null;
						try {
							datumRodjenja = dateFormat.parse(txtDatmR.getText());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						//ProfesorController.getInstance().izmeniProfesora(txtPrezime.getText(),txtIme.getText(),datumRodjenja,txtAdrS.getText(),
		//txtBrTel.getText(),txtEmail.getText(),txtAdrKan.getText(),txtlicna.getText(),izabranaTitula,izabranoZvanje);
						dispose();
					}else {
						
					}
				}
			});
				
		
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panPrezime);
		boxCentar.add(panIme);
		boxCentar.add(panDatum);		
		boxCentar.add(panAdresa);
		boxCentar.add(panTel);
		boxCentar.add(panMail);
		boxCentar.add(panAdr);
		boxCentar.add(panLicna);
		boxCentar.add(panTitula);
		boxCentar.add(panZvanje);
		boxCentar.add(Box.createGlue());
		boxCentar.add(panButtons,BorderLayout.SOUTH);	
		boxCentar.add(Box.createGlue());
		panelProfesor.add(boxCentar, BorderLayout.WEST);

		
	
		
		tabelaPredmetaProfesora = new PredmetiJTable();
		JScrollPane panelPredmetiScrollPane = new JScrollPane(tabelaPredmetaProfesora);
		panelPredmeti.add(panelPredmetiScrollPane,BorderLayout.CENTER);
		
		
		
		tpane.addTab("Informacije", panelProfesor);
		tpane.addTab("Predmeti", panelPredmeti);

	
	}
}

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorController;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import util.ValidacijaTextFieldFocusListener;


public class DodavanjeProfesora extends JDialog {
	
	private static final long serialVersionUID = 945801629855038262L;
	
	private DiaButton btnPotvrdi;
	private DiaButton btnOdustani;
	
	private ArrayList<ValidacijaTextFieldFocusListener> lValid;
	public boolean svaPoljaValidna() {
		for (ValidacijaTextFieldFocusListener val : lValid) {
			if(val.getValidacija() == false) {
				//JOptionPane.showMessageDialog(this, "Greska pri unosu: "+val.getName(), "Upozorenje", 0, null);
				return false;
			}
		}
		return true;
	}
	

	public void omoguciDugmePotvrdi() {
		if(svaPoljaValidna()) {
			btnPotvrdi.setEnabled(true);
		}else {
			btnPotvrdi.setEnabled(false);
		}
	}
	
	
	
	public DodavanjeProfesora(Frame parent, String title) {
		
		super(parent, title,true);
		
		setSize(new Dimension(450,600));
		setResizable(false);
		setLocationRelativeTo(parent);
		
		lValid = new ArrayList<ValidacijaTextFieldFocusListener>();
		Dimension dim = new Dimension(150, 20);			
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));			
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.setToolTipText("Prezime je niz alfabetskih karaktera");
		ValidacijaTextFieldFocusListener v1 = new ValidacijaTextFieldFocusListener(lblPrezime, txtPrezime,this);
		txtPrezime.addFocusListener(v1);
		txtPrezime.addKeyListener(v1);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		lValid.add(v1);
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.setToolTipText("Ime je niz alfabetskih karaktera");
		ValidacijaTextFieldFocusListener v2 = new ValidacijaTextFieldFocusListener(lblIme, txtIme,this);
		txtIme.addFocusListener(v2);
		txtIme.addKeyListener(v2);
		panIme.add(lblIme);
		panIme.add(txtIme);
		lValid.add(v2);		
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDatmR = new JLabel("Datum rodjenja*");
		lblDatmR.setPreferredSize(dim);
		JTextField txtDatmR = new JTextField();
		txtDatmR.setPreferredSize(dim);
		txtDatmR.setName("txtDatmR");
		txtDatmR.setToolTipText("Trazen format: DD.MM.GGGG");
		ValidacijaTextFieldFocusListener v3 = new ValidacijaTextFieldFocusListener(lblDatmR, txtDatmR,this);
		txtDatmR.addFocusListener(v3);
		txtDatmR.addKeyListener(v3);
		panDatum.add(lblDatmR);
		panDatum.add(txtDatmR);
		lValid.add(v3);
		
		JLabel lblAdrS = new JLabel("Adresa stanovanja*");
		lblAdrS.setPreferredSize(dim);
		JTextField txtAdrS = new JTextField();
		txtAdrS.setPreferredSize(dim);
		txtAdrS.setName("txtAdrS");
		txtAdrS.setToolTipText("Unesite svoju Adresu stanovanja");
		ValidacijaTextFieldFocusListener v4 = new ValidacijaTextFieldFocusListener(lblAdrS, txtAdrS,this);
		txtAdrS.addFocusListener(v4);
		txtAdrS.addKeyListener(v4);
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panAdresa.add(lblAdrS);
		panAdresa.add(txtAdrS);
		lValid.add(v4);
			
		JPanel panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBrTel = new JLabel("Kontakt telefon*");
		lblBrTel.setPreferredSize(dim);
		JTextField txtBrTel = new JTextField();
		txtBrTel.setPreferredSize(dim);
		txtBrTel.setName("txtBrTel");
		txtBrTel.setToolTipText("Broj telefona je niz od najmanje 3 a najvise 12 decimalnih cifara");
		ValidacijaTextFieldFocusListener v5 = new ValidacijaTextFieldFocusListener(lblBrTel, txtBrTel,this);
		txtBrTel.addFocusListener(v5);	
		txtBrTel.addKeyListener(v5);	
		panTel.add(lblBrTel);
		panTel.add(txtBrTel);
		lValid.add(v5);
		
		JPanel panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setToolTipText("Format emaila: korisnickoIme@domen");
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		ValidacijaTextFieldFocusListener v6 = new ValidacijaTextFieldFocusListener(lblEmail, txtEmail,this);
		txtEmail.addFocusListener(v6);
		txtEmail.addKeyListener(v6);
		panMail.add(lblEmail);
		panMail.add(txtEmail);
		lValid.add(v6);

		JPanel panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblAdrKan = new JLabel("Adresa kancelarije*");
		lblAdrKan.setPreferredSize(dim);
		JTextField txtAdrKan = new JTextField();
		txtAdrKan.setPreferredSize(dim);
		txtAdrKan.setName("txtAdrS");
		txtAdrKan.setToolTipText("Unesite adresu kancelarije");
		ValidacijaTextFieldFocusListener v7 = new ValidacijaTextFieldFocusListener(lblAdrKan, txtAdrS,this);
		txtAdrKan.addFocusListener(v7);
		txtAdrKan.addKeyListener(v7);
		panAdr.add(lblAdrKan);
		panAdr.add(txtAdrKan);
		lValid.add(v7);
				
		JPanel panLicna = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbllicna = new JLabel("Broj licne karte*:");
		lbllicna.setPreferredSize(dim);
		JTextField txtlicna = new JTextField();
		txtlicna.setPreferredSize(dim);
		txtlicna.setName("txtlicna");
		txtlicna.setToolTipText("Tacno 9 cifara");
		ValidacijaTextFieldFocusListener v8 = new ValidacijaTextFieldFocusListener(lbllicna,txtlicna,this);
		txtlicna.addFocusListener(v8);
		txtlicna.addKeyListener(v8);
		panLicna.add(lbllicna);
		panLicna.add(txtlicna);
		lValid.add(v8);
		
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(dim);
		JComboBox<String> Titule = new JComboBox<>(Titula.getValues());
		Titule.setName("Titule");	
		Titule.setPreferredSize(dim);
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panTitula.add(lblTitula);
		panTitula.add(Titule);		
		
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(dim);
		JComboBox<String> Zvanja = new JComboBox<>(Zvanje.getValues());
		Zvanja.setName("Zvanja");	
		Zvanja.setPreferredSize(dim);
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panZvanje.add(lblZvanje);
		panZvanje.add(Zvanja);

		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPotvrdi=new DiaButton("Potvrdi");
		btnPotvrdi.setEnabled(false);
		btnOdustani=new DiaButton("Odustani");
		
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
						
						Titula izabranaTitula = Titula.byOrdinal(Titule.getSelectedIndex()+1);
						Zvanje izabranoZvanje = Zvanje.byOrdinal(Zvanja.getSelectedIndex()+1);
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						dateFormat.setLenient(false);
						Date datumRodjenja = null;
						try {
							datumRodjenja = dateFormat.parse(txtDatmR.getText());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						
						
						
					Profesor profesor=new Profesor(txtPrezime.getText(),txtIme.getText(),datumRodjenja,txtAdrS.getText(),
								          txtBrTel.getText(),txtEmail.getText(),txtAdrKan.getText(),txtlicna.getText(),izabranaTitula,izabranoZvanje);
					ProfesorController.getInstance().dodajProfesora(profesor);
						dispose();
					}
				}

			});
				
		
		panButtons.add(btnPotvrdi);
		panButtons.add(btnOdustani);

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
		boxCentar.add(panButtons);
		
		
		boxCentar.add(Box.createGlue());
		add(boxCentar, BorderLayout.CENTER);
		


		}




	
	
}

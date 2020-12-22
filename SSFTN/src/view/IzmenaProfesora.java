package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;

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

import model.Profesor;
import util.ValidacijaTextFieldFocusListener;

public class IzmenaProfesora extends JDialog {
	
	private static final long serialVersionUID = 94580162855038262L;
	private JTabbedPane tpane;
	private JTable tabelaPredmetaProfesora;
	
	private ArrayList<ValidacijaTextFieldFocusListener> lValid;
	public boolean svaPoljaValidna() {
		for (ValidacijaTextFieldFocusListener val : lValid) {
			if(val.getValidacija() == false) {
				JOptionPane.showMessageDialog(this, "Greska pri unosu: "+val.getName(), "Upozorenje", 0, null);
				return false;
			}
		}
		// sve je validno okej :)
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
		ValidacijaTextFieldFocusListener vtff0 = new ValidacijaTextFieldFocusListener(lblPrezime, txtPrezime);
		txtPrezime.addFocusListener(vtff0);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.setText(profesor.getIme());
		ValidacijaTextFieldFocusListener vtff1 = new ValidacijaTextFieldFocusListener(lblIme, txtIme);
		txtIme.addFocusListener(vtff1);
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbldat = new JLabel("Datum rodjenja*:");
		lbldat.setPreferredSize(dim);
		JTextField txtDatmR = new JTextField();
		txtDatmR.setPreferredSize(dim);
		txtDatmR.setName("txtDatmRumRodjenja");
		txtDatmR.setText(profesor.getDatumRodjenja());
		ValidacijaTextFieldFocusListener vtff2 = new ValidacijaTextFieldFocusListener(lbldat, txtDatmR);
		txtIme.addFocusListener(vtff2);
		panDatum.add(lbldat);
		panDatum.add(txtDatmR);
		
		
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbladr = new JLabel("Adresa stanovanja*:");
		lbladr.setPreferredSize(dim);
		JTextField txtAdrS = new JTextField();
		txtAdrS.setPreferredSize(dim);
		txtAdrS.setName("txtAdrSesaStanovanja");
		txtAdrS.setText(profesor.getAdresaStanovanja());
		ValidacijaTextFieldFocusListener vtff3 = new ValidacijaTextFieldFocusListener(lbldat,txtAdrS);
		txtIme.addFocusListener(vtff3);
		panAdresa.add(lbladr);
		panAdresa.add(txtAdrS);
		
		
		JPanel panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbltel = new JLabel("Kontakt telefon*:");
		lbltel.setPreferredSize(dim);
		JTextField txtBrTel = new JTextField();
		txtBrTel.setPreferredSize(dim);
		txtBrTel.setName("txtKontaktTelefon");
		txtBrTel.setText(profesor.getKontaktTelefon());
		ValidacijaTextFieldFocusListener vtff4 = new ValidacijaTextFieldFocusListener(lbldat, txtBrTel);
		txtIme.addFocusListener(vtff4);
		panTel.add(lbltel);
		panTel.add(txtBrTel);
		
		
		JPanel panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblmail = new JLabel("E-mail adresa*:");
		lblmail.setPreferredSize(dim);
		JTextField txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmailAdresa");
		txtEmail.setText(profesor.getEmail());
		ValidacijaTextFieldFocusListener vtff5 = new ValidacijaTextFieldFocusListener(lbldat, txtEmail);
		txtIme.addFocusListener(vtff5);
		panMail.add(lblmail);
		panMail.add(txtEmail);
		
		
		JPanel panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblkan = new JLabel("Adresa kancelarije*:");
		lblkan.setPreferredSize(dim);
		JTextField txtAdrKan = new JTextField();
		txtAdrKan.setPreferredSize(dim);
		txtAdrKan.setName("txtAdresaKancelarije");
		txtAdrKan.setText(profesor.getAdresaKancelarije());
		ValidacijaTextFieldFocusListener vtff6 = new ValidacijaTextFieldFocusListener(lbldat,txtAdrKan);
		txtIme.addFocusListener(vtff6);
		panAdr.add(lblkan);
		panAdr.add(txtAdrKan);
		
		
		JPanel panLicna = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbllicna = new JLabel("Broj licne karte*:");
		lbllicna.setPreferredSize(dim);
		JTextField txtlicna = new JTextField();
		txtlicna.setPreferredSize(dim);
		txtlicna.setName("txtBrojLicneKarte");
		txtlicna.setText(profesor.getBrojLicneKarte());
		//txtPrezime.addFocusListener(focusListener);

		panLicna.add(lbllicna);
		panLicna.add(txtlicna);
		
		
		
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(dim);
		String[] titule = {"Doktor", "Magistar"};
		JComboBox<String> Titule = new JComboBox<>(titule);
		Titule.setName("Titule");	
		Titule.setPreferredSize(dim);
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panTitula.add(lblTitula);
		panTitula.add(Titule);	
		//String izabranaTitula = (String)Titule.getSelectedItem();
		
	
		
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(dim);
		String[] zvanja = {"Redovni profesor", "Vanredni profesor"};
		JComboBox<String> Zvanja = new JComboBox<>(zvanja);
		Zvanja.setName("Zvanja");	
		Zvanja.setPreferredSize(dim);
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panZvanje.add(lblZvanje);
		panZvanje.add(Zvanja);
		
		//String izabranoZvanje = (String)Zvanja.getSelectedItem();
		
		lValid.add(vtff0);
		lValid.add(vtff1);
		lValid.add(vtff2);
		lValid.add(vtff3);
		lValid.add(vtff4);
		lValid.add(vtff5);
		lValid.add(vtff6);
		
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		DiaButton btnPotvrdi=new DiaButton("Potvrdi");
		DiaButton btnOdustani=new DiaButton("Odustani");
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
		boxCentar.add(Box.createGlue());
		boxCentar.add(panButtons,BorderLayout.SOUTH);
		
		
		//boxCentar.add(Box.createGlue());
		panelProfesor.add(boxCentar, BorderLayout.WEST);

		
		
		
		
		
		tabelaPredmetaProfesora = new PredmetiJTable();
		JScrollPane panelPredmetiScrollPane = new JScrollPane(tabelaPredmetaProfesora);
		panelPredmeti.add(panelPredmetiScrollPane,BorderLayout.CENTER);
		
		
		
		tpane.addTab("Informacije", panelProfesor);
		tpane.addTab("Predmeti", panelPredmeti);

	
	}
}

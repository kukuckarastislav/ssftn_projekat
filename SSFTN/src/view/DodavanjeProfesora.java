package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DodavanjeProfesora extends JDialog {
	
	private static final long serialVersionUID = 945801629855038262L;
	
	public DodavanjeProfesora(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		setSize(new Dimension(500,700));
		setResizable(false);
		setLocationRelativeTo(parent);
		

		
		Dimension dim = new Dimension(120, 20);	
		
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));			
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		//txtPrezime.addFocusListener(focusListener);

		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		//txtPrezime.addFocusListener(focusListener);

		panIme.add(lblIme);
		panIme.add(txtIme);
		
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbldat = new JLabel("Datum rodjenja*:");
		lbldat.setPreferredSize(dim);
		JTextField txtdat = new JTextField();
		txtdat.setPreferredSize(dim);
		txtdat.setName("txtDatumRodjenja");
		//txtPrezime.addFocusListener(focusListener);

		panDatum.add(lbldat);
		panDatum.add(txtdat);
		
		
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbladr = new JLabel("Adresa stanovanja*:");
		lbladr.setPreferredSize(dim);
		JTextField txtadr = new JTextField();
		txtadr.setPreferredSize(dim);
		txtadr.setName("txtAdresaStanovanja");
		//txtPrezime.addFocusListener(focusListener);

		panAdresa.add(lbladr);
		panAdresa.add(txtadr);
		
		
		JPanel panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbltel = new JLabel("Kontakt telefon*:");
		lbltel.setPreferredSize(dim);
		JTextField txttel = new JTextField();
		txttel.setPreferredSize(dim);
		txttel.setName("txtKontaktTelefon");
		//txtPrezime.addFocusListener(focusListener);

		panTel.add(lbltel);
		panTel.add(txttel);
		
		
		JPanel panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblmail = new JLabel("E-mail adresa*:");
		lblmail.setPreferredSize(dim);
		JTextField txtmail = new JTextField();
		txtmail.setPreferredSize(dim);
		txtmail.setName("txtEmailAdresa");
		//txtPrezime.addFocusListener(focusListener);

		panMail.add(lblmail);
		panMail.add(txtmail);
		
		
		JPanel panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblkan = new JLabel("Adresa kancelarije*:");
		lblkan.setPreferredSize(dim);
		JTextField txtkan = new JTextField();
		txtkan.setPreferredSize(dim);
		txtkan.setName("txtAdresaKancelarije");
		//txtPrezime.addFocusListener(focusListener);

		panAdr.add(lblkan);
		panAdr.add(txtkan);
		
		
		JPanel panLicna = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbllicna = new JLabel("Broj licne karte*:");
		lbllicna.setPreferredSize(dim);
		JTextField txtlicna = new JTextField();
		txtlicna.setPreferredSize(dim);
		txtlicna.setName("txtBrojLicneKarte");
		//txtPrezime.addFocusListener(focusListener);

		panLicna.add(lbllicna);
		panLicna.add(txtlicna);
		
		
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbltit = new JLabel("Titula*:");
		lbltit.setPreferredSize(dim);
		JTextField txttit = new JTextField();
		txttit.setPreferredSize(dim);
		txttit.setName("txtTitula");
		//txtPrezime.addFocusListener(focusListener);

		panTitula.add(lbltit);
		panTitula.add(txttit);
		
		
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblzvanje = new JLabel("Zvanje*:");
		lblzvanje.setPreferredSize(dim);
		JTextField txtzvanje = new JTextField();
		txtzvanje.setPreferredSize(dim);
		txtzvanje.setName("txtZvanje");
		//txtPrezime.addFocusListener(focusListener);

		panZvanje.add(lblzvanje);
		panZvanje.add(txtzvanje);
		
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnPotvrdi=new JButton("Potvrdi");
		JButton btnOdustani=new JButton("Odustani");
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

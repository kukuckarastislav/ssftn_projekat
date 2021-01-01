package util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import view.DodavanjePredmetaDialog;
import view.DodavanjeProfesora;
import view.DodavanjeStudentaDialog;
import view.IzmenaProfesora;
import view.PanIzmenaStudentaInformacije;

public class ValidacijaTextFieldFocusListener implements KeyListener, FocusListener {
	
	Border defaultBorder = new JTextField().getBorder();
	Border errorBorder = new LineBorder(Color.RED, 1);
	
	private JLabel lbl;
	private JTextField txt;
	private boolean validacija;
	private DodavanjeStudentaDialog stdDia = null;
	private DodavanjeProfesora profDia = null;
	private IzmenaProfesora izmenaProfDia = null;
	private PanIzmenaStudentaInformacije panIzmenaStd= null;
	private String orgIndeks = null;
	private String orgLicnaKarta = null;
	private DodavanjePredmetaDialog dodPredmetaDia = null;
	private int mode = 0; 											// 0 nista 		1-dodavanjeStudenta 	2-dodavanjeProfesora
	public boolean getValidacija() {return validacija;}
	
	
	// KONSTRUKTOR
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt) {
		this.lbl = lbl;
		this.txt = txt;
		validacija = false;
		mode = 0;
	}
	
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt, final DodavanjeStudentaDialog stdDia) {
		this.lbl = lbl;
		this.txt = txt;
		validacija = false;
		this.stdDia = stdDia; 
		mode = 1;
		
	}
	
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt, final DodavanjeProfesora profDia) {
		this.lbl = lbl;
		this.txt = txt;
		validacija = false;
		this.profDia = profDia; 
		mode = 2;
	}


	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt, final IzmenaProfesora izmenaProfDia) {
		this.lbl = lbl;
		this.txt = txt;
		validacija = true; 	// ovde je pocetno stanje true jer je sve validno kad idemo da menjamo
		this.izmenaProfDia = izmenaProfDia; 
		mode = 3;	
	}
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt, 
			final IzmenaProfesora izmenaProfDia, String orgLicnaKarta) 
	{
		this.lbl = lbl;
		this.txt = txt;
		validacija = true; 	// ovde je pocetno stanje true jer je sve validno kad idemo da menjamo
		this.izmenaProfDia = izmenaProfDia; 
		this.orgLicnaKarta = orgLicnaKarta;
		mode = 3;	
	}
	public void setOrgLicnaKarta(String orgLicnaKarta) {
		this.orgLicnaKarta = orgLicnaKarta;
	}
	
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt, 
											final PanIzmenaStudentaInformacije panIzmenaStd) 
	{
		this.lbl = lbl;
		this.txt = txt;
		validacija = true; 		// ovde je pocetno stanje true jer je sve validno kad idemo da menjamo
		mode = 4;
		this.panIzmenaStd = panIzmenaStd;
	}
	
	
	// ovaj konstruktor je samo za JTextField za indeks za izmenu studenata jer imamo problem on uzme indeks
	// i kaze da nije jedinstven zato sto je to zapravo njegov indeks
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt, 
											final PanIzmenaStudentaInformacije panIzmenaStd, String orgIndeks) 
	{
		this.orgIndeks = orgIndeks;
		this.lbl = lbl;
		this.txt = txt;
		validacija = true; 	// ako idemo da menjamo studetan znamo da je sve validno do sada
		mode = 4;
		this.panIzmenaStd = panIzmenaStd;
	}
	// metoda kojom setujemo originalni indeks studenta, potrebno je zbog osvezavanja
	public void setOrgIndeks(String indeks) {
		orgIndeks = indeks;
	}


	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt,
			final DodavanjePredmetaDialog dodPredmetaDia) 
	{
		this.lbl = lbl;
		this.txt = txt;
		validacija = false;
		this.dodPredmetaDia = dodPredmetaDia;
		mode = 5;
	}


	public String getName() {
		return lbl.getText();
	}
	
	
	public void setValidacija(boolean B) {
		validacija = B;
		if(B) {
			lbl.setForeground(Color.black);
			txt.setForeground(Color.black);
			txt.setBorder(defaultBorder);
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		lbl.setForeground(Color.black);
		txt.setForeground(Color.black);
		txt.setBorder(defaultBorder);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		// kada izgubimo focus proverimo sta je to korisnik uneo
		if(txt.getName().equals("txtIme") || txt.getName().equals("txtPrezime")) {
			validacija = ValidacijaUnosa.validImePrz(txt.getText());
		}else if(txt.getName().equals("txtDatmR")) {
			validacija = ValidacijaUnosa.validDatum(txt.getText());
		}else if(txt.getName().equals("txtAdrS") || txt.getName().equals("txtAdrKan")) {
			validacija = ValidacijaUnosa.validAdresa(txt.getText());
		}else if(txt.getName().equals("txtBrTel")) {
			validacija = ValidacijaUnosa.validBrTel(txt.getText());
		}else if(txt.getName().equals("txtEmail")) {
			validacija = ValidacijaUnosa.validEmail(txt.getText());
		}else if(txt.getName().equals("txtIndeks")) {
			if(mode == 4) { 							// u slucaju izmene studenta tada ako nije diran indeks to je ok
				if(txt.getText().equals(orgIndeks)) {
					validacija = true;
				}else {
					validacija = ValidacijaUnosa.validIndeks(txt.getText()); 	 
				}
				
			}else {
				validacija = ValidacijaUnosa.validIndeks(txt.getText());
			}
	
		}else if(txt.getName().equals("txtGodUpisa")) {
			validacija = ValidacijaUnosa.validGodUpisa(txt.getText());
		}else if(txt.getName().equals("txtlicna")) {
			if(mode == 3) { 	// to je mode gde menjamoInformacije za profesora
				if(txt.getText().equals(orgLicnaKarta)) {
					validacija = true; 				// ako je licna karta ne promenjena onda je true
				}else {
					validacija = ValidacijaUnosa.validBrLicne(txt.getText());
				}
			}else {
				validacija = ValidacijaUnosa.validBrLicne(txt.getText());
			}
			
		
		}else if(txt.getName().equals("txtSifra")) {
			validacija = ValidacijaUnosa.validSifraPredmeta(txt.getText());
		}else if(txt.getName().equals("txtNaziv")) {
			validacija = ValidacijaUnosa.validNazivPredmeta(txt.getText());
		}else if(txt.getName().equals("txtBrojESPB")) {
			validacija = ValidacijaUnosa.validESPB(txt.getText());
		}
		
		
		
		if(validacija) {
			// valja unos
			lbl.setForeground(Color.black);
			txt.setForeground(Color.black);
			txt.setBorder(defaultBorder);
		}else {
			// ne valja unos
			lbl.setForeground(Color.red);
			txt.setForeground(Color.red);
			txt.setBorder(errorBorder);
		}
		
		if(mode == 1) {
			if(stdDia != null) {
				stdDia.omoguciDugmePotvrdi();
			}
		}else if(mode == 2) {
			if(profDia != null) {
				profDia.omoguciDugmePotvrdi();
			}
		}else if(mode == 3) {
			if(izmenaProfDia != null) {
				izmenaProfDia.omoguciDugmePotvrdi();
			}
		}else if(mode == 4) {
			if(panIzmenaStd != null) {
				panIzmenaStd.omoguciDugmePotvrdi();
			}
		}else if(mode == 5) {
			if(dodPredmetaDia != null) {
				dodPredmetaDia.omoguciDugmePotvrdi();
			}
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent arg0){
		if(txt.getName().equals("txtIme") || txt.getName().equals("txtPrezime")) {
			validacija = ValidacijaUnosa.validImePrz(txt.getText());
		}else if(txt.getName().equals("txtDatmR")) {
			validacija = ValidacijaUnosa.validDatum(txt.getText());
		}else if(txt.getName().equals("txtAdrS") || txt.getName().equals("txtAdrKan")) {
			validacija = ValidacijaUnosa.validAdresa(txt.getText());
		}else if(txt.getName().equals("txtBrTel")) {
			validacija = ValidacijaUnosa.validBrTel(txt.getText());
		}else if(txt.getName().equals("txtEmail")) {
			validacija = ValidacijaUnosa.validEmail(txt.getText());
		}else if(txt.getName().equals("txtIndeks")) {
			
			if(mode == 4) { 							// u slucaju izmene studenta tada ako nije diran indeks to je ok
				if(txt.getText().equals(orgIndeks)) {
					validacija = true;
				}else {
					validacija = ValidacijaUnosa.validIndeks(txt.getText()); 	 
				}
				
			}else {
				validacija = ValidacijaUnosa.validIndeks(txt.getText());
			}
			
			
		}else if(txt.getName().equals("txtGodUpisa")) {
			validacija = ValidacijaUnosa.validGodUpisa(txt.getText());
		}else if(txt.getName().equals("txtlicna")) {
			if(mode == 3) { 	// to je mode gde menjamoInformacije za profesora
				if(txt.getText().equals(orgLicnaKarta)) {
					validacija = true; 				// ako je licna karta ne promenjena onda je true
				}else {
					validacija = ValidacijaUnosa.validBrLicne(txt.getText());
				}
			}else {
				validacija = ValidacijaUnosa.validBrLicne(txt.getText());
			}
			
		
		}else if(txt.getName().equals("txtSifra")) {
			validacija = ValidacijaUnosa.validSifraPredmeta(txt.getText());
		}else if(txt.getName().equals("txtNaziv")) {
			validacija = ValidacijaUnosa.validNazivPredmeta(txt.getText());
		}else if(txt.getName().equals("txtBrojESPB")) {
			validacija = ValidacijaUnosa.validESPB(txt.getText());
		}
		
		
		
		
		//System.out.println(txt.getName()+" "+txt.getText());
		if(mode == 1) {
			if(stdDia != null) {
				stdDia.omoguciDugmePotvrdi();
			}
		}else if(mode == 2) {
			if(profDia != null) {
				profDia.omoguciDugmePotvrdi();
			}
		}else if(mode == 3) {
			if(izmenaProfDia != null) {
				izmenaProfDia.omoguciDugmePotvrdi();
			}
		}else if(mode == 4) {
			if(panIzmenaStd != null) {
				panIzmenaStd.omoguciDugmePotvrdi();
			}
		}else if(mode == 5) {
			if(dodPredmetaDia != null) {
				dodPredmetaDia.omoguciDugmePotvrdi();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent arg0) {}


}

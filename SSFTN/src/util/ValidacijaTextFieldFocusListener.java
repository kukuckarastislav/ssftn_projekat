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

import view.DodavanjeProfesora;
import view.DodavanjeStudentaDialog;
import view.IzmenaProfesora;

public class ValidacijaTextFieldFocusListener implements KeyListener, FocusListener {
	
	Border defaultBorder = new JTextField().getBorder();
	Border errorBorder = new LineBorder(Color.RED, 1);
	
	private JLabel lbl;
	private JTextField txt;
	private boolean validacija;
	private DodavanjeStudentaDialog stdDia = null;
	private DodavanjeProfesora profDia = null;
	private IzmenaProfesora izmenaProfDia = null;
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
		validacija = false;
		this.izmenaProfDia = izmenaProfDia; 
		mode = 3;
		
	}


	public String getName() {
		return lbl.getText();
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
			validacija = ValidacijaUnosa.validIndeks(txt.getText());
		}else if(txt.getName().equals("txtGodUpisa")) {
			validacija = ValidacijaUnosa.validGodUpisa(txt.getText());
		}else if(txt.getName().equals("txtlicna")) {
			validacija = ValidacijaUnosa.validBrLicne(txt.getText());
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
				//izmenaProfDia.omoguciDugmePotvrdi();
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
			validacija = ValidacijaUnosa.validIndeks(txt.getText());
		}else if(txt.getName().equals("txtGodUpisa")) {
			validacija = ValidacijaUnosa.validGodUpisa(txt.getText());
		}else if(txt.getName().equals("txtlicna")) {
			validacija = ValidacijaUnosa.validBrLicne(txt.getText());
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
				//izmenaProfDia.omoguciDugmePotvrdi();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent arg0) {}


}

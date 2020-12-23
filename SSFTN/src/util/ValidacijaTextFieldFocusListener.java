package util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ValidacijaTextFieldFocusListener implements FocusListener {
	
	Border defaultBorder = new JTextField().getBorder();
	Border errorBorder = new LineBorder(Color.RED, 1);
	
	private JLabel lbl;
	private JTextField txt;
	private boolean validacija;
	public boolean getValidacija() {return validacija;}
	
	// KONSTRUKTOR
	public ValidacijaTextFieldFocusListener(final JLabel lbl, final JTextField txt) {
		this.lbl = lbl;
		this.txt = txt;
		validacija = false;
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
		
	}

}

package view;
/*
 *  Klasa koju cemo koristiti za isti stil i diazajn svih dugmica na dialozima
 */

import java.awt.Color;

import javax.swing.JButton;

public class DiaButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1822947607830895966L;
	
	private Color plavaBoja = new Color(84, 158, 255);

	public DiaButton() {
		setBackground(plavaBoja);
	}
	
	public DiaButton(String txt) {
		super(txt);
		setBackground(plavaBoja);
	}
	
	
	
}

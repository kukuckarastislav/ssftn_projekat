package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class ProfesorFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {

		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
		
		
	

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.BLUE);


			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Popunite polje...")) {
				txt.setText("Popunite polje...");
				txt.requestFocus();
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
			

			if (txt.getName().equals("txtPrezime")) {	
			
			
		

			}
			
	}
}

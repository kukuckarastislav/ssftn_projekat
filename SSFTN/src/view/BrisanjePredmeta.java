package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class BrisanjePredmeta implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		JFrame frame = (JFrame) arg0.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da želite da obrišete predmet?",
				"Brisanje predmeta", JOptionPane.YES_NO_OPTION);
		if (code != JOptionPane.YES_OPTION) {
			
			// uradi nista//
		} else {
			
			//akcija za brisanje predmeta//
		}


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}


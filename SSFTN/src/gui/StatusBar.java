package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		
		Dimension dimSB = new Dimension(100,26); 	// vazno nam je da se ispostuje druga komponenta
		Color col = new Color(255,255,255);	//
		
		
		setPreferredSize(dimSB);
		setBackground(col);
		
		BoxLayout panStatusBar = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(panStatusBar);
		
		JLabel labStSl = new JLabel("Studentska Slu\u017eba");
		labStSl.setPreferredSize(new Dimension(150,26)); 	

		// ZA sada ovo prikazuje vreme ali ih ne osvezava
		
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.YYYY");
		JLabel labDatum = new JLabel(dateFormat.format(localDate));	 // 
		
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
		JLabel labVreme = new JLabel(localTime.format(timeFormat));
		
		
		
		
		add(Box.createHorizontalStrut(5));
		add(labStSl);
		add(Box.createGlue());
		add(labVreme);
		add(Box.createHorizontalStrut(5));
		add(labDatum);
		add(Box.createHorizontalStrut(25));
		
		
		
	}
	
	
	
	

}
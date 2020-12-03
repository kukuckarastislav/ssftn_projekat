package view;

//OVO JE FRAME1 ZA PROJEKAT, U SLUCAJU ZABUNE

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class Frame1 extends JFrame{
	
	private static final long serialVersionUID = 945801629855138262L;
	
	public Frame1() {
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	
	setSize(screenWidth * 3 / 4, screenHeight * 3/4);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Studentska sluzba");   //po defaultu je poravnato uz lijevu ivicu 
	setLocationRelativeTo(null);
	
	// MenuBar
	MenuBar menuBar = new MenuBar();
	setJMenuBar(menuBar);
	
	// Toolbar
	Toolbar toolbar = new Toolbar();
	add(toolbar, BorderLayout.NORTH);
	
	
	// StatusBar
	StatusBar statusBar = new StatusBar();
	add(statusBar, BorderLayout.SOUTH);
	

	}

}

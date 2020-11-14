package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


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
	
	// mesto za dodavanje MenuBar-a
	MenuBar menuBar = new MenuBar();
	setJMenuBar(menuBar);
	
	
	Toolbar toolbar = new Toolbar();
	add(toolbar, BorderLayout.NORTH);
	
	// Mesto za dodavnaja status Bara
	
	
	
	}

}

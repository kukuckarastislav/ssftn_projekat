package view;

//OVO JE FRAME1 ZA PROJEKAT, U SLUCAJU ZABUNE

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class Frame1 extends JFrame{
	
	
	private static final long serialVersionUID = 945801629855138262L;
	
	private JTable tabelaStudenata;
	
	private static Frame1 instance = null;

	public static Frame1 getInstance() {
		if(instance == null) {
			instance = new Frame1();
		}
		return instance;
	}
	
	
	private Frame1() {
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	
	setSize(screenWidth * 3 / 4, screenHeight * 3/4);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Studentska sluzba");   //po defaultu je poravnato uz lijevu ivicu 
	setLocationRelativeTo(null);
	setVisible(true);
	// MenuBar
	MenuBar menuBar = new MenuBar(this);
	setJMenuBar(menuBar);
	
	// Toolbar
	Toolbar toolbar = new Toolbar();
	add(toolbar, BorderLayout.NORTH);
	
	
	// StatusBar
	StatusBar statusBar = new StatusBar();
	add(statusBar, BorderLayout.SOUTH);
	
	// ============================================================
	tabelaStudenata = new StudentiJTable();
	JScrollPane panelStudentiScrollPane = new JScrollPane(tabelaStudenata);
	add(panelStudentiScrollPane,BorderLayout.CENTER);
	azurirajPrikazTabeleStudenata("POCETNA", 0);
	



	}
	
	public void azurirajPrikazTabeleStudenata(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
	
	
	
	
}

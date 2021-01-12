package view;

//OVO JE FRAME1 ZA PROJEKAT, U SLUCAJU ZABUNE

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;

public class Frame1 extends JFrame{
	
	
	private static final long serialVersionUID = 945801629855138262L;
	
	private JTable tabelaStudenata;
	private JTable tabelaProfesora;
	private JTable tabelaPredmeta;	
	private JTabbedPane tpane;
	
	private int rowSlectedProfesor;
	
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
	
	addWindowListener(new MyWindowListener());
	
	// MenuBar
	MenuBar menuBar = new MenuBar(this);
	setJMenuBar(menuBar);
	
	// Toolbar
	Toolbar toolbar = new Toolbar(this);
	add(toolbar, BorderLayout.NORTH);
	
	
	// StatusBar
	StatusBar statusBar = new StatusBar();
	add(statusBar, BorderLayout.SOUTH);
	
	// ============================================================
	
	// Tabovi
	JPanel centralniPanel = new JPanel(new BorderLayout());
	add(centralniPanel, BorderLayout.CENTER);
	
	// iz estetike paneli
	JPanel gornjiPanel = new JPanel(); 		gornjiPanel.setPreferredSize(new Dimension(50,50));
	JPanel donjiPanel = new JPanel();		donjiPanel.setPreferredSize(new Dimension(50,50));
	JPanel leviPanel = new JPanel();		leviPanel.setPreferredSize(new Dimension(50,50));
	JPanel desniPanel = new JPanel(); 		desniPanel.setPreferredSize(new Dimension(50,50));
	JPanel tablePanel = new JPanel(new BorderLayout());
	//tablePanel.setBackground(new Color(255,255,255));
	
	centralniPanel.add(gornjiPanel,BorderLayout.NORTH);
	centralniPanel.add(donjiPanel,BorderLayout.SOUTH);
	centralniPanel.add(leviPanel,BorderLayout.WEST);
	centralniPanel.add(desniPanel,BorderLayout.EAST);
	centralniPanel.add(tablePanel,BorderLayout.CENTER);
	
	tpane = new JTabbedPane();
	tablePanel.add(tpane,BorderLayout.CENTER);
	
	
	
	
	// napraviti tablice za studenta, profesora i predmete
	JPanel panelStudenti = new JPanel(new BorderLayout());
	JPanel panelProfesori = new JPanel(new BorderLayout());
	JPanel panelPredmeti = new JPanel(new BorderLayout());
	
	tabelaStudenata = new StudentiJTable();
	JScrollPane panelStudentiScrollPane = new JScrollPane(tabelaStudenata);
	panelStudenti.add(panelStudentiScrollPane ,BorderLayout.CENTER);
	azurirajPrikazTabeleStudenata("POCETNA", 0);
	
	tabelaProfesora = new ProfesoriJTable();
	TableColumnModel tcm = tabelaProfesora.getColumnModel();
	tcm.getColumn(4).setMinWidth(0); 			// ovako cemo da sakrijemo vizualno kolonu sa licnom kartom
	tcm.getColumn(4).setMaxWidth(0);
	JScrollPane panelProfesoriScrollPane = new JScrollPane(tabelaProfesora);
	panelProfesori.add(panelProfesoriScrollPane,BorderLayout.CENTER);
	azurirajPrikazTabeleProfesora("POCETNA", 0);
	
	tabelaPredmeta = new PredmetiJTable();
	JScrollPane panelPredmetiScrollPane = new JScrollPane(tabelaPredmeta);
	panelPredmeti.add(panelPredmetiScrollPane,BorderLayout.CENTER);
	azurirajPrikazTabelePredmeta("POCETNA", 0);

	
	tpane.addTab("Studenti", panelStudenti);
	tpane.addTab("Profesori", panelProfesori);
	tpane.addTab("Predmeti", panelPredmeti);
	
	tabelaProfesora.getCellSelectionEnabled();
	tabelaProfesora.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	tabelaStudenata.setAutoCreateRowSorter(true);
	//((StudentiJTable) tabelaStudenata).sorted();
	
	tabelaProfesora.setAutoCreateRowSorter(true);
	((ProfesoriJTable) tabelaProfesora).sorted();
	
	tabelaPredmeta.setAutoCreateRowSorter(true);
	((PredmetiJTable) tabelaPredmeta).sorted();

	}
	
	public void azurirajPrikazTabeleStudenata(String akcija, int vrednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazTabeleProfesora(String akcija, int vrednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
	public void azurirajPrikazTabelePredmeta(String akcija, int vrednost) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
	
	
	public int getSelectedTab() {
		return tpane.getSelectedIndex();
	}
	
	public int getSelectedProfesor() {
		rowSlectedProfesor = tabelaProfesora.getSelectedRow(); 
		return rowSlectedProfesor;
	}
	// 		ovo je isto kao sto je pre bilo getSelectedStudent
	public int getSelectedStudentIndexInTable() {
		// vraca indeks sta smo mi selektovali
		// al onda bi morali i bazu studente da sortiramo kako bi se indksi poklapali
		// ovo ne mozemo koristiti nakon sortiranja
		return tabelaStudenata.getSelectedRow();
	}
	
	public int getSelectedPredmet() {
		return tabelaPredmeta.getSelectedRow();
	}
	
	
	
	public String getSelectedStudentByIndeks() {
		String indeksStudenta = (String) tabelaStudenata.getValueAt(getSelectedStudentIndexInTable(), 0);
		System.out.println("Indeks selektovanog studenta: "+indeksStudenta);
		return indeksStudenta;
	}
	
	public String getSelectedProfesorByLicnaKarta() {
		String licnaKarta = (String) tabelaProfesora.getValueAt(getSelectedProfesor(), 4);
		System.out.println(licnaKarta);
		return licnaKarta;
	}
	public String getSelectedPredmetBySifraPredmeta() {
		String sifraPredmeta = (String) tabelaPredmeta.getValueAt(getSelectedPredmet(), 0);
		System.out.println(sifraPredmeta);
		return sifraPredmeta;
	}	
		
}


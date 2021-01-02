package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import controller.ProfesorController;
import controller.StudentController;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import util.ValidacijaTextFieldFocusListener;

public class IzmenaProfesora extends JDialog {
	
	private static final long serialVersionUID = 94580162855038262L;
	
	private JTabbedPane tpane;
	private JTable tabelaPredmetaProfesora;	
	private ArrayList<ValidacijaTextFieldFocusListener> lValid;
	private Profesor aktuelniProfesor;
	
	public boolean svaPoljaValidna() {
		for (ValidacijaTextFieldFocusListener val : lValid) {
			if(val.getValidacija() == false) {
				//JOptionPane.showMessageDialog(this, "Greska pri unosu: "+val.getName(), "Upozorenje", 0, null);
				return false;
			}
		}
		return true;
	}
	
	private DiaButton btnPotvrdi;
	private DiaButton btnOdustani;
	
	private JTextField txtPrezime;
	private JTextField txtIme;
	private JTextField txtDatmR;
	private JTextField txtAdrS;
	private JTextField txtBrTel;
	private JTextField txtEmail;
	private JTextField txtAdrKan;
	private JTextField txtlicna;
	private JComboBox<String> cbTitule;
	private JComboBox<String> cbZvanja;
	
	public void omoguciDugmePotvrdi() {
		if(svaPoljaValidna()) {
			btnPotvrdi.setEnabled(true);
		}else {
			btnPotvrdi.setEnabled(false);
		}
	}
	
	public void inicijalizujPolja() {
		txtPrezime.setText(aktuelniProfesor.getPrezime());
		txtIme.setText(aktuelniProfesor.getIme());
		// referenca za konverziju Date to String 
		// https://www.javatpoint.com/java-date-to-string
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		txtDatmR.setText(dateFormat.format(aktuelniProfesor.getDatumRodjenja()));
		txtAdrS.setText(aktuelniProfesor.getAdresaStanovanja());
		txtBrTel.setText(aktuelniProfesor.getKontaktTelefon());
		txtEmail.setText(aktuelniProfesor.getEmail());
		txtAdrKan.setText(aktuelniProfesor.getAdresaKancelarije());
		txtlicna.setText(aktuelniProfesor.getBrojLicneKarte());
		cbTitule.setSelectedIndex( aktuelniProfesor.getTitula().ordinal() );
		cbZvanja.setSelectedIndex( aktuelniProfesor.getZvanje().ordinal() );
		
		// kad inicijalizujemo opet vrednosti pocetno stanje svih polja bi trebalo da bude true
		// jer je validno
		for (ValidacijaTextFieldFocusListener val : lValid) {
			val.setValidacija(true);
		}
		
	}
	

	public IzmenaProfesora(Frame parent, String naslov,Profesor profesor) {		
		super(parent,naslov,true);
		
		aktuelniProfesor=profesor;
		BazaPredmeti.getInstance().prepareSubjectDisplay(aktuelniProfesor);
		

		setSize(490,550);
		setResizable(false);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		Dimension dim = new Dimension(150, 20);
		
		lValid = new ArrayList<ValidacijaTextFieldFocusListener>();
		
		tpane = new JTabbedPane();
		this.add(tpane,BorderLayout.CENTER);
		
		JPanel panelProfesor = new JPanel();
		JPanel panelPredmeti = new JPanel();
		
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));			
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);
		txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.setText(profesor.getPrezime());
		ValidacijaTextFieldFocusListener v1 = new ValidacijaTextFieldFocusListener(lblPrezime, txtPrezime,this);
		txtPrezime.addFocusListener(v1);
		txtPrezime.addKeyListener(v1);
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		
		
		
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.setText(profesor.getIme());
		ValidacijaTextFieldFocusListener v2 = new ValidacijaTextFieldFocusListener(lblIme, txtIme,this);
		txtIme.addFocusListener(v2);
		txtIme.addKeyListener(v2);
		panIme.add(lblIme);
		panIme.add(txtIme);
		
		
		
		
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDatmR = new JLabel("Datum rodjenja*");
		lblDatmR.setPreferredSize(dim);
		txtDatmR = new JTextField();
		txtDatmR.setPreferredSize(dim);
		txtDatmR.setName("txtDatmR");
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		txtDatmR.setText( dateFormat.format(profesor.getDatumRodjenja()) );
		txtDatmR.setToolTipText("Na datumu cemo jos da poradimo..");
		ValidacijaTextFieldFocusListener v3 = new ValidacijaTextFieldFocusListener(lblDatmR, txtDatmR,this);
		txtDatmR.addFocusListener(v3);	
		txtDatmR.addKeyListener(v3);
		panDatum.add(lblDatmR);
		panDatum.add(txtDatmR);
		
		
		JLabel lblAdrS = new JLabel("Adresa stanovanja*");
		lblAdrS.setPreferredSize(dim);
		txtAdrS = new JTextField();
		txtAdrS.setPreferredSize(dim);
		txtAdrS.setName("txtAdrS");
		txtAdrS.setText(profesor.getAdresaStanovanja());
		ValidacijaTextFieldFocusListener v4 = new ValidacijaTextFieldFocusListener(lblAdrS, txtAdrS,this);
		txtAdrS.addFocusListener(v4);
		txtAdrS.addKeyListener(v4);
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panAdresa.add(lblAdrS);
		panAdresa.add(txtAdrS);
		
		
		JPanel panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBrTel = new JLabel("Kontakt telefon*");
		lblBrTel.setPreferredSize(dim);
		txtBrTel = new JTextField();
		txtBrTel.setPreferredSize(dim);
		txtBrTel.setName("txtBrTel");
		txtBrTel.setText(profesor.getKontaktTelefon());
		txtBrTel.setToolTipText("Broj telefona je niz od najmanje 3 a najvise 12 decimalnih cifara");
		ValidacijaTextFieldFocusListener v5 = new ValidacijaTextFieldFocusListener(lblBrTel, txtBrTel,this);
		txtBrTel.addFocusListener(v5);	
		txtBrTel.addKeyListener(v5);
		panTel.add(lblBrTel);
		panTel.add(txtBrTel);
		
		
		JPanel panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblEmail = new JLabel("E-mail adresa*");
		lblEmail.setPreferredSize(dim);
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Format emaila: korisnickoIme@domen");
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		txtEmail.setText(profesor.getEmail());
		ValidacijaTextFieldFocusListener v6 = new ValidacijaTextFieldFocusListener(lblEmail, txtEmail,this);
		txtEmail.addFocusListener(v6);
		txtEmail.addKeyListener(v6);
		panMail.add(lblEmail);
		panMail.add(txtEmail);
		
		

		JPanel panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblAdrKan = new JLabel("Adresa kancelarije*");
		lblAdrKan.setPreferredSize(dim);
		txtAdrKan = new JTextField();
		txtAdrKan.setPreferredSize(dim);
		txtAdrKan.setName("txtAdrS");
		txtAdrKan.setText(profesor.getAdresaKancelarije());
		ValidacijaTextFieldFocusListener v7 = new ValidacijaTextFieldFocusListener(lblAdrKan, txtAdrS,this);
		txtAdrKan.addFocusListener(v7);
		txtAdrKan.addKeyListener(v7);
		panAdr.add(lblAdrKan);
		panAdr.add(txtAdrKan);
		
		
	
		JPanel panLicna = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbllicna = new JLabel("Broj licne karte*:");
		lbllicna.setPreferredSize(dim);
		txtlicna = new JTextField();
		txtlicna.setPreferredSize(dim);
		txtlicna.setName("txtlicna");
		txtlicna.setText(profesor.getBrojLicneKarte());
		txtBrTel.setToolTipText("Tacno 9 cifara");
		ValidacijaTextFieldFocusListener v8 = new ValidacijaTextFieldFocusListener(lbllicna,txtlicna,this, 
															aktuelniProfesor.getBrojLicneKarte());
		txtlicna.addFocusListener(v8);
		txtlicna.addKeyListener(v8);
		panLicna.add(lbllicna);
		panLicna.add(txtlicna);
		
		
		
		
		
		JLabel lblTitula = new JLabel("Titula*");
		lblTitula.setPreferredSize(dim);
		String[] tituleStr = {"BSc","MSc","mr","dr","profDr"};
		cbTitule = new JComboBox<>(tituleStr);
		cbTitule.setName("Titule");	
		cbTitule.setPreferredSize(dim);
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panTitula.add(lblTitula);
		panTitula.add(cbTitule);	
	
		JLabel lblZvanje = new JLabel("Zvanje*");
		lblZvanje.setPreferredSize(dim);
		String[] zvanjaStr = {"Saradnik u nastavi","Asistent","Asistent sa doktoratom","Docent","Vanredni profesor","Redovni profesor","Profesor emeritus"};
		cbZvanja = new JComboBox<>(zvanjaStr);
		cbZvanja.setName("Zvanja");	
		cbZvanja.setPreferredSize(dim);
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panZvanje.add(lblZvanje);
		panZvanje.add(cbZvanja);
	
		lValid.add(v1);
		lValid.add(v2);
		lValid.add(v3);
		lValid.add(v4);
		lValid.add(v5);
		lValid.add(v6);
		lValid.add(v7);
		lValid.add(v8);
		
		
		// INICIJALIZACIJA SVIH PODATAKA
		inicijalizujPolja();
		
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPotvrdi=new DiaButton("Potvrdi");
		btnOdustani=new DiaButton("Odustani");
		panButtons.add(btnPotvrdi);
		panButtons.add(btnOdustani);
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inicijalizujPolja(); // mozda bolje da sve vrati na incijalno
				//dispose();
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(svaPoljaValidna()) {
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						dateFormat.setLenient(false);
						Date datumRodjenja = null;
						try {
							datumRodjenja = dateFormat.parse(txtDatmR.getText());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						Profesor noviProfesor = new Profesor();
						
						noviProfesor.setIme(txtIme.getText());
						noviProfesor.setPrezime(txtPrezime.getText());
						noviProfesor.setDatumRodjenja(datumRodjenja);
						noviProfesor.setAdresaStanovanja(txtAdrS.getText());
						noviProfesor.setKontaktTelefon(txtBrTel.getText());
						noviProfesor.setEmail(txtEmail.getText());
						noviProfesor.setAdresaKancelarije(txtAdrKan.getText());
						noviProfesor.setBrojLicneKarte(txtlicna.getText());
						v8.setOrgLicnaKarta(noviProfesor.getBrojLicneKarte());
						noviProfesor.setTitula(Titula.byOrdinal( cbTitule.getSelectedIndex()+1 ));
						noviProfesor.setZvanje( Zvanje.byOrdinal( cbZvanja.getSelectedIndex()+1 ));
						
						ProfesorController.getInstance().izmeniProfesora(aktuelniProfesor, noviProfesor);
						
					}else {
						
					}
				}
			});
				
		
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panPrezime);
		boxCentar.add(panIme);
		boxCentar.add(panDatum);		
		boxCentar.add(panAdresa);
		boxCentar.add(panTel);
		boxCentar.add(panMail);
		boxCentar.add(panAdr);
		boxCentar.add(panLicna);
		boxCentar.add(panTitula);
		boxCentar.add(panZvanje);
		boxCentar.add(Box.createGlue());
		boxCentar.add(panButtons,BorderLayout.SOUTH);	
		boxCentar.add(Box.createGlue());
		panelProfesor.add(boxCentar, BorderLayout.WEST);

		
		JPanel ButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		DiaButton btnDodaj=new DiaButton("Dodaj predmet");		
		DiaButton btnUkloni=new DiaButton("Ukloni predmet");
		ButtonPanel.add(btnDodaj);
		ButtonPanel.add(btnUkloni);
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				DodavanjePredmetaProfesoru dpp=new DodavanjePredmetaProfesoru(parent,aktuelniProfesor);
				Predmet pred=dpp.selektovaniPredmet();
				ProfesorController.getInstance().dodajPredmetProfesoru(profesor,pred);
				//BazaPredmeti.getInstance().podajPredmetProfesoru(pred);
				azurirajPrikazTabelePredmeta("DOPUNA" ,1);
				//dispose();
			}
		});
		
		btnUkloni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selProf = getSelectedPredmet();
				if(selProf == -1) {
					JOptionPane.showMessageDialog(null, "Selektujte Predmet koji želite da uklonite sa Profesora", "Ukloni Predmet", 0, null);
				}else {
					String poruka = "Da li ste sigurni da želite da uklonite predmet profesoru?";
					int option = JOptionPane.showConfirmDialog((JFrame)parent, poruka, "Ukloni predmet", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						Predmet predmet = aktuelniProfesor.getPredmetiNaKojimaJeProfesor().get(selProf);
						aktuelniProfesor.ukloniPredmetProfesoru(predmet);
						azurirajPrikazTabelePredmeta("UKLANJANJE PREDMETA",3);
					}
				}
			}
		});
		
		
		
		tabelaPredmetaProfesora = new tabelaPredmetaprofesora();
		JScrollPane panelPredmetiScrollPane = new JScrollPane(tabelaPredmetaProfesora);
		
		panelPredmeti.add(ButtonPanel,BorderLayout.NORTH);
		panelPredmeti.add(panelPredmetiScrollPane,BorderLayout.CENTER);
			
		tpane.addTab("Informacije", panelProfesor);
		tpane.addTab("Predmeti", panelPredmeti);
	}
	
	
	
		// TABELA PREDMETA PROFESORA
	
	private class tabelaPredmetaprofesora extends JTable{
		private static final long serialVersionUID = -3805554009583860187L;
		
		public tabelaPredmetaprofesora() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			setModel(new AbstractTablePredmetiProfesora());
		}
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

			Component c = super.prepareRenderer(renderer, row, column);
			if (isRowSelected(row)) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}
		
	}
	
	private class AbstractTablePredmetiProfesora extends AbstractTableModel{

		private static final long serialVersionUID = 2335644876350909315L;

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public int getRowCount() {
			return BazaPredmeti.getInstance().getPredmetiIzabranogProfesora().size();
			}

		@Override
		public String getValueAt(int rowIndex, int columnIndex) {
			return BazaPredmeti.getInstance().getPredmetiProfesora(rowIndex, columnIndex); 
		}
		@Override
		public String getColumnName(int column) {
			return BazaPredmeti.getInstance().getNazivTrazenihKolona(column);
		}

	}
	
	public void azurirajPrikazTabelePredmeta(String akcija, int vrednost) {
		AbstractTablePredmetiProfesora model = (AbstractTablePredmetiProfesora) tabelaPredmetaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public int getSelectedPredmet() {
		return tabelaPredmetaProfesora.getSelectedRow();
	}
	
	
}


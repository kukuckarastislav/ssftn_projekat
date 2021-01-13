package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.ProfesorController;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import util.ValidacijaTextFieldFocusListener;

public class IzmenaPredmetaDialog extends JDialog{


	private static final long serialVersionUID = 1414553383899489915L;
	
	private final Frame parent;
	private Predmet predmet;
	
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JComboBox<String> godinaIzvodjenja;
	private JComboBox<String> semestarIzvodjenja;
	private JTextField txtBrojESPB;
	private JTextField txtGlavniProf;
	
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JLabel lblGodina;
	private JLabel lblSemestar;
	private JLabel lblESPB;
	private JLabel lblProfesor;
	
	
	private DiaButton btnDodajProf;
	private DiaButton btnUkloniProf;
	private DiaButton btnPotvrdi;
	private DiaButton btnOdustani;
	
	private Dimension dimKomp;		// dimenzija za dugacke komponenete
	private Dimension dimLbl; 		// dimanzija za labelu
	
	private Profesor profesor;
	// metoda da dodamo profesora iz dialoga za dodavanje profesora
	public void setPredmetniProfesor(Profesor pro) {
		profesor = pro;
	}
	
	private void inicijalizujPolja() {
		
		txtSifra.setText( predmet.getSifraPredmeta() );
		txtNaziv.setText( predmet.getNazivPredmeta() );
		txtBrojESPB.setText( String.valueOf(predmet.getBrojESPBbodova()) );
		semestarIzvodjenja.setSelectedIndex( predmet.getSemestar().ordinal() );
		godinaIzvodjenja.setSelectedIndex( predmet.getGodinaStudijaUKojojSePredmetIzvodi() - 1 );
		if(predmet.getPredmetniProfesor() != null) {
			profesor = predmet.getPredmetniProfesor();
			txtGlavniProf.setText(profesor.getIme()+" "+profesor.getPrezime());
			setOmoguciDodavanjeProfesora(false);
		}else {
			txtGlavniProf.setText("");
			setOmoguciDodavanjeProfesora(true);
		}
		
		for (ValidacijaTextFieldFocusListener val : lValid) {
			val.setValidacija(true);
		}
	
	}
	
	
	
	private ArrayList<ValidacijaTextFieldFocusListener> lValid;
	public boolean svaPoljaValidna() {
		for (ValidacijaTextFieldFocusListener val : lValid) {
			if(val.getValidacija() == false) {
				//JOptionPane.showMessageDialog(this, "Greska pri unosu: "+val.getName(), "Upozorenje", 0, null);
				return false;
			}
		}
		// sve je validno okej :)
		return true;
	}
	
	
	public void omoguciDugmePotvrdi() {
		if(svaPoljaValidna()) {
			btnPotvrdi.setEnabled(true);
		}else {
			btnPotvrdi.setEnabled(false);
		}
	}
	
	public void setOmoguciDodavanjeProfesora(boolean omoguc) {
		if(omoguc) {
			btnDodajProf.setEnabled(true);
			btnUkloniProf.setEnabled(false);
		}else {
			btnDodajProf.setEnabled(false);
			btnUkloniProf.setEnabled(true);
		}
	}
	
	
	public IzmenaPredmetaDialog(Frame parent, Predmet predmet) {
		super(parent, "Izmena Predmeta", true);
		this.predmet = predmet;
		
		this.parent = parent;
		
		setSize(450,450);
		setResizable(false);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		
		dimLbl = new Dimension(120,20);
		dimKomp = new Dimension(220,20);
		
		lValid = new ArrayList<ValidacijaTextFieldFocusListener>();
		profesor = null;
		
		lblSifra = new JLabel("Šifra*");
		lblSifra.setToolTipText("Sifra mora biti jedinstvena");
		lblSifra.setPreferredSize(dimLbl);
		txtSifra = new JTextField();
		txtSifra.setName("txtSifra");
		txtSifra.setToolTipText("Sifra mora biti jedinstvena");
		txtSifra.setPreferredSize(dimKomp);
		ValidacijaTextFieldFocusListener vtffl0 = new ValidacijaTextFieldFocusListener(lblSifra, txtSifra,this,predmet.getSifraPredmeta());
		txtSifra.addFocusListener(vtffl0);
		txtSifra.addKeyListener(vtffl0);
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		
		
		
		lblNaziv = new JLabel("Naziv*");
		lblNaziv.setToolTipText("Naziv predmeta");
		lblNaziv.setPreferredSize(dimLbl);
		txtNaziv = new JTextField();
		txtNaziv.setName("txtNaziv");
		txtNaziv.setToolTipText("Naziv predmeta");
		txtNaziv.setPreferredSize(dimKomp);
		ValidacijaTextFieldFocusListener vtffl1 = new ValidacijaTextFieldFocusListener(lblNaziv, txtNaziv,this);
		txtNaziv.addFocusListener(vtffl1);
		txtNaziv.addKeyListener(vtffl1);
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		
		

		lblGodina = new JLabel("Godina*");
		lblGodina.setToolTipText("Godina studija u kojoj se izvodi predmet");
		lblGodina.setPreferredSize(dimLbl);
		String[] godinaPredmeta = {"1", "2", "3", "4", "5"};
		godinaIzvodjenja = new JComboBox<String>(godinaPredmeta);
		godinaIzvodjenja.setName("godinaIzvodjenja");
		godinaIzvodjenja.setToolTipText("Godina studija u kojoj se izvodi predmet");
		godinaIzvodjenja.setPreferredSize(dimKomp);
		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panGodina.add(lblGodina);
		panGodina.add(godinaIzvodjenja);
		
		
		
		lblSemestar = new JLabel("Semestar*");
		lblSemestar.setToolTipText("Semestar u kojem se izvodi predmet");
		lblSemestar.setPreferredSize(dimLbl);
		String[] semestarIzvoStr = {"Zimski", "Letnji"};
		semestarIzvodjenja = new JComboBox<String>(semestarIzvoStr);
		semestarIzvodjenja.setName("semestarIzvodjenja");
		semestarIzvodjenja.setToolTipText("Semestar u kojem se izvodi predmet");
		semestarIzvodjenja.setPreferredSize(dimKomp);
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panSemestar.add(lblSemestar);
		panSemestar.add(semestarIzvodjenja);
		
		
		
		lblESPB = new JLabel("ESPB*");
		lblESPB.setToolTipText("Broj ESPB koji nosi predmet");
		lblESPB.setPreferredSize(dimLbl);
		txtBrojESPB = new JTextField();
		txtBrojESPB.setName("txtBrojESPB");
		txtBrojESPB.setToolTipText("Broj ESPB koji nosi predmet");
		txtBrojESPB.setPreferredSize(dimKomp);
		ValidacijaTextFieldFocusListener vtffl2 = new ValidacijaTextFieldFocusListener(lblESPB, txtBrojESPB,this);
		txtBrojESPB.addFocusListener(vtffl2);
		txtBrojESPB.addKeyListener(vtffl2);
		JPanel panESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panESPB.add(lblESPB);
		panESPB.add(txtBrojESPB);
		
		
		
		// SLEDI DEO ZA UNOS PROFESORA U OKVIRU PREDMETA :D
		lblProfesor = new JLabel("Profesor*");
		lblProfesor.setToolTipText("Najvise jedan Profesor");
		lblProfesor.setPreferredSize(dimLbl);
		
		JPanel panOdabirProf = new JPanel();
		BoxLayout boxMaleckiZaProf = new BoxLayout(panOdabirProf, BoxLayout.X_AXIS);
		panOdabirProf.setLayout(boxMaleckiZaProf);
		//panOdabirProf.setBackground(Color.white);
		txtGlavniProf = new JTextField();
		txtGlavniProf.setName("txtGlavniProf");
		txtGlavniProf.setToolTipText("Najvise jedan Profesor");
		txtGlavniProf.setPreferredSize(new Dimension(160,20));
		txtGlavniProf.setEditable(false); 							// nema sta tu da unosimo sami biracemo profesore
		
		btnDodajProf = new DiaButton();
		btnDodajProf.setIcon(new ImageIcon("images"+File.separator+"iconPlus16x16.png"));
		btnDodajProf.setPreferredSize(new Dimension(20,20));
		btnUkloniProf = new DiaButton();
		btnUkloniProf.setIcon(new ImageIcon("images"+File.separator+"iconClose16x16.png"));
		btnUkloniProf.setPreferredSize(new Dimension(20,20));
		btnUkloniProf.setEnabled(false);
		
		
		btnDodajProf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// sa ovom metodom pocinjemo jer u pocetku nema profesora pa mozemo da ga dodamo
				DodavanjePrfNaPredmetDialog dodajProfNaPredmet = new DodavanjePrfNaPredmetDialog(parent);
				profesor = dodajProfNaPredmet.dajMiSelektovanogProfesora();
				if(profesor != null) {
					txtGlavniProf.setText(profesor.getIme()+" "+profesor.getPrezime());
					setOmoguciDodavanjeProfesora(false);
					svaPoljaValidna();
				}
				
				
			}
		});
		
		btnUkloniProf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String poruka = "Da li želite da uklonite predmetnog profesora?";
				Object[] opcije = {"Potvrdi","Odustani"};
				int option = JOptionPane.showOptionDialog(parent, poruka, "Ukloni Profesora", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, opcije, null);
				if(option == JOptionPane.YES_OPTION) {
					profesor = null; 
					setOmoguciDodavanjeProfesora(true);
					txtGlavniProf.setText("");
					svaPoljaValidna();
				}
			}
		});
		
		panOdabirProf.add(txtGlavniProf);
		panOdabirProf.add(Box.createHorizontalStrut(10));
		panOdabirProf.add(btnDodajProf);
		panOdabirProf.add(Box.createHorizontalStrut(10));
		panOdabirProf.add(btnUkloniProf);
		
		JPanel panProf = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panProf.add(lblProfesor);
		panProf.add(panOdabirProf);
		
		lValid.add(vtffl0);
		lValid.add(vtffl1);
		lValid.add(vtffl2);
		
		
		// INICIJALIZACIJA
		inicijalizujPolja();
		
		
		// Dugmad za potrvrdi
		btnPotvrdi = new DiaButton("Potvrdi");
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(svaPoljaValidna()) {
					
					Predmet noviPredmet = new Predmet();
					noviPredmet.setSifraPredmeta(txtSifra.getText());
					noviPredmet.setNazivPredmeta(txtNaziv.getText());
					noviPredmet.setGodinaStudijaUKojojSePredmetIzvodi(godinaIzvodjenja.getSelectedIndex()+1);
					if(semestarIzvodjenja.getSelectedIndex() == 0) {
						noviPredmet.setSemestar(Semestar.ZIMSKI);
					}else {
						noviPredmet.setSemestar(Semestar.LETNJI);
					}
					noviPredmet.setBrojESPBbodova( Integer.parseInt(txtBrojESPB.getText()) );
					if(profesor != null) {
						noviPredmet.setPredmetniProfesor(profesor);
					}
					
					PredmetController.getInstance().izmeniPredmet(predmet, noviPredmet);
					
					
					// sada predmet je izmenjen i sad mozemo ga dodati profesoru
					ProfesorController.getInstance().dodajPredmetProfesoru(profesor, predmet);
					dispose();
					
				}else {
					
				}
				
			}
		});
		btnOdustani = new DiaButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
				
		JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		diaButtonPanel.add(btnPotvrdi);
		diaButtonPanel.add(Box.createHorizontalStrut(20));
		diaButtonPanel.add(btnOdustani);
		
		
		
		
		
		// ubacivanje sve zivog
		JPanel panDodavanjePredmeta = new JPanel();
		BoxLayout boxCentar = new BoxLayout(panDodavanjePredmeta, BoxLayout.Y_AXIS);
		panDodavanjePredmeta.setLayout(boxCentar);
		
		panDodavanjePredmeta.add(Box.createVerticalGlue());
		panDodavanjePredmeta.add(panSifra);
		panDodavanjePredmeta.add(panNaziv);
		panDodavanjePredmeta.add(panGodina);
		panDodavanjePredmeta.add(panSemestar);
		panDodavanjePredmeta.add(panESPB);
		panDodavanjePredmeta.add(panProf);
		panDodavanjePredmeta.add(Box.createVerticalStrut(50));
		panDodavanjePredmeta.add(diaButtonPanel);
		
		add(panDodavanjePredmeta, BorderLayout.CENTER);
		
		
		
	}



	
	
}


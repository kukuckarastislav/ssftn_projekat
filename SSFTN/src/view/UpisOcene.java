package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorController;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.Titula;
import model.Zvanje;
import util.ValidacijaTextFieldFocusListener;
import util.ValidacijaUnosa;
import model.Ocena;

public class UpisOcene extends JDialog{


	private static final long serialVersionUID = 2791095176616384710L;
	private Ocena ocena;

	public UpisOcene(Frame parent,Student student,Predmet predmet) {
		super(parent,"Upis ocene",true);
		
		setSize(400,500);
		setResizable(false);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		
		Dimension dimKomp = new Dimension(150,20);
		// SIFRA
		
		JLabel lblSifra = new JLabel("Sifra*");
		lblSifra.setPreferredSize(dimKomp);
		JTextField txtSifra = new JTextField();
		txtSifra.setPreferredSize(dimKomp);
		txtSifra.setName("txtSifra");
		txtSifra.setText(predmet.getSifraPredmeta());
		txtSifra.setEditable(false);
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		//NAZIV
		JLabel lblNaziv = new JLabel("Naziv*");
		lblNaziv.setPreferredSize(dimKomp);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dimKomp);
		txtNaziv.setName("txtNaziv");
		txtNaziv.setText(predmet.getNazivPredmeta());
		txtNaziv.setEditable(false);
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		
		//OCENA
		JLabel lblO = new JLabel("Ocena*");
		lblO.setPreferredSize(dimKomp);
		String[] ocene = {"6", "7", "8", "9","10"};
		JComboBox<String> Ocene = new JComboBox<>(ocene);
		Ocene.setName("Ocene");	
		Ocene.setPreferredSize(dimKomp);
		JPanel panOcene = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panOcene.add(lblO);
		panOcene.add(Ocene);
		

		// DATUM 
		JLabel lblDatmR = new JLabel("Datum*");
		lblDatmR.setPreferredSize(dimKomp);
		JTextField txtDatmR = new JTextField();
		lblDatmR.setPreferredSize(dimKomp);
		txtDatmR.setToolTipText("Trazen format: DD.MM.GGGG.");
		txtDatmR.setPreferredSize(dimKomp);
		txtDatmR.setName("txtDatmR");
		ValidacijaTextFieldFocusListener vtffl2 = new ValidacijaTextFieldFocusListener(lblDatmR, txtDatmR);
		txtDatmR.addFocusListener(vtffl2);
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panDatum.add(lblDatmR);
		panDatum.add(txtDatmR);
		
		
		JPanel panButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		DiaButton btnPotvrdi = new DiaButton("Potvrdi");
		DiaButton btnOdustani = new DiaButton("Odustani");
		panButtons.add(btnPotvrdi);
		panButtons.add(btnOdustani);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panSifra);
		boxCentar.add(panNaziv);
		boxCentar.add(panOcene);		
		boxCentar.add(panDatum);
		boxCentar.add(panButtons);
		this.add(boxCentar, BorderLayout.CENTER);
		
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ValidacijaUnosa vu=new ValidacijaUnosa();
				if(vu.validDatum(txtDatmR.getText())) {
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
					dateFormat.setLenient(false);
					Date datum = null;
					try {
						datum = dateFormat.parse(txtDatmR.getText());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					int o=Ocene.getSelectedIndex()+6;		
					ocena=new Ocena(student,predmet,o,datum);
					
					student.getlPolIspita().add(ocena);
					student.getlNePolIspita().remove(predmet);
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Upisite datum u trazenom formatu!", "Ukloni Predmet", 0, null);
				}
			dispose();				
			}

		});
		
	
		
		
	}

	public Ocena getOcena() {
		return ocena;
	}

}


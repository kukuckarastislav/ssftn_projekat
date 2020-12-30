package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import controller.PredmetController;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Profesor;
import model.Student;
import view.DodavanjePredmetaStudentuDialog.AbstractTablePredmetiZaStudenta;
import model.Predmet;

public class PanIzmenaStudentaNePolozeni extends JPanel{
	

	private static final long serialVersionUID = 1L;
	
	private Student student;
	private ArrayList<Predmet> nepolozeniPredmeti;
	
	private TabelaNepolozeni tabelaNepolozenih;
	private Predmet predmet;
	
	private DiaButton btnDodaj;
	private DiaButton btnObrisi;
	private DiaButton btnPolaganje;
	private PanIzmenaStudentaNePolozeni panIzmenaStudenataNePolozenih;
	
	public PanIzmenaStudentaNePolozeni(Frame parent,Student student) {
		this.student=student;
		setLayout(new BorderLayout());
		panIzmenaStudenataNePolozenih = this;
		
		//nepolozeniPredmeti=new ArrayList<>();
		nepolozeniPredmeti=student.getlNePolIspita();  //samo ovo treba da bude lista ocjena i pretposvicemo da radi sve xd
		
		//JPanel ukrasniGornjiPanel = new JPanel();
		JPanel ukrasniDonjiPanel = new JPanel();
		ukrasniDonjiPanel.setPreferredSize(new Dimension(50,50));
		JPanel ukrasniLeviPanel = new JPanel();
		ukrasniLeviPanel.setPreferredSize(new Dimension(30,30));
		JPanel ukrasniDesniPanel = new JPanel();
		ukrasniDesniPanel.setPreferredSize(new Dimension(30,30));
		
		
		tabelaNepolozenih = new TabelaNepolozeni();
		JScrollPane nepolozeniScrollPane = new JScrollPane(tabelaNepolozenih);
		JPanel centralniPanelSaTablicom = new JPanel(new BorderLayout());
		centralniPanelSaTablicom.add(nepolozeniScrollPane, BorderLayout.CENTER);
		centralniPanelSaTablicom.add(ukrasniLeviPanel, BorderLayout.WEST);
		centralniPanelSaTablicom.add(ukrasniDesniPanel, BorderLayout.EAST);
		centralniPanelSaTablicom.add(ukrasniDonjiPanel, BorderLayout.SOUTH);
		
		JPanel panButtons = new JPanel(new FlowLayout(30,15,30));
		panButtons.setPreferredSize(new Dimension(60,60));
		btnDodaj=new DiaButton("Dodaj");	
		btnObrisi=new DiaButton("Obrisi");	
		btnPolaganje=new DiaButton("Polaganje");	
		
		panButtons.add(Box.createHorizontalStrut(0));
		panButtons.add(btnDodaj);
		panButtons.add(btnObrisi);
		panButtons.add(btnPolaganje);
		
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjePredmetaStudentuDialog dpsd = new DodavanjePredmetaStudentuDialog(
												panIzmenaStudenataNePolozenih, parent, student);
			}
		});
		
		btnPolaganje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int iPred = getSelectedPredmet();
				predmet=new Predmet();
				predmet = PredmetController.getInstance().getPredmet(iPred);
				UpisOcene uo=new UpisOcene(parent,student,predmet);
				//dispose();
			}
		});
		
		
		this.add(panButtons,BorderLayout.NORTH);
		this.add(centralniPanelSaTablicom,BorderLayout.CENTER);
		
	
	}
	



// PONOVO TABELA SA PREDMETIMA
	private class TabelaNepolozeni extends JTable{
		private static final long serialVersionUID = -3805554009583860187L;
	
		public TabelaNepolozeni() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			setModel(new SadrzajTabeleNepolozeni());
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
	
	private class SadrzajTabeleNepolozeni extends AbstractTableModel{
	
		private static final long serialVersionUID = 2335644876350909315L;
	
		@Override
		public int getRowCount() {	
			return nepolozeniPredmeti.size();
		}
	
		@Override
		public int getColumnCount() {
			return 5;
		}
	
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return getPredmeti(rowIndex,columnIndex);
		}
		@Override
		public String getColumnName(int column) {
			return BazaPredmeti.getInstance().getNazivKolona(column);
		}
	
	}

	public String getPredmeti(int x,int y) {
		
		Predmet predmet = nepolozeniPredmeti.get(x);
		switch (y) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojESPBbodova());
		case 3:
			return Integer.toString(predmet.getGodinaStudijaUKojojSePredmetIzvodi());
		case 4:
			return predmet.getSemestar().toString();
			
		default:
			return null;
		}
	}
	
	// 
	public int getSelectedPredmet() {
		return tabelaNepolozenih.getSelectedRow();
	}

	public Predmet selektovaniPredmet() {
		return predmet;
	}

	public void azurirajPrikazTabeleNePolozenihPredmetaZaStudenta() {
		SadrzajTabeleNepolozeni model = (SadrzajTabeleNepolozeni) tabelaNepolozenih.getModel();
		model.fireTableDataChanged();
		validate();
	}



}
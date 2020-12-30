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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import controller.ProfesorController;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
import model.Student;

public class DodavanjePredmetaStudentuDialog extends JDialog {

	private static final long serialVersionUID = -716876777577274323L;
	private Student student;
	
	private TabelaMogucihPredmetaZaStudenta tabelaMogPredZaStd;
	private ArrayList<Predmet> alMoguciPredmetiZaStudenta;
	
	public DodavanjePredmetaStudentuDialog(PanIzmenaStudentaNePolozeni panIzmenaStudNePolozeni, Frame parent,Student student) {
		super(parent, "Dodavanje predmeta", true);
		this.student = student;
		
		setSize(350,300);
		setResizable(false);
		setLocationRelativeTo(parent); 	// ToDo : popraviti treba da se pozicionira u odnosu na JDialog a ne JFrame
		setLayout(new BorderLayout());
		
		JPanel gornjiUkrasniPan = new JPanel();
		JPanel panDiaButtons = new JPanel(new FlowLayout(10,10,10));//,FlowLayout.CENTER));
		JPanel leviUkrasniPan = new JPanel();
		JPanel desniUkrasniPan = new JPanel();

		gornjiUkrasniPan.setPreferredSize(new Dimension(30,30));
		panDiaButtons.setPreferredSize(new Dimension(50,50));
		leviUkrasniPan.setPreferredSize(new Dimension(10,10));
		desniUkrasniPan.setPreferredSize(new Dimension(10,10));

		JPanel centralniPanel = new JPanel(new BorderLayout());
		centralniPanel.setBackground(Color.white);
		
		alMoguciPredmetiZaStudenta = BazaPredmeti.getInstance().getMoguciPredmetiZaStudenta(student);
		
		tabelaMogPredZaStd = new TabelaMogucihPredmetaZaStudenta();
		JScrollPane panelPredmetiScrollPane = new JScrollPane(tabelaMogPredZaStd);
		centralniPanel.add(panelPredmetiScrollPane,BorderLayout.CENTER);
		azurirajPrikazTabeleMogucihPredmetaZaStudenta();
		
		
		
		
		
		DiaButton btnDodaj = new DiaButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int pred = getSelectedPredmet();
				
				if(pred == -1) {
					JOptionPane.showMessageDialog(parent, "Selektujte Predmet", "Upozorenje", 0, null);
				}else {
					// dodajemo predmet studentu u nepoloznee predmete
					Predmet predmet = alMoguciPredmetiZaStudenta.get(pred);
					student.dodajNePolozenIspit(predmet);
					panIzmenaStudNePolozeni.azurirajPrikazTabeleNePolozenihPredmetaZaStudenta();
					dispose();
				}
				
			}
		});

		DiaButton btnOdustani = new DiaButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		panDiaButtons.add(Box.createHorizontalStrut(52));
		panDiaButtons.add(btnDodaj);
		panDiaButtons.add(Box.createHorizontalStrut(10));
		panDiaButtons.add(btnOdustani);
		
		
		
		
		
		add(gornjiUkrasniPan, BorderLayout.NORTH);
		add(panDiaButtons, BorderLayout.SOUTH);
		add(leviUkrasniPan, BorderLayout.WEST);
		add(desniUkrasniPan, BorderLayout.EAST);

		add(centralniPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	private class TabelaMogucihPredmetaZaStudenta extends JTable{
		
		private static final long serialVersionUID = -8040177113408533820L;
		public TabelaMogucihPredmetaZaStudenta() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			setModel(new AbstractTablePredmetiZaStudenta());
		}
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component c = super.prepareRenderer(renderer, row, column);
			// selektovani red ce imati drugaciju boju od ostalih
			if (isRowSelected(row)) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}

	}
	
	public class AbstractTablePredmetiZaStudenta extends AbstractTableModel{

		private static final long serialVersionUID = 3488675154619442430L;
		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public int getRowCount() {
			return alMoguciPredmetiZaStudenta.size();
		}

		@Override
		public String getValueAt(int arg0, int arg1) {
			// dobavi mi predmet
			Predmet p = alMoguciPredmetiZaStudenta.get(arg0); 
			String predmet = p.getSifraPredmeta() + " - " + p.getNazivPredmeta();
			return predmet; // vracamo Sifru i naziv predmeta
		}
		@Override
		public String getColumnName(int column) {
			return "Predmeti";
		}

	}
	
	public void azurirajPrikazTabeleMogucihPredmetaZaStudenta() {
		AbstractTablePredmetiZaStudenta model = (AbstractTablePredmetiZaStudenta) tabelaMogPredZaStd.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
	public int getSelectedPredmet() {
		return tabelaMogPredZaStd.getSelectedRow();
	}
	
	
	

}

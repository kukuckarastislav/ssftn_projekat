package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import controller.ProfesorController;
import model.BazaProfesori;
import model.Profesor;

public class DodavanjePrfNaPredmetDialog extends JDialog {

	private static final long serialVersionUID = 8561976962718904066L;
	
	private TabelaProfesoraOdabir tabelaProfesoraOdabir;
	
	private Profesor profesor = null;

	public DodavanjePrfNaPredmetDialog(Frame parent) {
		super(parent, "Odaberi Profesora", true);
		
		setSize(350,300);
		setResizable(false);
		setLocationRelativeTo(null); 	// ToDo : popraviti treba da se pozicionira u odnosu na JDialog a ne JFrame
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
		
		tabelaProfesoraOdabir = new TabelaProfesoraOdabir();
		JScrollPane panelProfesoriScrollPane = new JScrollPane(tabelaProfesoraOdabir);
		centralniPanel.add(panelProfesoriScrollPane,BorderLayout.CENTER);
		azurirajPrikazTabeleProfesora("POCETNA", 0);
		
		
		
		DiaButton btnPotvrdi = new DiaButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int iProf = getSelectedProfesor();
				
				profesor = ProfesorController.getInstance().getProfesor(iProf);
				
			
				dispose();
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
		panDiaButtons.add(btnPotvrdi);
		panDiaButtons.add(Box.createHorizontalStrut(10));
		panDiaButtons.add(btnOdustani);
		
		
		
		add(gornjiUkrasniPan, BorderLayout.NORTH);
		add(panDiaButtons, BorderLayout.SOUTH);
		add(leviUkrasniPan, BorderLayout.WEST);
		add(desniUkrasniPan, BorderLayout.EAST);
		
		add(centralniPanel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	
	// OVDE DODATI SVE ZIVE KLASE POTREBNE ZA TABLE unutrasnje klase
	private class TabelaProfesoraOdabir extends JTable{
		private static final long serialVersionUID = -3805554009583860187L;
		
		public TabelaProfesoraOdabir() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// Sama JTable komponenta je implementirana postujuci MVC arhitekturu.
			setModel(new AbstractTableProfesoriOdabir());
		}
		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			// Svaka celija ima renderer, koji se poziva prilikom njenog iscrtavanja.
			// Podrazumevano se pozivaju prilikom inicijalnog iscrtavanja tabele.
			// Ukoliko korisnik selektuje neku celiju, dolazi do ponovnog
			// iscrtavanje svih celija u redu koji je selektovan, kao i u redu
			// koji je prethodno bio selektovan.
			// TODO: Probati na primeru!
			// System.out.println(row + " " + column);
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
	
	private class AbstractTableProfesoriOdabir extends AbstractTableModel{

		private static final long serialVersionUID = 2335644876350909315L;

		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public int getRowCount() {
			return BazaProfesori.getInstance().getProfesori().size();
		}

		@Override
		public String getValueAt(int arg0, int arg1) {
			String prof = BazaProfesori.getInstance().getVrednostU(arg0,0)+" "+
					      BazaProfesori.getInstance().getVrednostU(arg0,1);
			return prof; // vracamo ime i prezime
		}
		@Override
		public String getColumnName(int column) {
			return "Ime i Prezime";
		}

	}
	
	public void azurirajPrikazTabeleProfesora(String akcija, int vrednost) {
		AbstractTableProfesoriOdabir model = (AbstractTableProfesoriOdabir) tabelaProfesoraOdabir.getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
	
	public int getSelectedProfesor() {
		return tabelaProfesoraOdabir.getSelectedRow();
	}

	public Profesor dajMiSelektovanogProfesora() {
		return profesor;
	}
	
	
	
}

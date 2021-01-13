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
import model.BazaPredmeti;
import model.Predmet;
import model.Profesor;

public class DodavanjePredmetaProfesoru  extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private TabelaPredmetaOdabir tabelaPredmetaOdabir;
	private Predmet predmet = null;
	
	private ArrayList<Predmet> predmetiZaDodavanje;
	

	public DodavanjePredmetaProfesoru(Frame parent,Profesor p) {
		super(parent, "Odaberi Predmet", true);
		
		predmetiZaDodavanje=BazaPredmeti.getInstance().formPredmetiZaDodavanje(p);
		
		setSize(350,300);
		setResizable(false);
		setLocationRelativeTo(null); 
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

		tabelaPredmetaOdabir = new TabelaPredmetaOdabir();
		JScrollPane panelPredmetaScrollPane = new JScrollPane(tabelaPredmetaOdabir);
		centralniPanel.add(panelPredmetaScrollPane,BorderLayout.CENTER);
		azurirajPrikazTabelePredmeta("POCETNA", 0);



		DiaButton btnPotvrdi = new DiaButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int iPred = getSelectedPredmet();
				if(iPred == -1) {
					
					JOptionPane.showMessageDialog(null, "Selektujte Predmet koji želite da dodate profesoru", "Ukloni Predmet", 0, null);
				}else {
				
				for (Predmet ppp : predmetiZaDodavanje) {
					System.out.println(ppp.getNazivPredmeta());
				}
				predmet=predmetiZaDodavanje.get(iPred);
				//p.getPredmetiNaKojimaJeProfesor().add(predmet);
				
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
	
	private class TabelaPredmetaOdabir extends JTable{
		private static final long serialVersionUID = -3805554009583860187L;

		public TabelaPredmetaOdabir() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			setModel(new SadrzajTabeleOdabirPredmeta());
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

	private class SadrzajTabeleOdabirPredmeta extends AbstractTableModel{

		private static final long serialVersionUID = 2335644876350909315L;

		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public int getRowCount() {
			return predmetiZaDodavanje.size();
		}

		@Override
		public String getValueAt(int arg0, int arg1) {
			return getPredmeti(arg0,arg1);
		}
		@Override
		public String getColumnName(int column) {
			return "Naziv predmeta";
		}

	}

	public void azurirajPrikazTabelePredmeta(String akcija, int vrednost) {
		SadrzajTabeleOdabirPredmeta model = (SadrzajTabeleOdabirPredmeta) tabelaPredmetaOdabir.getModel();
		model.fireTableDataChanged();
		validate();
	}

	public int getSelectedPredmet() {
		return tabelaPredmetaOdabir.getSelectedRow();
	}

	public Predmet selektovaniPredmet() {
		return predmet;
	}

	public String getPredmeti(int x,int y) {
		
		Predmet predmet = predmetiZaDodavanje.get(x);
		switch (y) {
		case 0:
			return predmet.getNazivPredmeta();
		
		default:
			return null;
		}
	}	
	
	
	
	
	

}

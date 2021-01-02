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
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import model.BazaProfesori;
import model.Ocena;
import model.Student;
import view.DodavanjePrfNaPredmetDialog.AbstractTableProfesoriOdabir;

public class PanIzmenaStudentaPolozeni extends JPanel {

	private static final long serialVersionUID = 5737835927052378522L;
	
	private DiaButton btnPonistiOcenu;
	private TabelaPolozeni tabelaPolozeni;
	private Student student;
	private JTextField txtProsecnaOcena;
	private JTextField txtUkupnoESPB;

	public PanIzmenaStudentaPolozeni(Frame parent, Student student) {
		this.student = student;
		setLayout(new BorderLayout());
		
		txtProsecnaOcena = new JTextField();
		txtUkupnoESPB = new JTextField();
		
		txtProsecnaOcena.setEditable(false);
		txtProsecnaOcena.setPreferredSize(new Dimension(60,20));
		txtProsecnaOcena.setBorder(null);
		txtUkupnoESPB.setPreferredSize(new Dimension(60,20));
		txtUkupnoESPB.setEditable(false);
		txtUkupnoESPB.setBorder(null);
		
		JPanel panelPonistiOcenu = new JPanel(new FlowLayout(30,15,30));
		JPanel panelCentar = new JPanel(new BorderLayout());
		JPanel leviUkrasniPanel = new JPanel();
		JPanel desniUkrasniPanel = new JPanel();
		JPanel donjiIfnoPanel = new JPanel();
		BoxLayout boxInfo = new BoxLayout(donjiIfnoPanel, BoxLayout.Y_AXIS);
		donjiIfnoPanel.setLayout(boxInfo);
		
		panelCentar.setBackground(Color.white);
		
		panelPonistiOcenu.setPreferredSize(new Dimension(60,60));
		leviUkrasniPanel.setPreferredSize(new Dimension(30,30));
		desniUkrasniPanel.setPreferredSize(new Dimension(30,30));
		donjiIfnoPanel.setPreferredSize(new Dimension(80,80));
	
		
		tabelaPolozeni = new TabelaPolozeni();
		JScrollPane polozeniScrollPane = new JScrollPane(tabelaPolozeni);
		panelCentar.add(polozeniScrollPane, BorderLayout.CENTER);
		
		TableColumnModel tcm = tabelaPolozeni.getColumnModel();
		tcm.getColumn(2).setMaxWidth(50); 			
		tcm.getColumn(3).setMaxWidth(50);
		
		
		
		
		btnPonistiOcenu = new DiaButton("Poništi ocenu");
		panelPonistiOcenu.add(Box.createHorizontalStrut(0));
		panelPonistiOcenu.add(btnPonistiOcenu);
		
		btnPonistiOcenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selPredmet = tabelaPolozeni.getSelectedRow();
				
				if(selPredmet == -1) {
					JOptionPane.showMessageDialog(null, "Selektujte Predmet koji želite da poništite", "Upozorenje", 0, null);
				}else {
					String poruka = "Da li ste sigurni da želite da poništite ocenu?";
					int option = JOptionPane.showConfirmDialog((JFrame)parent, poruka, "Ponistavanje Ocene", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						Ocena ocena = student.getOcena(selPredmet);
						student.ponistiPolozenIspit(ocena);
						if(ocena.getPredmet() != null) {
							student.dodajNePolozenIspit(ocena.getPredmet());
						}
						azurirajPrikazTabelePolozeni();
						
					}
				}
			}
		});
		
		
		
		
		JLabel lblProsek = new JLabel("Prosečna ocena:");
		JLabel lblESPB = new JLabel("Ukupno ESPB:");
		lblProsek.setPreferredSize(new Dimension(120,20));
		lblESPB.setPreferredSize(new Dimension(120,20));
		
		JPanel panProsek = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panESPB = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		panProsek.add(lblProsek);
		panProsek.add(txtProsecnaOcena);
		panProsek.add(Box.createHorizontalStrut(20));
		panESPB.add(lblESPB);
		panESPB.add(txtUkupnoESPB);
		panESPB.add(Box.createHorizontalStrut(20));
		
		donjiIfnoPanel.add(panProsek);
		donjiIfnoPanel.add(panESPB);
		
		azurirajPrikazTabelePolozeni();
		
		
		add(panelPonistiOcenu, BorderLayout.NORTH);
		add(leviUkrasniPanel, BorderLayout.WEST);
		add(desniUkrasniPanel, BorderLayout.EAST);
		add(donjiIfnoPanel, BorderLayout.SOUTH);
		add(panelCentar, BorderLayout.CENTER);
	
	}
	
	
	// Tablica
	private class TabelaPolozeni extends JTable{
		private static final long serialVersionUID = -3805554009583860187L;

		public TabelaPolozeni() {
			setRowSelectionAllowed(true);
			setColumnSelectionAllowed(true);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// Sama JTable komponenta je implementirana postujuci MVC arhitekturu.
			setModel(new AbstractTablePolozeni());
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
	public class AbstractTablePolozeni extends AbstractTableModel{

		private static final long serialVersionUID = 2335644876350909315L;

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public int getRowCount() {
			return student.getlPolIspita().size();
		}

		@Override
		public String getValueAt(int arg0, int arg1) {
			Ocena ocena = student.getlPolIspita().get(arg0);
			switch (arg1) {
			case 0:
				if(ocena.getPredmet() == null) return "NE POSTOJI";
				return ocena.getPredmet().getSifraPredmeta();
			case 1:
				if(ocena.getPredmet() == null) return "NE POSTOJI";
				return ocena.getPredmet().getNazivPredmeta();
			case 2:
				if(ocena.getPredmet() == null) return "NE POSTOJI";
				return String.valueOf( ocena.getPredmet().getBrojESPBbodova() );
			case 3:
				return String.valueOf( ocena.getOcena() );
			case 4:
				return ocena.getDatumPolaganjaIspitaString();
			default:
				return null;
			}
			
		}
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "Šifra predmeta";
			case 1:
				return "Naziv predmeta";
			case 2:
				return "ESPB";
			case 3:
				return "Ocena";
			case 4:
				return "Datum";
			default:
				return null;
			}
		}

	}
	public void azurirajPrikazTabelePolozeni() {
		// takodje azurirajmo i one txt sa espb i ocenom
		txtProsecnaOcena.setText( String.valueOf(student.racunajProsecnuOcenu()) );
		txtUkupnoESPB.setText( String.valueOf(student.getUkupnoESPB()) );
		
		AbstractTablePolozeni model = (AbstractTablePolozeni) tabelaPolozeni.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
}

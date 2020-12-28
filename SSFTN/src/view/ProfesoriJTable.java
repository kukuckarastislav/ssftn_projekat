package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class ProfesoriJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3870532450326465610L;

	public ProfesoriJTable() {
		setRowSelectionAllowed(true);
		setColumnSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Sama JTable komponenta je implementirana postujuci MVC arhitekturu.
		setModel(new AbstractTableModelProfesori());
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
	

	//REF:https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know
	public void sorted() {
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.getModel());
		this.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		 
		//kako zelimo da bude sortiramo kada otvorimo aplikaciju, sada je po prezimenu
		int columnIndexToSort = 1;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		 
		//pa posle prezimena, po imenu
		int columnIndexForName = 0;
		sortKeys.add(new RowSorter.SortKey(columnIndexForName, SortOrder.ASCENDING));
		
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		//Ako zelimo da onemogucimo sortiranje za nenku kolonu
		//sorter.setSortable(0, false);
		
		
		
	}
	
}

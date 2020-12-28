package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeti;
import model.Predmet;


public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	private List<Predmet> predmetiList=BazaPredmeti.getInstance().getPredmeti();
	
	public AbstractTableModelPredmeti(){}
	
	// broj redova
		@Override
		public int getRowCount() {
			return BazaPredmeti.getInstance().getPredmeti().size();
		}
		
		// broj kolona
		@Override
		public int getColumnCount() {
			return BazaPredmeti.getInstance().getBrKolona();
		}

		// nazivi kolona u zaglavlju
		@Override
		public String getColumnName(int column) {
			return BazaPredmeti.getInstance().getNazivKolona(column);
		}
		
		// sadrzaj celije
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaPredmeti.getInstance().getVrednostU(rowIndex, columnIndex);
		}
		

		//REF: https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know
		@Override
		public Class<?> getColumnClass(int columnIndex) {
		    if (this.predmetiList.isEmpty()) {
		        return Object.class;
		    }
		    return getValueAt(0, columnIndex).getClass();
		}
		
	
	
}


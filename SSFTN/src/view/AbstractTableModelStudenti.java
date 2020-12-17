package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenti;

public class AbstractTableModelStudenti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	public AbstractTableModelStudenti(){}
	
	// broj redova
		@Override
		public int getRowCount() {
			return BazaStudenti.getInstance().getStudenti().size();
		}
		
		// broj kolona
		@Override
		public int getColumnCount() {
			return BazaStudenti.getInstance().getBrKolona();
		}

		// nazivi kolona u zaglavlju
		@Override
		public String getColumnName(int column) {
			return BazaStudenti.getInstance().getNazivKolona(column);
		}
		
		// sadrzaj celije
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaStudenti.getInstance().getVrednostU(rowIndex, columnIndex);
		}
	
	
}

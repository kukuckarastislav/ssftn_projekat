package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeti;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

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
	
	
}


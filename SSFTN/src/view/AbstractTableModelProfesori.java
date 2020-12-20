package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesori;

public class AbstractTableModelProfesori extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	public AbstractTableModelProfesori(){}
	
	// broj redova
		@Override
		public int getRowCount() {
			return BazaProfesori.getInstance().getProfesori().size();
		}
		
		// broj kolona
		@Override
		public int getColumnCount() {
			return BazaProfesori.getInstance().getBrKolona();
		}

		// nazivi kolona u zaglavlju
		@Override
		public String getColumnName(int column) {
			return BazaProfesori.getInstance().getNazivKolona(column);
		}
		
		// sadrzaj celije
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaProfesori.getInstance().getVrednostU(rowIndex, columnIndex);
		}
	
	
}

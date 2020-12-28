package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesori;
import model.Profesor;

public class AbstractTableModelProfesori extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349770694737017202L;

	
	
	private List<Profesor> profesoriList=BazaProfesori.getInstance().getProfesori();
	
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
		
		//REF: https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know
		@Override
		public Class<?> getColumnClass(int columnIndex) {
		    if (this.profesoriList.isEmpty()) {
		        return Object.class;
		    }
		    return getValueAt(0, columnIndex).getClass();
		}
		
		
	
	
}

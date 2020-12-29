package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Profesor;
import model.Student;

public class PanIzmenaStudentaNePolozeni extends JPanel{
	
	private Student student;
	
	public PanIzmenaStudentaNePolozeni(Student student) {
		this.student=student;
		
		//BazaPredmeti.getInstance().prepareSubjectDisplay(student);
		
		JTable tabelaNepolozenih = new TabelaNepolozeni();
		JScrollPane nepolozeniScrollPane = new JScrollPane(tabelaNepolozenih);
		
		JPanel panButtons = new JPanel(new FlowLayout());
		DiaButton btnDodaj=new DiaButton("Dodaj");	
		DiaButton btnObrisi=new DiaButton("Obrisi");	
		DiaButton btnPolaganje=new DiaButton("Polaganje");	
		
		panButtons.add(btnDodaj);
		panButtons.add(btnObrisi);
		panButtons.add(btnPolaganje);
		
		
		this.add(panButtons,BorderLayout.NORTH);
		this.add(nepolozeniScrollPane,BorderLayout.CENTER);
		
	
	}
	
	
	
	
	
	
	
	



// PRAVIMO PONOVO TABELU SA PREDMETIMA
private class TabelaNepolozeni extends JTable{
	private static final long serialVersionUID = -3805554009583860187L;

	public TabelaNepolozeni() {
		setRowSelectionAllowed(true);
		setColumnSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setModel(new SadrzajTabeleNepolozeni());
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

private class SadrzajTabeleNepolozeni extends AbstractTableModel{

	private static final long serialVersionUID = 2335644876350909315L;

	@Override
	public int getRowCount() {	
		return 3;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}


}


}
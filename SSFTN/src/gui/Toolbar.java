package gui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = 1209699209668701828L;

	public Toolbar() {
		


		super(SwingConstants.HORIZONTAL);
		
		JButton btnNew = new JButton();;
		btnNew.setIcon(new ImageIcon("images/unnamed.png"));
		btnNew.setToolTipText("Create new entity");
		add(btnNew);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		btnEdit.setToolTipText("Edit entity");
		add(btnEdit);

		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		btnDelete.setToolTipText("Delete entity");
		add(btnDelete);
		
		addSeparator();		
		
		JButton btnSearch = new JButton();
		btnSearch.setIcon(new ImageIcon("images/search.png"));
		btnSearch.setToolTipText("Search for entity");
		add(btnSearch);
		
		
		add(Box.createHorizontalGlue());
		
		JTextField t = new JTextField(5);
		
		add(t);
        add(btnSearch);



	}

}
package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	private static final long serialVersionUID = 1209699209668701828L;

	public Toolbar() {
		


		super(SwingConstants.HORIZONTAL);
		
		JButton btnNew = new JButton();;
		btnNew.setIcon(new ImageIcon("images/unnamed.jpg"));
		add(btnNew);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setIcon(new ImageIcon("images/edit.jpg"));
		add(btnEdit);

		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setIcon(new ImageIcon("images/delete.jpg"));
		add(btnDelete);
		
		addSeparator();		
		
		JButton btnSearch = new JButton();
		btnSearch.setIcon(new ImageIcon("images/search.jpg"));
		add(btnSearch);
		
		
		add(Box.createHorizontalGlue());
		
	//ovdje ide text box
        add(btnSearch);



	}

}

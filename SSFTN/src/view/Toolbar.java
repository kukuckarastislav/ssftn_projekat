package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

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
		setFloatable(false);
		
		CustomButton btnNew = new CustomButton();
		btnNew.setIcon(new ImageIcon("images/iconPlus24x24.png"));
		btnNew.setToolTipText("Create new entity");
		add(btnNew);

		addSeparator();

		CustomButton btnEdit = new CustomButton();
		btnEdit.setIcon(new ImageIcon("images/iconEdit24x24.png"));
		btnEdit.setToolTipText("Edit entity");
		add(btnEdit);

		addSeparator();
		
		CustomButton btnDelete = new CustomButton();
		btnDelete.setIcon(new ImageIcon("images/iconDelete24x24.png"));
		btnDelete.setToolTipText("Delete entity");
		add(btnDelete);
		
		addSeparator();		
		
		
		CustomButton btnSearch = new CustomButton();
		btnSearch.setIcon(new ImageIcon("images/iconSearch24x24.png"));
		btnSearch.setToolTipText("Search for entity");
		add(btnSearch);
				
		add(Box.createHorizontalGlue());
		
		
		JTextField tf = new JTextField(15);
		tf.setPreferredSize(new Dimension(200,24));
        tf.setMaximumSize(tf.getPreferredSize());
        add(tf);
		
		add(btnSearch);



	}

}


package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class HelpDialog extends JDialog{

	private static final long serialVersionUID = 7532094756704393899L;

	public HelpDialog(Frame parent, String naslov) {
		super(parent,naslov,true);
		
		setSize(650,650);
		setResizable(false);
		setLocationRelativeTo(parent);
		
		Dimension dim1 = new Dimension(10,10);
		
		JPanel leviPanel = new JPanel();
		leviPanel.setPreferredSize(dim1);
		JPanel desniPanel = new JPanel();
		desniPanel.setPreferredSize(dim1);
		JPanel gornjiPanel = new JPanel();
		gornjiPanel.setPreferredSize(dim1);
		JPanel donjiPanel = new JPanel();
		donjiPanel.setPreferredSize(dim1);
	
		JPanel velikiCentralniPanel = new JPanel();
		velikiCentralniPanel.setLayout(new BorderLayout());
		
		velikiCentralniPanel.add(leviPanel,BorderLayout.WEST);
		velikiCentralniPanel.add(desniPanel,BorderLayout.EAST);
		velikiCentralniPanel.add(gornjiPanel,BorderLayout.NORTH);
		velikiCentralniPanel.add(donjiPanel,BorderLayout.SOUTH);
		
		JPanel manjiCentralniPanel = new JPanel();
		manjiCentralniPanel.setLayout(new BorderLayout());
		manjiCentralniPanel.setBackground(Color.white);
		velikiCentralniPanel.add(manjiCentralniPanel,BorderLayout.CENTER);
		
		// HELP DEO
		File f = new File("podaci"+File.separator+"HelpText.txt");
		BufferedReader in = null;
		String strHelp = "";
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
			String line = "";
			try {
				while( (line=in.readLine()) != null ) {
					strHelp += line+"\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		JTextArea taHelp = new JTextArea(strHelp);
		taHelp.setEditable(false);
		taHelp.setLineWrap(true);
		JScrollPane scrollHelp = new JScrollPane(taHelp, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		manjiCentralniPanel.add(scrollHelp, BorderLayout.CENTER);
		

		
		// zatvaranje dialoga
		
		JPanel panelZatvori = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelZatvori.setBackground(new Color(255,255,255));
		DiaButton bZatvori = new DiaButton("zatvori");
		bZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panelZatvori.add(bZatvori);
		add(panelZatvori, BorderLayout.SOUTH);
		add(velikiCentralniPanel,BorderLayout.CENTER);
		
	}
	
	
}

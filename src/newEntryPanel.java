import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class newEntryPanel extends JFrame {
	
	public static Entry[] entryList;
	public JTextField nameField, numberField, notesField, eMailField;
	newEntryPanel() {
		JButton finishButton, cancelButton;
		JLabel nameDirections, numberDirections, notesDirections, emailDirections;
		JPanel entryPanel, buttonPanel;
		int numEntries;
		
		
		finishButton = new JButton("Finish");
		finishButton.addActionListener(new finish());
		finishButton.setFont(Start.f);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new cancelListener());
		cancelButton.setFont(Start.f);
	
		nameField = new JTextField();
		numberField = new JTextField();
		notesField = new JTextField();
		eMailField = new JTextField();
		
		nameField.setFont(Start.f);
		numberField.setFont(Start.f);
		notesField.setFont(Start.f);
		eMailField.setFont(Start.f);
		
		nameDirections = new JLabel("Enter your new contact's name.");
		numberDirections = new JLabel("Enter your new contaçt's number.");
		notesDirections = new JLabel("Enter your new contact's notes.");
		emailDirections = new JLabel("Enter your new contact's E-Mail address.");
		
		nameDirections.setFont(Start.f);
		numberDirections.setFont(Start.f);
		notesDirections.setFont(Start.f);
		emailDirections.setFont(Start.f);
		
		buttonPanel = new JPanel();
		buttonPanel.add(cancelButton, BorderLayout.WEST);
		buttonPanel.add(finishButton, BorderLayout.EAST);
		
		entryPanel = new JPanel();
		entryPanel.setLayout(new GridLayout(0,1));
		entryPanel.add(nameDirections);
		entryPanel.add(nameField);
		entryPanel.add(numberDirections);
		entryPanel.add(numberField);
		entryPanel.add(notesDirections);
		entryPanel.add(notesField);
		entryPanel.add(emailDirections);
		entryPanel.add(eMailField);
		entryPanel.add(buttonPanel);
		add(entryPanel);
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
	}
	
	public class finish implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			operations.newEntry();
			mainScreen.panel.dispose();
		}
	}
	
	public class cancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainScreen.panel.dispose();
		}
	}
	
	

}

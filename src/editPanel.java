import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class editPanel extends JFrame {
	JPanel panel, namePanel, numberPanel, notesPanel, eMailPanel, buttonPanel;
	JTextField nameField, numberField, notesField, eMailField;
	JLabel nameLabel, numberLabel, notesLabel, eMailLabel;
	FlowLayout layout;
	JButton ok, cancel;
	
	public editPanel(int index) {
		if(Start.isFound) {
			nameField = new JTextField(operations.possibleEntriesArray[index].name);
			numberField = new JTextField(operations.possibleEntriesArray[index].number);
			notesField = new JTextField(operations.possibleEntriesArray[index].notes);
			eMailField = new JTextField(operations.possibleEntriesArray[index].eMail);
		}
		else {
			nameField = new JTextField(operations.entryList[index].name);
			numberField = new JTextField(operations.entryList[index].number);
			notesField = new JTextField(operations.entryList[index].notes);
			eMailField = new JTextField(operations.entryList[index].eMail);
		}
		
		nameField.setEditable(true);
		numberField.setEditable(true);
		notesField.setEditable(true);
		eMailField.setEditable(true);
		
		nameField.setFont(Start.f);
		numberField.setFont(Start.f);
		notesField.setFont(Start.f);
		eMailField.setFont(Start.f);
		
		nameField.setColumns(25);
		numberField.setColumns(25);
		notesField.setColumns(25);
		eMailField.setColumns(25);
		
		nameLabel   = new JLabel("Name:    ");
		numberLabel = new JLabel("Number:  ");
		notesLabel  = new JLabel("Notes:   ");
		eMailLabel  = new JLabel("Email:   ");
		
		nameLabel.setFont(Start.f);
		numberLabel.setFont(Start.f);
		notesLabel.setFont(Start.f);
		eMailLabel.setFont(Start.f);
		
		namePanel   = new JPanel();
		numberPanel = new JPanel();
		notesPanel  = new JPanel();
		eMailPanel  = new JPanel();
		
		layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		
		namePanel.setLayout(layout);
		numberPanel.setLayout(layout);
		notesPanel.setLayout(layout);
		eMailPanel.setLayout(layout);
		
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		numberPanel.add(numberLabel);
		numberPanel.add(numberField);
		
		notesPanel.add(notesLabel);
		notesPanel.add(notesField);
		
		eMailPanel.add(eMailLabel);
		eMailPanel.add(eMailField);
		
		ok = new JButton("Save Changes");
		ok.addActionListener(new okListener());
		ok.setFont(Start.f);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(new cancelListener());
		cancel.setFont(Start.f);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		panel.add(namePanel);
		panel.add(numberPanel);
		panel.add(notesPanel);
		panel.add(eMailPanel);
		panel.add(buttonPanel);
		
		this.add(panel);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public class okListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index;
			index = mainScreen.options.getSelectedIndex();
			if(Start.isFound) {
				operations.possibleEntriesArray[index].name = nameField.getText();
				operations.possibleEntriesArray[index].number = numberField.getText();
				operations.possibleEntriesArray[index].notes = notesField.getText();
				operations.possibleEntriesArray[index].eMail = eMailField.getText();
			} else {
				operations.entryList[index].name = nameField.getText();
				operations.entryList[index].number = numberField.getText();
				operations.entryList[index].notes = notesField.getText();
				operations.entryList[index].eMail = eMailField.getText();
			}
			operations.sortNames();
			operations.findEntry(findEntryPanel.name);
			entryView.editor.dispose();
			mainScreen.view.dispose();
			Start.main.dispose();
			Start.main = new mainScreen();
			
		}
	}
	
	public class cancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			entryView.editor.dispose();
			mainScreen.view.dispose();
		}
	}
}

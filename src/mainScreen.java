import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class mainScreen extends JFrame {
	public static newEntryPanel panel;
	public static deleteEntryPanel deletion;
	public static findEntryPanel find;
	public static entryView view;
	public static JList options;
	public int index;
	public int name;
	
	mainScreen() {
		JButton newEntry, finish, viewEntry, deleteEntry, findEntry, ok;
		JPanel buttonPanel, mainPanel, listPanel, entryButtonPanel, labelPanel;
		GridLayout grid;
		String[] names, foundNames;
		JScrollPane scrollPane;
		JLabel status;
		
		
		newEntry = new JButton("Create a New Entry");
		newEntry.addActionListener(new newEntryListener());
		newEntry.setFont(Start.f);
		
		finish = new JButton("Finish");
		finish.addActionListener(new finishListener());
		finish.setFont(Start.f);
		finish.setSize(100, 100);
		
		viewEntry = new JButton("View Entry");
		viewEntry.addActionListener(new entryViewListener());
		viewEntry.setFont(Start.f);
		
		deleteEntry = new JButton("Delete entry");
		deleteEntry.addActionListener(new deleteEntryListener());
		deleteEntry.setFont(Start.f);
		
		findEntry = new JButton("Find an Entry");
		findEntry.addActionListener(new findEntryListener());
		findEntry.setFont(Start.f);
		
		ok = new JButton("Back");
		ok.addActionListener(new okListener());
		ok.setFont(Start.f);
		
		status = new JLabel("Number of Entries: " + operations.numEntries + "/200");
		status.setFont(Start.f);
		status.setHorizontalAlignment(SwingConstants.RIGHT);
		
		names = operations.getNames();
		if(Start.isFound) {
			foundNames = new String[operations.possibleEntriesArray.length];
			for(int i = 0; i < operations.possibleEntriesArray.length; i++) {
				foundNames[i] = operations.possibleEntriesArray[i].name;
			}
			
			options = new JList(foundNames);
			options.setVisibleRowCount(9);
		}
		else {
			options = new JList(names);
			options.setVisibleRowCount(11);
		}
		options.setSelectionMode(0);
		options.setFont(Start.f);
		
		
		scrollPane = new JScrollPane(options);
		scrollPane.setViewportView(options);
		
		
		grid = new GridLayout(0, 1);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(grid);
		buttonPanel.add(newEntry);
		buttonPanel.add(findEntry);
		buttonPanel.add(finish);
		buttonPanel.setSize(100, 300);
		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(buttonPanel, BorderLayout.WEST);
		
		if (operations.names.length != 0) {
			listPanel = new JPanel(new BorderLayout());
			entryButtonPanel = new JPanel(new GridLayout(0,1));
			labelPanel = new JPanel(new BorderLayout());
			
			labelPanel.add(status, BorderLayout.NORTH);
			labelPanel.add(scrollPane, BorderLayout.CENTER);
			
			entryButtonPanel.add(viewEntry);
			entryButtonPanel.add(deleteEntry);
			if(Start.isFound) {
				entryButtonPanel.add(ok);
			}
			listPanel.setLayout(new BorderLayout());
			listPanel.add(labelPanel, BorderLayout.NORTH);
			listPanel.add(entryButtonPanel,BorderLayout.CENTER);
			mainPanel.add(listPanel);
			mainPanel.add(buttonPanel,BorderLayout.WEST);
			} else {
			mainPanel.add(buttonPanel);
		}
		
		
		this.add(mainPanel);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	class newEntryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			operations.sortNames();
			panel = new newEntryPanel();
			
		}
	}
	
	class finishListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				operations.storePhoneBook("phonebook.txt");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Start.main.dispose();
		}
	}
	
	
	
	public class entryViewListener implements ActionListener {
		public void actionPerformed(ActionEvent f) {
			int number;
			
			number = mainScreen.options.getSelectedIndex();
			if(number != -1) {
				view = new entryView(number);
			}
		}
	}
	
	public class deleteEntryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index;
			
			name = options.getSelectedIndex();
			if(name != -1) {
				deletion = new deleteEntryPanel(name);
			}
			
			
		}
	}
	
	public class findEntryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			find = new findEntryPanel();
		}
	}
	
	public class okListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Start.isFound = false;
			Start.main.dispose();
			Start.main = new mainScreen();
			
			
		}
	} 
}

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class entryView extends JFrame {
	JPanel panel, p2;
	JLabel name, number, notes, email;
	JButton ok, edit;
	public static editPanel editor;
	
	public entryView(int index) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		if(Start.isFound) {
			name    = new JLabel("Name:      " + operations.possibleEntriesArray[index].name);
			number  = new JLabel("Number:    " + operations.possibleEntriesArray[index].number);
			notes   = new JLabel("Notes:     " + operations.possibleEntriesArray[index].notes);
			email   = new JLabel("Email:     " + operations.possibleEntriesArray[index].eMail);
		}
		else {
			name   = new JLabel("Name:      " + operations.entryList[index].name);
			number = new JLabel("Number:    " + operations.entryList[index].number);
			notes  = new JLabel("Notes:     " + operations.entryList[index].notes);
			email  = new JLabel("Email:     " + operations.entryList[index].eMail);
		}
		name.setFont(Start.f);
		number.setFont(Start.f);
		notes.setFont(Start.f);
		email.setFont(Start.f);
		ok = new JButton("OK");
		ok.addActionListener(new okListener());
		ok.setFont(Start.f);
		edit = new JButton("Edit Contact");
		edit.addActionListener(new editListener());
		edit.setFont((Start.f));
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(edit);
		p2.add(ok);
		panel.add(name);
		panel.add(number);
		panel.add(notes);
		panel.add(email);
		panel.add(p2);
		this.add(panel);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public class okListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainScreen.view.dispose();
		}
	}
	
	public class editListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index;
			
			index = mainScreen.options.getSelectedIndex();
			editor = new editPanel(index);
		}
	}
}
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class findEntryPanel extends JFrame {
	JPanel panel;
	JLabel directions;
	JTextField answer;
	JButton finished;
	public static String name;
	public findEntryPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		
		directions = new JLabel("Please enter a part of a contact's name.");
		directions.setFont(Start.f);
		
		answer = new JTextField();
		answer.setFont(Start.f);
		
		finished = new JButton("Finished");
		finished.addActionListener(new okListener());
		finished.setFont(Start.f);
		
		panel.add(directions);
		panel.add(answer);
		panel.add(finished);
		
		this.add(panel);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public class okListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			name = answer.getText();
			operations.findEntry(name);
			mainScreen.find.dispose();
		}
	} 
}

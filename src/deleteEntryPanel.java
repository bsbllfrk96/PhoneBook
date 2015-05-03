import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class deleteEntryPanel extends JFrame {
	public JPanel panel, panel2;
	public String name; 
	JTextArea directions;
	JButton yes, no;
	Boolean clickedYes;
	
	deleteEntryPanel(int index) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		directions = new JTextArea("Are you sure that you would like to delete this entry?");
		directions.setLineWrap(true);
		directions.setWrapStyleWord(true);
		directions.setFont(Start.f);
		directions.setEditable(false);
		yes = new JButton("Yes");
		yes.addActionListener(new okListener());
		yes.setFont(Start.f);
		no = new JButton("No");
		no.addActionListener(new noListener());
		no.setFont(Start.f);
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel.add(directions);
		panel2.add(yes);
		panel2.add(no);
		panel.add(panel2);
		this.add(panel);
		this.setVisible(true);
		this.setSize(250, 250);
		this.setLocationRelativeTo(null);
	}
	
	public class okListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			operations.deleteEntry(Start.main.name);
			Start.main.dispose();
			Start.main = new mainScreen();
			mainScreen.deletion.dispose();
		
		}
	}
	
	public class noListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainScreen.deletion.dispose();
		}
	}
	
	
}


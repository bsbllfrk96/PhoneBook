import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class finishPanel extends JFrame {
	JPanel panel;
	JLabel message;
	JButton button;
	
	public finishPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		message = new JLabel("Phonebook Stored");
		message.setFont(Start.f);
		button = new JButton("OK");
		button.setFont(Start.f);
		button.addActionListener(new buttonListener());
		panel.add(message);
		panel.add(button);
		this.add(panel);
		this.setSize(150, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}

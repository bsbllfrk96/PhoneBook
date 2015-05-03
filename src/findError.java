import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class findError extends JFrame {
	JPanel panel;
	JButton button;
	JLabel message;
	
	public findError() {
		panel = new JPanel();
		button = new JButton("OK");
		button.addActionListener(new buttonListener());
		button.setFont(Start.f);
		message = new JLabel("No entries found.");
		message.setFont(Start.f);
		panel.add(message, BorderLayout.NORTH);
		panel.add(button, BorderLayout.SOUTH);
		this.add(panel);
		this.setSize(150, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			operations.error.dispose();
		}
	}

}

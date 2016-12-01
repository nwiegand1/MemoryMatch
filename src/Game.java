import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Game implements Runnable {
	public void run() {
		// Invoked on the event dispatching thread.
		// Construct and show GUI.
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game(args));
	}
	
	
	
	public JPanel gridLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 6, 1, 1));

        JButton b1 = new JButton("one");
        JButton b2 = new JButton("two"); 
        JButton b3 = new JButton("three");
        JButton b4 = new JButton("four");
        JButton b5 = new JButton("five");

        panel.add(b1);
        JPanel innerPanel = new JPanel();
        innerPanel.add(b2);
        panel.add(innerPanel);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        
        return panel;
    }
}

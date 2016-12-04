import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game implements Runnable {
	public void run() {
		// Invoked on the event dispatching thread.
		// Construct and show GUI.
		
		// Top-level frame in which game components live
		
			final JFrame frame = new JFrame("TOP LEVEL FRAME");
			frame.setLocation(300, 300);

			// Status panel
			final JPanel status_panel = new JPanel();				
			frame.add(status_panel, BorderLayout.SOUTH);
			final JLabel status = new JLabel("Running...");
			status_panel.add(status);
			
			// Main playing area
			final Board board = new Board(status);
			frame.add(board, BorderLayout.CENTER);

			// Reset button
			final JPanel control_panel = new JPanel();
			frame.add(control_panel, BorderLayout.NORTH);

			// Note here that when we add an action listener to the reset
			// button, we define it as an anonymous inner class that is
			// an instance of ActionListener with its actionPerformed()
			// method overridden. When the button is pressed,
			// actionPerformed() will be called.
			final JButton reset = new JButton("Reset");
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					board.reset();
				}
			});
			control_panel.add(reset);

			// Put the frame on the screen
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			// Start game
			board.reset();
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game(args));
	}
	
	
	// or should this be a for loop going through my 2D array of card objects
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

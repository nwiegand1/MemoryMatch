import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game implements Runnable {
	public void run() 
	{
		// Invoked on the event dispatching thread.
		// Construct and show GUI.
		
		// Top-level frame in which game components live
		
			final JFrame frame = new JFrame("TOP LEVEL FRAME");
			frame.setLocation(300, 300);
			System.out.println("made a frame");

			// Status panel
			final JPanel status_panel = new JPanel();				
			frame.add(status_panel, BorderLayout.SOUTH);
			final JLabel status = new JLabel("Running...");
			status_panel.add(status);
			System.out.println("made status panel");
			
			// Main playing area
			final Board board = new Board(status);
			frame.add(board, BorderLayout.CENTER);
			System.out.println("made board");

			// Reset button
			final JPanel control_panel = new JPanel();
			frame.add(control_panel, BorderLayout.NORTH);
			System.out.println("made button");

			// Note here that when we add an action listener to the reset
			// button, we define it as an anonymous inner class that is
			// an instance of ActionListener with its actionPerformed()
			// method overridden. When the button is pressed,
			// actionPerformed() will be called.
			final JButton reset = new JButton("Reset");
			reset.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
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

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Game());
	}	
}

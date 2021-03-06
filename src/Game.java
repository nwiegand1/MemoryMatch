import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			
			//add undo button
			final JButton undo = new JButton("Undo Last Click");
			undo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					board.undoLastMove();
				}
			});
			control_panel.add(undo);
			
			//add undo last match button
			final JButton undoMatch = new JButton("Undo Last Match");
			undoMatch.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					board.undoLastMatch();
				}
			});
			control_panel.add(undoMatch);
			
			
			//add instructions
			final JButton inst = new JButton("Instructions");
			inst.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					board.showInstructions();
				}
			});
			control_panel.add(inst);
			
			//add scores button
			final JButton scores = new JButton("All Scores");
			scores.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					board.showScores();
				}
			});
			control_panel.add(scores);
			
			
			//add highscores button
			final JButton hiscore = new JButton("Highscore");
			hiscore.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					board.showHighscore();
				}
			});
			control_panel.add(hiscore);
			

			// Put the frame on the screen
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			// Start game
			board.reset();
			
			
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Game());
	}	
}

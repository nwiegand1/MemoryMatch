import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

	
	@SuppressWarnings("serial")
	public class Board extends JPanel {
			
		public enum Mode 
		{
		    FIRSTCARD, SECONDCARD
		}

		// the state of the game logic
		public boolean playing = false; // whether the game is running
		private JLabel status; // Current status text (i.e. Running...)
		
		private Cards cards = new Cards();
		private Mode mode = Mode.FIRSTCARD;
		private Card current;
		private int matched = 0;
		private int timeElapsed = 0;
		private int flips = 0;
		
		//private List moves = new Pair LinkedList();
		private HighscoreFunction highscore = new HighscoreFunction();

		// Game constants
		public static final int BOARD_WIDTH = 300;
		public static final int BOARD_HEIGHT = 300;
		
		// Update interval for timer, in milliseconds
		public static final int INTERVAL = 35;

		public Board(JLabel status) 
		{
			
			// creates border around the court area, JComponent method
			setBorder(BorderFactory.createLineBorder(Color.BLACK));

			// The timer is an object which triggers an action periodically
			// with the given INTERVAL. One registers an ActionListener with
			// this timer, whose actionPerformed() method will be called
			// each time the timer triggers. We define a helper method
			// called tick() that actually does everything that should
			// be done in a single timestep.
			Timer timer = new Timer(INTERVAL, new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					tick();
				}
			});
			timer.start(); // MAKE SURE TO START THE TIMER! 

			// Enable keyboard focus on the court area.
			// When this component has the keyboard focus, key
			// events will be handled by its key listener.
			setFocusable(true);
			
			addMouseListener (new MouseAdapter()
			{
				   public void mousePressed(MouseEvent e) 
				   {
					   int xpos = e.getX();
					   int ypos = e.getY();
					   int cardColumn = xpos/30;
					   int cardRow = ypos/30;
					   if (mode == Mode.FIRSTCARD)
					   { 
						   Card card1 = cards.getCard(cardColumn, cardRow);
						   if (!card1.isMatched())
						   {
							   current = card1;
							   current.flip();
							   flips++;
							   repaint();
							   mode = Mode.SECONDCARD;
						   }   
					   }
					   else //if (mode == Mode.SECONDCARD)
					   {
						   Card card2 = cards.getCard(cardColumn, cardRow);
						   if (!card2.isMatched())
						   {
							   card2.flip();
							   flips++;
							   System.out.println("Paint card 2");
							//   repaint();
							   paintImmediately(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
							   System.out.println("Finished painting card 2");
							   try {
								   System.out.println ("about to wait");
									Thread.sleep(1000);
								   System.out.println ("done waiting");
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								} 
							   if (current.isMatch(card2)) //if the 2 cards are a match
							   {
								   matched++;
								   current.matched();
								   card2.matched();
								   mode = Mode.FIRSTCARD;
								   //need to make cards unable to be flipped again.
							   }
							   else 
							   { 
								   current.flip();
								   card2.flip();
								   repaint();
								   mode = Mode.FIRSTCARD;
							   }
						   }   	   
					   }
				   }
				   }); 

			
			this.status = status;
		}
		
		/**
		 * (Re-)set the game to its initial state.
		 */
		public void reset() {
			
			cards = new Cards();
			playing = true;
			status.setText("Running...");

			// Make sure that this component has the keyboard focus
			requestFocusInWindow();
		}	
		
		public void showInstructions()
		{
			JOptionPane.showMessageDialog(null, "Use the mouse to click squares. Match 2 colored Square to create pairs. Match them all to win!");
		}
		
		public void showScores()
		{
			highscore.displayScores();
		}

		/**
		 * This method is called every time the timer defined in the constructor
		 * triggers.
		 */
		void tick() {
			if (playing) 
			{
				timeElapsed++;
				// check for the game end conditions
				if (matched == 18) 
				{
					playing = false;
					status.setText("You win! It took "+ timeElapsed*35 + " seconds and "+ flips + " flips!");
					String name = JOptionPane.showInputDialog("Name:");
					highscore.addScore(name, flips);
				}

				// update the display
			//	repaint();
			}
		}
		
		//undo button
		public void undo()
		{
			if (mode == Mode.SECONDCARD)
			{
				
			}
		}

		@Override
		public void repaint ()
		{
			System.out.println("repainting");
			super.repaint();
		}
		
		
/*		public void readScores()
		{
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = reader.readLine();
	        while (line != null)   // read score file line by line
	        {
	            try {
	            	char[] arr = line.toCharArray();
	        		String name = "";
	        		String scoreStr = "";
	        		int score;
	        		int i = 0;
	        		while (Character.isLetter(arr[i]))
	        		{
	        			name = name + arr[i];
	        			i++;
	        		}
	        		while(Character.isDigit(arr[i]))
	        		{
	        			scoreStr = scoreStr + arr[i];
	        			i++;
	        		}
	        		score = Integer.parseInt(scoreStr);
	                if (score > highScore)                       // and keep track of the largest
	                { 
	                    highScore = score; 
	                }
	            } catch (NumberFormatException e1) {
	                // ignore invalid scores
	                //System.err.println("ignoring invalid score: " + line);
	            }
	            line = reader.readLine();
	        }
	        reader.close();

	    } catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
		}
		
		
		*/
		
		@Override
		public void paintComponent(Graphics g) 
		{
			System.out.println("paint board");
			super.paintComponent(g);
			cards.draw(g);
		}

		@Override
		public Dimension getPreferredSize() 
		{
			return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		}
	}
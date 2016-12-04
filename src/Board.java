import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
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
			
/*
			addMouseListener (new MouseAdapter()
			{
				   public void mousePressed(MouseEvent e) 
				   {
					   int xpos = e.getX();
					   int ypos = e.getY();
					   int cardColumn = xpos/10;
					   int cardRow = ypos/10;
					   if (mode == Mode.FIRSTCARD)
					   { 
						   Card card1 = cards.getCard(cardColumn, cardRow);
						   current = card1;
						   current.flip();
						   repaint();
					   }
					   if (mode == Mode.SECONDCARD)
					   {
						   Card card2 = cards.getCard(cardColumn, cardRow);
						   card2.flip();	
						   repaint();
						   if (current.isMatch(card2))
						   {
							   matched++;
						   }
						   else 
						   {
							   current.flip();
							   card2.flip();
							   repaint();
						   }	   
					   }
				   }
				   }); 
*/
			
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

		/**
		 * This method is called every time the timer defined in the constructor
		 * triggers.
		 */
		void tick() {
			if (playing) 
			{
				// check for the game end conditions
				if (matched == 16) 
				{
					playing = false;
					status.setText("You win!");
				}

				// update the display
				repaint();
			}
		}

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

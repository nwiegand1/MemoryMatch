import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Test;

public class BoardTester 
{
/*	@Test
	public void testNumberOfFlips()
	{
		Board board = new Board(new JLabel("Running..."));
		board.
		
	}*/
	
	@Test
	public void testCardFlip()
	{
		Card card1 = new Card (1, false, 0, 0);
		card1.flip();
		assertEquals (card1.isFlipped(), true);
	}
	@Test
	public void testCardsAreAMatch()
	{
		Card card1 = new Card (1, false, 2, 5);
		Card card2 = new Card (1, false, 5, 7);
		assertEquals (card1.isMatch(card2), true);
	}
	@Test
	public void testCardsNotMatch()
	{
		Card card1 = new Card (1, false, 2, 5);
		Card card2 = new Card (4, false, 5, 7);
		assertFalse (card1.isMatch(card2));
	}

}

import java.awt.Graphics;

public class Cards {
	
	Card[][] cards;
	boolean[][] filled;
	int height = 6;
	int width = 6;

	
public Cards()
{
	this.cards = new Card[6][6];
	this.filled = new boolean[6][6];
	
	//filled is all false
	for (int i = 0; i < 6; i++)
	{
		for (int j = 0; j < 6; j++)
		{
			filled[i][j] = false;
		}
	}
	boolean filled1 = false;
	int i = 1;
	while (i < 19)
	{
		int x = (int) Math.floor(Math.random() * 6);
		int y = (int) Math.floor(Math.random() * 6);
		if (!filled[x][y])
		{
			if (filled1)
			{
				cards [x][y] = new Card (i, false, x*30, y*30);
				filled[x][y] = true;
				filled1 = false;
				i++;
			}
			else 
			{
				cards [x][y] = new Card (i, false, x*30, y*30);
				filled[x][y] = true;
				filled1 = true;
			}		
			System.out.println (cards[x][y] +" " +i);
		}
	}
	
}
	
	public Card getCard (int x, int y)
	{
		return cards[x][y];
	}
	
	public void draw(Graphics g)
	{
		System.out.println("printing cards");
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				cards[i][j].draw(g);
			}
		}
	}
	

}

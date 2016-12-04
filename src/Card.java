import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Card {
	
	boolean flipped;
	Color color;
	int val;
	public int xpos;
	public int ypos;
	int width = 10;
	int height = 10;
	
	public Card (int val, boolean flipped, int xpos, int ypos)
	{
		this.flipped = flipped;
		this.val = val;
		this.xpos = xpos;
		this.ypos = ypos;
		color = Color.RED;
	/*	if (val == 1)
		{
			color = Color.RED;
		}
		if (val == 2)
		{
			color = Color.ORANGE;
		}
		if (val == 3)
		{
			color = Color.YELLOW;
		}
		if (val == 4)
		{
			color = Color.GREEN;
		}
		if (val == 5)
		{
			color = Color.BLUE;
		}
		if (val == 6)
		{
			color = Color.PINK;
		}
		if (val == 7)
		{
			color = Color.MAGENTA;
		} */
	}
	
	public void flip()
	{
		if (flipped)
		{
			flipped = false;
		}
		else
		{
			flipped = true;
		}
	}
	
	public int getVal()
	{
		return val;
	}
	
	public boolean isMatch (Card b)
	{
		return (this.val == b.getVal());
	}
	
	public void draw(Graphics g) {
		if (!flipped)
		{
			g.setColor(Color.BLACK);
			g.fillRect(xpos, ypos, width, height);
			System.out.println ("painted a face down card");
		}
		else
		{
			g.setColor(color);
			g.fillRect(xpos, ypos, width, height);
			System.out.println ("painted a face up card");
		}
	}

}

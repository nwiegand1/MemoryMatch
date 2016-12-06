import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Card {
	
	private boolean flipped;
	public Color color;
	public int val;
	public int xpos;
	public int ypos;
	public int width = 10;
	public int height = 10;
	public boolean matched;
	
	public Card (int val, boolean flipped, int xpos, int ypos)
	{
		this.flipped = flipped;
		this.val = val;
		this.xpos = xpos;
		this.ypos = ypos;
		this.matched = false;
		if (val == 1)
		{
			color = Color.RED;
		}
		else if (val == 2)
		{
			color = Color.ORANGE;
		}
		else if (val == 3)
		{
			color = Color.YELLOW;
		}
		else if (val == 4)
		{
			color = Color.GREEN;
		}
		else if (val == 5)
		{
			color = Color.BLUE;
		}
		else if (val == 6)
		{
			color = Color.PINK;
		}
		else if (val == 7)
		{
			color = Color.MAGENTA;
		}
		else 
		{
			this.color = Color.RED;
		}
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
			//System.out.println ("painted a face down card");
		}
		else
		{
			g.setColor(color);
			g.fillRect(xpos, ypos, width, height);
			//System.out.println ("painted a face up card");
		}
	}
	
	public String toString ()
	{
		return ("value is " + val);
	}

}

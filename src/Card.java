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
		else if (val == 8)
		{
			color = Color.CYAN;
		}
		else if (val == 9)
		{
			color = Color.DARK_GRAY;
		}
		else if (val == 10)
		{
			color = Color.LIGHT_GRAY;
		}
		else if (val == 11)
		{
			color = Color.WHITE;
		}
		else if (val == 12)
		{
			Color myNewBlue = new Color (100, 40, 200);
			color = myNewBlue;
		}
		else if (val == 13)
		{
			Color myNewGreen = new Color (100, 200, 40);
			color = myNewGreen;
		}
		else if (val == 14)
		{
			Color myNewRed = new Color (200, 40, 100);
			color = myNewRed;
		}
		else if (val == 15)
		{
			Color myNewColor = new Color (10, 40, 90);
			color = myNewColor;
		}
		else if (val == 16)
		{
			Color myNewColor = new Color (10, 240, 90);
			color = myNewColor;
		}
		else if (val == 17)
		{
			Color myNewColor = new Color (100, 140, 90);
			color = myNewColor;
		}
		else if (val == 18)
		{
			Color myNewColor = new Color (30, 30, 30);
			color = myNewColor;
		}
		
	}
	
	public void flip()
	{
		flipped = !flipped;
	}
	
	public int getVal()
	{
		return val;
	}
	
	public boolean isMatch (Card b)
	{
		return (this.val == b.getVal());
	}
	
	public void matched()
	{
		matched = true;
	}
	
	public boolean isMatched()
	{
		return matched;
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

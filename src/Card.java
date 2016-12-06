import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Card {
	
	private boolean flipped;
	public Color color;
	public int val;
	public int xpos;
	public int ypos;
	public int width = 30;
	public int height = 30;
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
			Color darkGrey = new Color (96, 96, 96);
			color = darkGrey;
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
			Color lightBlue = new Color (102, 178, 255);
			color = lightBlue;
		}
		else if (val == 13)
		{
			Color lightgreenblue = new Color (102, 255, 178);
			color = lightgreenblue;
		}
		else if (val == 14)
		{
			Color lavender = new Color (229, 204, 255);
			color = lavender;
		}
		else if (val == 15)
		{
			Color purple = new Color (76, 0, 153);
			color = purple;
		}
		else if (val == 16)
		{
			Color forestGreen = new Color (0, 102, 0);
			color = forestGreen;
		}
		else if (val == 17)
		{
			Color myNewColor = new Color (100, 140, 90);
			color = myNewColor;
		}
		else if (val == 18)
		{
			Color pinkpink = new Color (255, 51, 153);
			color = pinkpink;
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

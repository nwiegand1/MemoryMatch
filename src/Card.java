import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Card extends JButton{
	
	boolean flipped;
	Color color;
	int val;
	public int xpos;
	public int ypos;
	int width = 10;
	int height = 10;
	
	public Card (Color color, boolean flipped, int xpos, int ypos, int val)
	{
		this.xpos = xpos;
		this.ypos = ypos;
		this.flipped = flipped;
		this.color = color;
		this.val = val;
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
	
	
	
	public void draw(Graphics g) {
		if (!flipped)
		{
			g.setColor(Color.BLACK);
			g.fillRect(xpos, ypos, width, height);
		}
		else
		{
			g.setColor(color);
			g.fillRect(xpos, ypos, width, height);
		}
	}

}

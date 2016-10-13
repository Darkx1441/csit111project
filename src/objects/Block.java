package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gamestate.State;

public class Block extends Rectangle
{
	private static final long serialVersionUID = 1L;
	
	public Block(int x, int y, int w, int h)
	{
		setBounds(x, y, w, h);	
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void update() {}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillRect(x - (int) State.xOffset, y - (int) State.yOffset, width, height);
	}
}

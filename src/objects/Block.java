package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gamestate.State;

public class Block extends Rectangle
{
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	
	public Block(int x, int y)
	{
		setBounds(x, y, blocksize, blocksize);	
	}
	
	public void update() {}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillRect(x - (int) State.xOffset, y - (int) State.yOffset, width, height);
	}
}

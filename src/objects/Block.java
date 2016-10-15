package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gamestate.State;

public class Block extends Rectangle
{
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	private int id;
	
	public Block(int x, int y, int id)
	{
		setBounds(x, y, blocksize, blocksize);	
		this.id= id;
	}
	
	public void update() {}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.blue);
		if(id==1){
			g.fillRect(x - (int) State.xOffset, y - (int) State.yOffset, blocksize, blocksize);
		}

	}
	
	public void setID(int id){
		this.id= id;
	}
	
	public int getID(){
		return id;
	}
	
}
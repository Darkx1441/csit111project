package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import animation.LevelAnimation;
import gamestate.State;

public class Block extends Rectangle
{
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	private int id;
	private int px, py;
	
	public Block(int x, int y, int id)
	{
		px=x;
		py=y;
		setBounds(x, y, blocksize, blocksize);	
		this.id= id;
	}
	
	public void update() {}
	
	public void render(Graphics2D g, int currentFrame, LevelAnimation animation)
	{
		if(id==1){
			g.drawImage(animation.getGround(currentFrame), x - (int) State.xOffset, y - (int) State.yOffset, null);
		}
	}
	
	public void renderHitbox(Graphics2D g){
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
	public double getX(){
		return px;
	}
	public double getY(){
		return py;
	}
	
}
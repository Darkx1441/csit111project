package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gamestate.State;

public class Key extends Rectangle {
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	private int id;
	private int xpos,ypos;
	public Key(int px, int py, int id){
		setBounds(px, py, blocksize, blocksize);
		this.id=id;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics2D g){
		xpos=x - (int) State.xOffset;
		ypos=y - (int) State.yOffset;
		if(id==3){
			g.setColor(Color.yellow);
			g.drawString("KEY", xpos, ypos);
			g.fillRect(xpos, ypos, blocksize, blocksize);
		}
	}
	public void setID(int id){
		this.id= id;
	}
	
	public int getID(){
		return id;
	}

}

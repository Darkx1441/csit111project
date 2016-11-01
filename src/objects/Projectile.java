package objects;

import java.awt.Color;
import java.awt.Graphics2D;

import gamestate.State;

public class Projectile {
	private int xpos,ypos;
	private int startx,starty;
	private int width=10, height=5;
	private static int speed=1;
	private int distance=0;
	public Projectile(int x, int y){
		startx=x;
		xpos = x;
		ypos= y;
	}
	
	public void update(){
		distance+=speed;
		xpos=startx-(int)State.xOffset+distance;
//		xpos=startx-(int)State.xOffset+distance;
//		ypos=starty-(int)State.yOffset;
	}
	public void render(Graphics2D g){
		
		g.setColor(Color.CYAN);
		g.fillRect(xpos,ypos,width,height);
	}
	
	public int getX(){
		return xpos;
	}
	public int getY(){
		return ypos;
	}
	public void setX(int x){
		xpos=x;
	}
	public void setY(int y){
		ypos=y;
		
	}
}

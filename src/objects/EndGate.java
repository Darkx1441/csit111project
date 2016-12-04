package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import animation.LevelAnimation;
import gamestate.State;

public class EndGate extends Rectangle {
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	private int id;
	public EndGate(int px, int py, int id){
		setBounds(px, py, blocksize, blocksize);
		this.id=id;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics2D g, int currentFrame, LevelAnimation animation){
		if(id==2){
		g.drawImage(animation.getEndGate(currentFrame), x - (int) State.xOffset, y - (int) State.yOffset, null);
		}
	}
	public void setID(int id){
		this.id= id;
	}
	
	public int getID(){
		return id;
	}

	public void renderHitbox(Graphics2D g) {
		g.setColor(Color.red);
		if(id==2){
			g.fillRect(x - (int) State.xOffset, y - (int) State.yOffset, blocksize, blocksize);
		}
	}

}

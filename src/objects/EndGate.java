package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gamestate.State;

public class EndGate extends Rectangle {
	private static final long serialVersionUID = 1L;
	
	public EndGate(int px, int py, int width, int height){
		setBounds(px, py, width, height);
	}
	
	public void update(){
		
	}
	
	public void render(Graphics2D g){
		g.setColor(Color.yellow);
		g.fillRect(x - (int) State.xOffset, y - (int) State.yOffset, width, height);
	}

}

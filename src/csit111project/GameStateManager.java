package csit111project;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameStateManager {

	public static final int PLAYSTATE = 0;
	
	private int state;
	private State[] states;
	
	public GameStateManager(int state){
		states= new State[1];
		states[0]=new MenuState(this);
	}
	
	public void update(){
		states[state].update();
	}
	public void render(Graphics2D g){
		states[state].render(g);
	}
	public void keyPressed(KeyEvent e, int k){
		states[state].keyPressed(e, k);
	}
	public void keyResealed(KeyEvent e, int k){
		states[state].keyResealed(e, k);
	}
	public void mousePressed(MouseEvent e){
		states[state].mousePressed(e);
	}
	public void mouseReleased(MouseEvent e){
		states[state].mouseReleased(e);
	}
	
	
}

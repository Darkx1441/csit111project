package gamestate;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class State 
{
	protected GameStateManager gsm;
	public static double xOffset, yOffset;
	
	public State(GameStateManager gsm)
	{
		this.gsm = gsm;
		
		xOffset = 0;
		yOffset = 0;
		
		init();
	}

	public abstract void init();
	public abstract void update();
	public abstract void render(Graphics2D g);
	public abstract void keyPressed(KeyEvent e, int k);
	public abstract void keyResealed(KeyEvent e, int k);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
}

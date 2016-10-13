package gamestate;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class GameStateManager 
{

	public static final int PLAYSTATE = 0;

	public Stack<State> states;

	public GameStateManager(int state) 
	{
		states = new Stack<State>();
		states.push(new MenuState(this));
	}

	public void update() 
	{
		states.peek().update();
	}

	public void render(Graphics2D g)
	{
		states.peek().render(g);
	}

	public void keyPressed(KeyEvent e, int k) 
	{
		states.peek().keyPressed(e, k);
	}

	public void keyResealed(KeyEvent e, int k) 
	{
		states.peek().keyResealed(e, k);
	}

	public void mousePressed(MouseEvent e) 
	{
		states.peek().mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) 
	{
		states.peek().mouseReleased(e);
	}

}

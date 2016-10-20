package gamestate;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class OptionsMenu extends State
{
	public OptionsMenu(GameStateManager gsm) 
	{
		super(gsm);
	}

	@Override
	public void init()
	{
		
	}

	@Override
	public void update()
	{
		
	}

	@Override
	public void render(Graphics2D g)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e, int k)
	{
		if (k == KeyEvent.VK_ESCAPE) 
		{
			gsm.states.push(new MenuState(gsm));
			gsm.states.remove(2);
			gsm.states.remove(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e, int k)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
}

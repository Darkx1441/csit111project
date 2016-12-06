package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import csit111project.GamePanel;

public class OptionsMenu extends State
{
	private String[] options = { "Window Scale:","1","2", "Back" }; // LIST OF MENUS
	private int currentSelect=0;
	public OptionsMenu(GameStateManager gsm) 
	{
		super(gsm);
	}

	@Override
	public void init(){}

	@Override
	public void update(){}

	@Override
	public void render(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		g.drawString("OPTIONS MENU STATE", 0, 10);

		/*
		 * DRAW MENUS
		 */
		for (int i = 0; i < options.length; i++)
		{
			g.setFont(new Font("Arial", Font.BOLD, 50));
			if (i == currentSelect)
			{
				g.setColor(Color.GREEN);
				g.drawString(">", GamePanel.getScreenWidth() / 2 - 50 - 30, GamePanel.getScreenHeight() / 2 + i * 50);
			} 
			else 
			{
				g.setColor(Color.WHITE);
			}
			
			g.drawString(options[i], GamePanel.getScreenWidth() / 2 - 50, GamePanel.getScreenHeight() / 2 + i * 50);
			g.setFont(new Font("Arial", Font.BOLD, 12));
		}

		
	}

	@Override
	public void keyPressed(KeyEvent e, int k)
	{
		/*
		 * LISTING THROUGH MENUS
		 */
		if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) 
		{
			if (currentSelect < options.length - 1)
			{
				currentSelect += 1;
			}
			else 
			{
				currentSelect = 0 ;
			}
		} 
		else if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP)
		{
			if (currentSelect > 0)
			{
				currentSelect -= 1;
			} 
			else 
			{
				currentSelect = options.length - 1;
			}
		}

		/*
		 * SELECTING MENU
		 */
		if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)
		{
			if (currentSelect == 0)
			{
				// WindowScale
				

			}else if (currentSelect == 1)
			{
				System.out.println("SCALE set to 1");
			} else if( currentSelect ==2){
				System.out.println("SCALE set to 2");
			}
			else if (currentSelect == options.length-1)
			{
				// back to Main Menu
				gsm.states.push(new MenuState(gsm));
				System.out.println("OptionsState started, #ofstates: " + gsm.states.size());
			} 
		}

		if (k == KeyEvent.VK_ESCAPE) 
		{
			gsm.states.push(new MenuState(gsm));
			gsm.states.remove(2);
			gsm.states.remove(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e, int k){}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
}

package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.GamePanel;

public class MenuState extends State {

	private String[] options = { "Play", "Options", "Quit" }; // LIST OF MENUS
	private int currentSelect = 0;

	public MenuState(GameStateManager gsm) 
	{
		super(gsm);
		if(gsm.states.size()>2)
			for(int i =gsm.states.size()-1;i>0;i--){
				gsm.states.remove(i);
			}
		System.out.println(gsm.states.toString());

	}

	public void init() {}

	public void update() {}

	public void render(Graphics2D g) 
	{
		g.setColor(Color.WHITE);
		g.drawString("MENUSTATE", 0, 10);

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
		 * QUICK EXIT
		 */
		if (k == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}

		/*
		 * SELECTING MENU
		 */
		if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)
		{
			if (currentSelect == 0)
			{
				// play
				//gsm = new GameStateManager(GameStateManager.MENUSTATE);

				gsm.states.push(new LevelSelectState(gsm));
				System.out.println("LevelSelectState started, #ofstates: " + gsm.states.size());
			} 
			else if (currentSelect == 1)
			{
				// options
				gsm.states.push(new OptionsMenu(gsm));
				System.out.println("OptionsState started, #ofstates: " + gsm.states.size());
			} 
			else if (currentSelect == 2)
			{
				// quit
				System.exit(0);
			}
		}

	}

	public void keyReleased(KeyEvent e, int k) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
}
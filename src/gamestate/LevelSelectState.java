package gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import csit111project.GamePanel;

public class LevelSelectState extends State{
	private String[] levels = {"Level1","Level2", "Main Menu"};
	private int currentSelect=0;
	
	public LevelSelectState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void init() {	
		
	}


	public void update() {
		
	}

	
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawString("LEVEL SELECT STATE", 0, 10);
		
		g.setFont(new Font("Courier", Font.BOLD, 50));
		g.setColor(Color.RED);
		g.drawString("Select Level", GamePanel.WIDTH/2-130,GamePanel.HEIGHT/2-100);

		/*
		 * DRAW MENUS
		 */
		for (int i = 0; i < levels.length; i++)
		{
			g.setFont(new Font("Arial", Font.BOLD, 50));
			if (i == currentSelect)
			{
				g.setColor(Color.GREEN);
				g.drawString(">", GamePanel.WIDTH / 2 - 50 - 30, GamePanel.HEIGHT / 2 + i * 50);
			} 
			else 
			{
				g.setColor(Color.WHITE);
			}
			
			g.drawString(levels[i], GamePanel.WIDTH / 2 - 50, GamePanel.HEIGHT / 2 + i * 50);
			g.setFont(new Font("Arial", Font.BOLD, 12));
		}
	}

	
	public void keyPressed(KeyEvent e, int k) {
		/*
		 * LISTING THROUGH MENUS
		 */
		if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) 
		{
			if (currentSelect < levels.length - 1)
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
				currentSelect = levels.length - 1;
			}
		}
		
		/*
		 * SELECTING MENU
		 */
		if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)
		{
			if (currentSelect == 0)
			{
				// Level1
				gsm.states.push(new Level1(gsm));
				System.out.println("Level1 created, #ofstates: "+gsm.states.size());
			} 
			else if (currentSelect == 1)
			{
				// Level2
				//gsm.states.push(new Level2(gsm));
			} 
			else if(currentSelect==2){
				gsm.states.push(new MenuState(gsm));
				for(int i =gsm.states.size()-1;i>0;i--){
					gsm.states.remove(i);
				}
			}
		}
	}

	
	public void keyReleased(KeyEvent e, int k) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
	}

}

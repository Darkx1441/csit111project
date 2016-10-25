package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import csit111project.GamePanel;

public class WinScreenState extends State{

	public WinScreenState(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {

	}

	
	public void update() {

	}

	
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawString("YOU WON, nice.", GamePanel.WIDTH/2, GamePanel.HEIGHT/2);
	}

	
	public void keyPressed(KeyEvent e, int k) {
		if (k == KeyEvent.VK_ENTER) {
			gsm.states.push(new LevelSelectState(gsm));
			for (int i = gsm.states.size() - 1; i > 1; i--) {
				gsm.states.remove(i);
			}
			System.out.println("Escape pressed, #ofstates: " + gsm.states.size());
		}
	}

	
	public void keyReleased(KeyEvent e, int k) {
		
	}

	
	public void mousePressed(MouseEvent e) {
	
	}

	
	public void mouseReleased(MouseEvent e) {

		
	}

}

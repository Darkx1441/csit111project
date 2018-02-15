package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.GamePanel;

public class WinScreenState extends State{

	public WinScreenState(GameStateManager gsm) {
		super(gsm);
		System.out.println(gsm.states.toString());
	}

	
	public void init() {}
	public void update() {}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawString("Congratulations! You got the Artifact!", GamePanel.getScreenWidth()/2-70, GamePanel.getScreenHeight()/2);
		g.drawString("Press SPACE or ENTER to proced to next level", GamePanel.getScreenWidth()/2-100, GamePanel.getScreenHeight()/2 + 200);
	}
	
	public void keyPressed(KeyEvent e, int k) {
		if (k == KeyEvent.VK_ENTER || k==KeyEvent.VK_SPACE) {
			gsm.states.push(new LevelSelectState(gsm));
		}
	}
	public void keyReleased(KeyEvent e, int k) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}

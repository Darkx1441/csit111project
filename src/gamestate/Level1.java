package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;

public class Level1 extends State {

	private Player player;
	
	public Level1(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		player=new Player(50,100);
	}
	
	public void update() {
		player.update();
	}

	public void render(Graphics2D g) {
		
		g.setColor(Color.RED);
		g.drawLine(400, 0, 400, 800);
		g.drawLine(0, 240, 800, 240);
		g.setColor(Color.WHITE);
		g.drawString("Level1 State", 0, 10);
		g.drawString("POS: \t X= "+ player.getX()+" Y= "+ player.getY(), 0, 21);
		g.drawString("\tJS "+ player.getJumpSpeed()+" FS= "+ player.getFallSpeed(), 0, 32);
		
		player.render(g);
	}

	public void keyPressed(KeyEvent e, int k) {
		player.keyPressed(k);
	}

	public void keyResealed(KeyEvent e, int k) {
		player.keyReleased(k);
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}


}

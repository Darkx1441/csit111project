package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import mapping.Map;
import objects.Block;
import objects.EndGate;

public class Level1 extends State {
	private Player player;
	private Map map;
	private EndGate endGate;

	public Level1(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		player = new Player(64, 64);
		map = new Map("/maps/map1.map");
		endGate = new EndGate(1450, 400, 50, 50);
		
		xOffset=-200;
		yOffset=-400;
	}

	public void update() {

		player.update(map.getBlocks(),endGate);
		}

	

	public void render(Graphics2D g) {
		/*
		 * DEBUG LINES
		 */
		g.setColor(Color.RED);
		g.drawLine(400, 0, 400, 800);
		g.drawLine(0, 240, 800, 240);
		g.drawString("Level1 State", 0, 10);
		g.drawString("POS: \t X= " + (int) State.xOffset + " Y= " + (int) State.yOffset, 0, 21);
		g.drawString("\tJS " + player.getJumpSpeed() + " FS= " + player.getFallSpeed(), 0, 32);

		// render player
		player.render(g);
		
		//render map
		map.render(g);



		// render End Gate
		endGate.render(g);
		if (player.win == true) {
			gsm.states.push(new MenuState(gsm));
		}

	}

	public void keyPressed(KeyEvent e, int k) {
		player.keyPressed(k);

		if (k == KeyEvent.VK_ESCAPE) {
			gsm.states.push(new MenuState(gsm));
		}
	}

	public void keyReleased(KeyEvent e, int k) {
		player.keyReleased(k);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}

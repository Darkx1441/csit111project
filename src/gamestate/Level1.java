package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import csit111project.GamePanel;
import entities.Player;
import mapping.Map;
import objects.Key;

public class Level1 extends State {
	private Player player;
	private Map map;
	private Key key;


	public Level1(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		player = new Player(64, 64);
		map = new Map("/maps/map1.map");
		
		xOffset=-200;
		yOffset=-400;
	}

	public void update() {

		player.update(map.getBlocks(),map.getEndGate(), map.getKey());
		}

	

	public void render(Graphics2D g) {
		/*
		 * DEBUG LINES
		 */
		if(player.debugMonitor==true){
		g.setColor(Color.RED);
		g.drawLine(GamePanel.WIDTH/2, 0, GamePanel.WIDTH/2, GamePanel.HEIGHT);
		g.drawLine(0, GamePanel.HEIGHT/2, GamePanel.WIDTH, GamePanel.HEIGHT/2);
		g.drawString("Level1 State", 0, 10);
		g.drawString("POS: \t X= " + (int) State.xOffset + " Y= " + (int) State.yOffset, 0, 21);
		g.drawString("\tJS " + player.getJumpSpeed() + " FS= " + player.getFallSpeed(), 0, 32);
		
		//g.drawString("FPS:" + , 0, 43);
		}
		// render player
		player.render(g);
		
		//render map
		map.render(g);

		if (player.win == true) {
			gsm.states.push(new MenuState(gsm));
		}
		
		if(player.hasKey){
			g.setColor(Color.GREEN);
			g.drawString("Key Obtained, Go for Exit!", 0, 50);
		}else{
			g.setColor(Color.RED);
			g.drawString("Key Missing, look for the key!", 0, 50);
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

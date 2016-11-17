package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import animation.LevelAnimation;
import csit111project.GamePanel;
import entities.Player;
import mapping.Map;

public class Level1 extends State {
	public int stateid = 2;
	private Player player;
	private Map map;
	private int timerDelay = 1000 / 5;
	private Timer timer;
	private int color = 1;
	private LevelAnimation levelAnimation= new LevelAnimation();

	public Level1(GameStateManager gsm) {
		super(gsm);
		System.out.println(gsm.states.toString());
		levelAnimation.init();

		timer = new Timer(timerDelay, timerAction);
	}

	public void init() {
		player = new Player(-290, -100);
		map = new Map("/maps/map1.map", timer);
	}

	public void update() {

		player.update(map.getBlocks(), map.getEndGate(), map.getKey());
	}

	public void render(Graphics2D g) {
		/*
		 * DEBUG Hitboxes
		 */
		if (player.debugMonitor == true) {
			map.renderHitbox(g);
			player.renderHitbox(g);
			
		}
		// render player
		player.render(g);

		// render map
		map.render(g, levelAnimation);

		if (player.hasKey) {
			timer.start();
			if (color == 1) {
				g.setColor(Color.GREEN);
			} else if (color == 2) {
				g.setColor(Color.BLUE);
			} else if (color == 3) {
				g.setColor(Color.WHITE);
			} else if (color == 4) {
				color = 1;
			} else {
				color++;
			}
			g.drawString("Key Obtained, Go for Exit!", 0, 60);

		} else {
			g.setColor(Color.RED);
			g.drawString("Key Missing, look for the key!", 0, 60);
		}

		if (player.win == true) {
			gsm.states.push(new WinScreenState(gsm));
			timer.stop();
			player.getTimer().stop();
			gsm.states.remove(2);
			gsm.states.remove(1);
			map=null;
			player.getPlayerAnim().clearAnim();
			levelAnimation.clearAnim();
			System.out.println("player won, #ofstates: " + gsm.states.size());
		}
		
		if(player.debugMonitor==true){
			drawDebug(g);
		}

	}

	public void keyPressed(KeyEvent e, int k) {
		player.keyPressed(k);

		if (k == KeyEvent.VK_ESCAPE) {
			gsm.states.push(new MenuState(gsm));
			timer.stop();
			player.getTimer().stop();
			map=null;

//			for (int i = gsm.states.size() - 1; i > 1; i--) {
//				gsm.states.remove(i);
//			}
			System.out.println("Escape pressed, #ofstates: " + gsm.states.size());
		}
	}

	public void keyReleased(KeyEvent e, int k) {
		player.keyReleased(k);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	ActionListener timerAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			color++;
			if (color >= 4)
				color = 1;
			
		}
	};

	public void drawDebug(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawString("Level1 State", 0, 10);
		g.drawString("POS: \t X= " + (int) State.xOffset + " Y= " + (int) State.yOffset, 0, 21);
		g.drawString("\tJS " + player.getJumpSpeed() + " FS= " + player.getFallSpeed(), 0, 32);
		g.drawLine(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT);
		g.drawLine(0, GamePanel.HEIGHT / 2, GamePanel.WIDTH, GamePanel.HEIGHT / 2);
		g.drawString("AnimFrame:"+ player.getAnimFrame()+" Max: "+player.getAnimFrameMax(), 0, 52);
	}

}

// chapter 9 use of timer

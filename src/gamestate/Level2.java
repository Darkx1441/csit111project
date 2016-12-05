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

public class Level2 extends State {
	public int stateid = 2;
	private Player player;
	private Map map;
	private int timerDelay = 1000 / 5;
	private Timer timer;
	private int color = 1;
	private LevelAnimation levelAnimation;
	
	double BGParraX = .90;
	double FGParra = 1.35;
	
	public Level2(GameStateManager gsm) {
		super(gsm);
		System.out.println(gsm.states.toString());

		timer = new Timer(timerDelay, colorCycle);
	}

	public void init() {
		map = new Map("/maps/map2.map", timer);
		player = new Player(20, -20);
		levelAnimation = new LevelAnimation(map);
		levelAnimation.init();
	}

	public void update() {

		player.update(map.getBlocks(), map.getEndGate(), map.getKey());
	}

	public void render(Graphics2D g) {
		
//		for (int i= (levelAnimation.getWidthFactor(levelAnimation.getBackGround(2).getTileWidth()));i>=0; i--)
//			 for (int j= (levelAnimation.getHeightFactor(levelAnimation.getBackGround(2).getTileHeight()));j>-1; j--){
//				g.drawImage(levelAnimation.getBackGround(2),
//						(int) ((levelAnimation.getBackGround(2).getTileWidth()*i-1) - (State.xOffset*BGParraX)),
//						(int) ((levelAnimation.getBackGround(2).getTileHeight() *j) - (State.yOffset*BGParraX)), null);
//			 }
//		
		
	g.drawImage(levelAnimation.getBackGround(2), (int) (0 - (State.xOffset)), (int) (0 - State.yOffset), null);
		
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
			gsm.states.remove(2);
			gsm.states.remove(1);
			levelAnimation.clearAnim();
			player.getPlayerAnim().clearAnim();
			System.out.println("player won, #ofstates: " + gsm.states.size());
		}

		/*
		 * DEBUG LINES
		 */
		if (player.debugMonitor == true) {
			drawDebug(g);
			
		}
	}

	public void keyPressed(KeyEvent e, int k) {
		player.keyPressed(k);
		

		if (k == KeyEvent.VK_ESCAPE) {
			gsm.states.push(new MenuState(gsm));
			timer.stop();
			levelAnimation.clearAnim();
			player.getPlayerAnim().clearAnim();
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

	ActionListener colorCycle = new ActionListener() {
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
		g.drawLine(GamePanel.getScreenWidth() / 2, 0, GamePanel.getScreenWidth() / 2, GamePanel.getScreenHeight());
		g.drawLine(0, GamePanel.getScreenHeight() / 2, GamePanel.getScreenWidth(), GamePanel.getScreenHeight() / 2);
		g.drawString("AnimFrame:"+ player.getAnimFrame()+" Max: "+player.getAnimFrameMax(), 0, 43);

	}
}

// chapter 9 use of timer

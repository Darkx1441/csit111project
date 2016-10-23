package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import csit111project.GamePanel;
import entities.Player;
import mapping.Map;

public class Level1 extends State {
	public int stateid= 2;
	private Player player;
	private Map map;
	private int timerDelay=1000/5;
	private Timer timer;
	private int color=1;
	
	

	public Level1(GameStateManager gsm) {
		super(gsm);
		timer= new Timer(timerDelay, colorCycle);
	}

	public void init() {
		player = new Player(-290, -100);
		map = new Map("/maps/map1.map");
//		xOffset=-200;
//		yOffset=-400;
	}

	public void update() {

		player.update(map.getBlocks(),map.getEndGate(), map.getKey());
		}

	

	public void render(Graphics2D g) {
		/*
		 * DEBUG LINES
		 */
		if(player.debugMonitor==true){
		drawDebug(g);
		//g.drawString(""+GamePanel.getFPS(), 0, 43);

		}
		// render player
		player.render(g);
		
		//render map
		map.render(g);

		if(player.hasKey)
		{
			timer.start();
			if(color==1)
			{
				g.setColor(Color.GREEN);
			}
			else if(color==2)
			{
				g.setColor(Color.BLUE);
			}else if(color==3){
				g.setColor(Color.WHITE);
			}else if(color==4){color=1;}else{color++;}
			g.drawString("Key Obtained, Go for Exit!", 0, 60);
			
		}else{
			g.setColor(Color.RED);
			g.drawString("Key Missing, look for the key!", 0, 60);
		}
		
		if (player.win == true) {
			gsm.states.push(new LevelSelectState(gsm));
			timer.stop();
			for(int i =gsm.states.size();i>1;i--){
			gsm.states.remove(i);
			}
		}

	}

	public void keyPressed(KeyEvent e, int k) {
		player.keyPressed(k);

		if (k == KeyEvent.VK_ESCAPE) 
		{
			gsm.states.push(new MenuState(gsm));
			timer.stop();
			for(int i =gsm.states.size();i>1;i--){
				gsm.states.remove(i);
			}
		}
	}

	public void keyReleased(KeyEvent e, int k) {
		player.keyReleased(k);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
	ActionListener colorCycle = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("TEST TRUE "+ color);
			color++;
			if(color>=4)color=1;
		}
	};
	
	public void drawDebug(Graphics2D g){
		g.setColor(Color.RED);
		g.drawLine(GamePanel.WIDTH/2, 0, GamePanel.WIDTH/2, GamePanel.HEIGHT);
		g.drawLine(0, GamePanel.HEIGHT/2, GamePanel.WIDTH, GamePanel.HEIGHT/2);
		g.drawString("Level1 State", 0, 10);
		g.drawString("POS: \t X= " + (int) State.xOffset + " Y= " + (int) State.yOffset, 0, 21);
		g.drawString("\tJS " + player.getJumpSpeed() + " FS= " + player.getFallSpeed(), 0, 32);
		g.setColor(Color.WHITE);
	}
}


//chapter 9 use of timer

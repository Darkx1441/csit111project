package gamestate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import objects.Block;
import objects.EndGate;
import physics.Collision;

public class Level1 extends State
{
	private Player player;
	private Block[] b;
	private EndGate endGate;
	
	public Level1(GameStateManager gsm) 
	{
		super(gsm);
	}

	public void init() 
	{
		player = new Player(64, 64);
		b = new Block[5];
		b[0] = new Block(100, 350, 200, 100);
		b[1] = new Block(200, 270, 20, 20);
		b[2] = new Block(240, 400, 200, 100);
		b[3] = new Block(200, 300,20,20);
		b[4] = new Block(0, 450, 1500,20);
		endGate= new EndGate(1450,400,50,50);
	}

	public void update() 
	{
		for (int i = 0; i < b.length; i++)
		{
			b[i].update();
		}
		
		player.update(b,endGate);
		
		//if(Collision.playerBlock(p, b))
	}

	public void render(Graphics2D g)
	{
		/*
		 * DEBUG LINES
		 */
		g.setColor(Color.RED);
		g.drawLine(400, 0, 400, 800);
		g.drawLine(0, 240, 800, 240);
		//g.setColor(Color.WHITE);
		g.drawString("Level1 State", 0, 10);
		g.drawString("POS: \t X= " + (int)State.xOffset + " Y= " + (int)State.yOffset, 0, 21);
		g.drawString("\tJS " + player.getJumpSpeed() + " FS= " + player.getFallSpeed(), 0, 32);
		
		// render player
		player.render(g);
		
		// render blocks
		for(int i = 0; i < b.length; i++)
		{
			b[i].draw(g);
		}
		endGate.render(g);
		
		if(player.win==true){
			gsm.states.push(new MenuState(gsm));
		}
	}

	public void keyPressed(KeyEvent e, int k)
	{
		player.keyPressed(k);
		
		if (k == KeyEvent.VK_ESCAPE) 
		{
			gsm.states.push(new MenuState(gsm));
		}
	}

	public void keyReleased(KeyEvent e, int k)
	{
		player.keyReleased(k);
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
}

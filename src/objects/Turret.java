package objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import gamestate.MenuState;
import gamestate.State;

public class Turret extends Rectangle
{
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	private int xpos,ypos;
	private int blockid;
	private boolean active;
	private boolean destroyed;
	Timer timedFrames;
	private int frameCount, maxFrames;
	private Projectile projectile;
	
	public Turret(int x, int y, int id)
	{
		setBounds(x, y, blocksize, blocksize);	
		this.blockid= id;
		active=true;
		destroyed=false;
		timedFrames = new Timer(125, animTimer);
		timedFrames.start();
	}
	
	public void update() {
		if(projectile!=null){
			projectile.update();
		}
		
	}
	
	public void render(Graphics2D g)
	{
		xpos=x - (int) State.xOffset;
		ypos=y - (int) State.yOffset;
		if(blockid==4){
			g.setColor(Color.green);
			g.drawString("A: "+ active+" D: "+ destroyed, xpos, ypos);
			g.drawRect(xpos,ypos,blocksize,blocksize);
			if(active&&!destroyed){
			g.fillRect(xpos, ypos, blocksize, blocksize);
			}else if(!active&&!destroyed){
				g.setColor(Color.RED);
				g.fillRect(xpos, ypos, blocksize, blocksize);
			}else if(destroyed){
				g.setColor(Color.red);
				active=false;
			}
			if(projectile!=null)
			projectile.render(g);
		}

	}
	
	ActionListener animTimer = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (frameCount >= maxFrames){
				frameCount =0;
			}else{
				frameCount++;
			}
			
		}
	};
	
	public void fire(){
		projectile = new Projectile(xpos,ypos);
		System.out.println("turret fire");
	}
	
	public void setID(int id){
		this.blockid= id;
	}
	
	public int getID(){
		return blockid;
	}
	public boolean getActive(){
		return active;
	}
	public boolean getDestroyed(){
		return destroyed;
	}
	public int getXpos(){
		return xpos;
	}
	public int getYpos(){
		return ypos;
	}
	
	public void setActive(boolean a){
		active=a;
	}
	public void setDestroyed(boolean a){
		destroyed=a;
	}
	
}
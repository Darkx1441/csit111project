package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import com.sun.glass.events.KeyEvent;

import csit111project.GamePanel;

public class Player{


	private boolean right=false,left=false,jumping=false, falling=false;
	private double x,y;
	private int width, height;
	
	private double maxJumpSpeed=5;
	private double currentJumpSpeed=5;
	
	private double maxFallSpeed=2;
	private double currentFallSpeed=0.1;
	
	public int getX(){
		return (int)x;
	}
	
	public int getY(){
		return (int)y;
	}
	
	public int getFallSpeed(){
		return (int)currentFallSpeed;
	}
	public int getJumpSpeed(){
		return (int)currentJumpSpeed;
	}
	
	
	public Player(int width, int height){
		x=GamePanel.WIDTH/2;
		y=GamePanel.HEIGHT/2;
		this.width=width;
		this.height=height;
	}
		
	public void update(){
		if(right)
			x++;
		if(left)
			x--;
		
		if(jumping){
			y-=currentJumpSpeed;
			currentJumpSpeed-=.1;
			
			if(currentJumpSpeed<=0){
				currentJumpSpeed=maxJumpSpeed;
				jumping=false;
				falling=true;
			}
		}
			
		if(falling){
			y+=currentFallSpeed;
			if(currentFallSpeed<=maxFallSpeed){
				currentFallSpeed+=0.1;
			}
		}
		
		if(!falling){
			currentFallSpeed=.1;
		}
	}
	
	public void render(Graphics2D g){ 
		//character graphics
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void keyPressed(int k){
		if(k==KeyEvent.VK_D || k==KeyEvent.VK_RIGHT) //go right pressed
			right=true;
		if(k==KeyEvent.VK_A || k==KeyEvent.VK_LEFT) //go left pressed
			left=true;
		if(k==KeyEvent.VK_W || k==KeyEvent.VK_UP) //go left pressed
			jumping=true;
	}
	
	public void keyReleased(int k){
		if(k==KeyEvent.VK_D || k==KeyEvent.VK_RIGHT)//go right released
			right=false;
		if(k==KeyEvent.VK_A || k==KeyEvent.VK_LEFT) //go left released
			left=false;
	}

}

package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.sun.glass.events.KeyEvent;

import csit111project.GamePanel;
import gamestate.State;
import objects.Block;
import physics.Collision;

public class Player {

	private boolean right = false, left = false, jumping = false, falling = false;
	
	private boolean topCollision = false;
	private boolean rightCollision = false;
	private boolean leftCollision = false;
	
	private double x, y;
	private int width, height;

	private double moveSpeed = 5;

	private double maxJumpSpeed = 5;
	private double currentJumpSpeed = maxJumpSpeed;

	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public int getFallSpeed() {
		return (int) currentFallSpeed;
	}

	public int getJumpSpeed() {
		return (int) currentJumpSpeed;
	}

	public Player(int width, int height) {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void update(Block[] b){
		
		int iX = (int)x;
		int iY = (int)y;
		
		for(int i = 0;i<b.length;i++){
			
			//right
			if(Collision.playerBlock(new Point(iX+width +(int)State.xOffset, iY+(int)State.yOffset+2), b[i]) 
					|| Collision.playerBlock(new Point (iX+width+(int)State.xOffset, iY+height+(int)State.yOffset-1), b[i])){
				right=false;
				rightCollision = true;
				
//			}else{
//				if(!leftCollision && right)
//					right=true;
			}
			
			//left
			if(Collision.playerBlock(new Point(iX +(int)State.xOffset-1, iY+(int)State.yOffset+2), b[i]) 
					|| Collision.playerBlock(new Point (iX+(int)State.xOffset-1, iY+height+(int)State.yOffset-1), b[i])){
				left=false;
				leftCollision = true;
//			}else{
//				if(!rightCollision && !left)
//					left=true;
					
			
			}
			
			//top
			if(Collision.playerBlock(new Point(iX +(int)State.xOffset+1, iY+(int)State.yOffset), b[i]) ||
					Collision.playerBlock(new Point (iX+width+(int)State.xOffset-1, iY+(int)State.yOffset), b[i])){
				jumping=false;
				currentJumpSpeed=maxJumpSpeed;
				falling=true;
			}
		
			//bottom
			if(Collision.playerBlock(new Point(iX +(int)State.xOffset+2, iY+height+(int)State.yOffset+1), b[i]) ||
					Collision.playerBlock(new Point (iX+width+(int)State.xOffset-1, iY+height+(int)State.yOffset+1), b[i])){
				State.yOffset= b[i].getY()-height - y;
				falling=false;
				topCollision = true;
			}else{
				if(!topCollision && !jumping)
					falling=true;
			}
		}
		topCollision=false;
		rightCollision= false;
		leftCollision= false;
		
		/*
		 * Movement Mechanics (temporary)
		 */
		if(right)
			State.xOffset+=moveSpeed;
		if(left)
			State.xOffset-=moveSpeed;
		
		/*
		 * Jumping/Falling Mechanics
		 */
		if(jumping){
			State.yOffset-=currentJumpSpeed;
			currentJumpSpeed-=.1;
			falling=false;
			
			if(currentJumpSpeed<=0){
				currentJumpSpeed=maxJumpSpeed;
				jumping=false;
				falling=true;
			}
		}
			
		if(falling){
			State.yOffset+=currentFallSpeed;
			if(currentFallSpeed<=maxFallSpeed){
				currentFallSpeed+=0.1;
			}
		}
		
		if(!falling){
			currentFallSpeed=.1;
		}
	}

	public void render(Graphics2D g) {
		// character graphics
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, width, height);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) // go right pressed
			right = true;
		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) // go left pressed
			left = true;
		if ((k == KeyEvent.VK_W
				|| k == KeyEvent.VK_UP) && !jumping && !falling) // go left
																		// pressed
			jumping = true;
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT)// go right released
			right = false;
		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) // go left released
			left = false;
	}

}

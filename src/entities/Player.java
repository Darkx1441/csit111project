package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import com.sun.glass.events.KeyEvent;

import csit111project.GamePanel;
import gamestate.Level1;
import gamestate.State;
import objects.Block;
import objects.EndGate;
import objects.Key;
import physics.Collision;

public class Player {

	BufferedImage RightI01, RightI02, RightI03, RightI04, RightI05, RightI06, RightI07, LeftI01, RightR01, LeftR01, RightJ01, LeftJ01;
	private boolean right = false, left = false, jumping = false, falling = false;
	
	private int frameCount = 0;
	
	private Timer Timedframes;
	
	ArrayList <BufferedImage> RightIdle  = new ArrayList<BufferedImage>();

	private boolean topCollision = false;
	private boolean FacingRight = true;
	private boolean FacingLeft = false;
	// private int state; //0 is idle right, 1 is idle left ,2 is running right,
	// 3 is running left

	private int width=64, height=64-1;
	private double x = GamePanel.WIDTH/2-width/2, y=GamePanel.HEIGHT/2-height/2;

	private double moveSpeed = 5;

	private double maxJumpSpeed = 5;
	private double currentJumpSpeed = maxJumpSpeed;

	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	public boolean win = false;
	public boolean hasKey= false;

	public boolean debugMonitor = false;

	/*
	 * PLAYER CONSTRUCTOR
	 */
	public Player(int px, int py) {
		Level1.xOffset=px;
		Level1.yOffset=py;
		init();
		
	}
	/*
	 * PLAYER INITIALIZATION
	 */
	public void init() {
		try {
			RightI01 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle01.png"));
			RightI02 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle02.png"));
			RightI03 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle03.png"));
			RightI04 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle04.png"));
			RightI05 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle05.png"));
			RightI06 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle06.png"));
			RightI07 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle07.png"));
			
			LeftI01 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/left/CharLIdle01.png"));
			RightR01 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharRun01.png"));
			LeftR01 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/left/CharLRun01.png"));
			LeftJ01 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/left/CharLJump01.png"));
			RightJ01 = ImageIO
					.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharJump01.png"));

		} catch (IOException e) {
		}
		
		RightIdle.add(RightI01);
		RightIdle.add(RightI02);	
		RightIdle.add(RightI03);
		RightIdle.add(RightI04);
		RightIdle.add(RightI05);
		RightIdle.add(RightI06);
		RightIdle.add(RightI07);
		
		Timedframes.start();
		
	}

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

<<<<<<< HEAD
	/*
	 * PLAYER METHOD
	 */
	public Player(int px, int py) {
		Level1.xOffset=px;
		Level1.yOffset=py;
		Timedframes = new Timer(150, AnimTimer);
		init();
		
		
	}
=======
>>>>>>> origin/master

	/*
	 * PLAYER UPDATE
	 */
	public void update(Block[][] b, EndGate[][] endGate, Key[][] key) {

		int iX = (int) x;
		int iY = (int) y;

		/*
		 * BLOCK COLLISION
		 */
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j].getID() ==1) {
					// right
					for (int k = 0; k <= height; k++) {
						if (Collision.playerBlock(
								new Point(iX + width + (int) State.xOffset + 4, iY + (int) State.yOffset + k - 1),b[i][j])) {
							right = false;
						}
					}

					// left
					for (int k = 0; k < height - 1; k++) {
						if (Collision.playerBlock(new Point(iX + (int) State.xOffset - 2, iY + (int) State.yOffset + k),b[i][j])) {
							left = false;
						}
					}

					// top
					for (int k = 0; k < width - 2; k++) {
						if (Collision.playerBlock(new Point(iX + (int) State.xOffset + k + 2, iY + (int) State.yOffset),
								b[i][j])) {
							jumping = false;
							currentJumpSpeed = maxJumpSpeed;
							falling = true;
						}
					}

					// bottom
					for (int k = 0; k < width - 8; k++) {
						if (Collision.playerBlock(
								new Point(iX + (int) State.xOffset + k + 4, iY + height + (int) State.yOffset + 1),
								b[i][j])) {

							State.yOffset = b[i][j].getY() - height - y;
							falling = false;
							topCollision = true;
						} else {
							if (!topCollision && !jumping)
								falling = true;
						}
					}
				}
			}
		}
		
		/*
		 * ENDGATE COLLISION
		 */
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (endGate[i][j].getID()==2) {
					
					//RIGHT
					for (int k = 0; k <= height; k++) {
						if (Collision.playerGate(
								new Point(iX + width + (int) State.xOffset, iY + (int) State.yOffset + k - 1),endGate[i][j])) {
							if(hasKey)
								win = true;
						}
					}
					
					//LEFT
					for (int k = 0; k < height - 1; k++) {
						if (Collision.playerGate(new Point(iX + (int) State.xOffset - 1, iY + (int) State.yOffset + k),endGate[i][j])) {
							if(hasKey)
								win = true;

						}
					}
					
					//TOP
					for (int k = 0; k < width - 2; k++) {
						if (Collision.playerGate(new Point(iX + (int) State.xOffset + k, iY + (int) State.yOffset),endGate[i][j])) {
							if(hasKey)
								win = true;
						}
					}
					//BOTTOM
					for (int k = 0; k < width - 8; k++) {
						if (Collision.playerGate(
								new Point(iX + (int) State.xOffset + k, iY + height + (int) State.yOffset + 1),
								endGate[i][j])) {
							if(hasKey)	
								win = true;
						}
					}
				}
			}
		}
		
		/*
		 * KEY COLLISION
		 */
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (key[i][j].getID()==3) {
					
					//RIGHT
					for (int k = 0; k <= height; k++) {
						if (Collision.playerKey(
								new Point(iX + width + (int) State.xOffset+5, iY + (int) State.yOffset + k - 1),key[i][j])) {
							key[i][j].setID(0);
							hasKey=true;
						}
					}
					
					//LEFT
					for (int k = 0; k < height ; k++) {
						if (Collision.playerKey(new Point(iX + (int) State.xOffset-5, iY + (int) State.yOffset + k),key[i][j])) {
							key[i][j].setID(0);
							hasKey=true;
						}
					}
					
					//TOP
					for (int k = 0; k < width - 2; k++) {
						if (Collision.playerKey(new Point(iX + (int) State.xOffset + k, iY + (int) State.yOffset),key[i][j])) {
							key[i][j].setID(0);
							hasKey=true;
						}
					}
					//BOTTOM
					for (int k = 0; k < width - 8; k++) {
						if (Collision.playerKey(
								new Point(iX + (int) State.xOffset + k, iY + height + (int) State.yOffset + 1),
								key[i][j])) {
							key[i][j].setID(0);
							hasKey=true;
						}
					}
				}
			}
		}
		topCollision = false;

		/*
		 * Movement Mechanics (temporary)
		 */
		if (right)
			State.xOffset += moveSpeed;

		if (left)
			State.xOffset -= moveSpeed;

		/*
		 * Jumping/Falling Mechanics
		 */
		if (jumping) {
			State.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= .15;
			falling = false;

			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = maxJumpSpeed;
				jumping = false;
				falling = true;
			}
		}

		if (falling) {
			State.yOffset += currentFallSpeed;
			if (currentFallSpeed <= maxFallSpeed) {
				currentFallSpeed += 0.15;

			}
		}

		if (!falling) {
			currentFallSpeed = .1;
		}
	}

	/*
	 * PLAYER RENDER
	 */
	public void render(Graphics2D g) {
		// character graphics
		if (FacingRight && !right && !jumping && !falling) {
			//for (int i =1; i > 0;)
				//for (int count =0; count <7; count++)
					g.drawImage(RightIdle.get(frameCount), (int) x, (int) y, null);

					}
		if (FacingLeft && !left && !jumping && !falling) {
			g.drawImage(LeftI01, (int) x, (int) y, null);
		}
		if (right && !jumping && !falling) {
			g.drawImage(RightR01, (int) x, (int) y, null);
		}
		if (left && !jumping && !falling) {
			g.drawImage(LeftR01, (int) x, (int) y, null);
		}
		if (jumping == true | falling == true) {
			if (FacingRight) {
				g.drawImage(RightJ01, (int) x, (int) y, null);
			}
			if (FacingLeft) {
				g.drawImage(LeftJ01, (int) x, (int) y, null);
			}
		}
	}
	ActionListener AnimTimer = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frameCount++;
			if (frameCount == RightIdle.size())
				frameCount=0;
			
		}
	};

	/*
	 * KEY EVENTS
	 */
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) { // go right pressed
			right = true;
			FacingLeft = false;
			FacingRight = true;
		}

		if (k == KeyEvent.VK_T) { //debug monitor toggle
			debugMonitor = !debugMonitor;
		}

		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) { // go left pressed
			left = true;
			FacingRight = false;
			FacingLeft = true;
		}

		if ((k == KeyEvent.VK_W || k == KeyEvent.VK_UP) && !jumping && !falling) { // jump
																					// pressed
			jumping = true;
		}
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {// go right released
			right = false;
		}
		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) { // go left released
			left = false;
		}
	}
}

package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.sun.glass.events.KeyEvent;

import animation.PlayerAnimation;
import csit111project.GamePanel;
import gamestate.Level1;
import gamestate.State;
import objects.Block;
import objects.EndGate;
import objects.Key;
import physics.Collision;

public class Player {

	private boolean right = false, left = false, jumping = false, falling = false;

	private int frameCount = 0;
	private int maxFrames = 0;

	private Timer timer;

	private PlayerAnimation playerAnimation;

	private boolean topCollision = false;
	private boolean FacingRight = true;
	private boolean FacingLeft = false;

<<<<<<< HEAD
	private int width=64, height=64-1;
	private double x = GamePanel.getScreenWidth()/2-width/2, y=GamePanel.getScreenHeight()/2-height/2;
=======
	private int width = 64, height = 64 - 1;
	private double x = GamePanel.WIDTH / 2 - width / 2, y = GamePanel.HEIGHT / 2 - height / 2;
>>>>>>> origin/master

	private double moveSpeed = 5;

	private double maxJumpSpeed = 7.5;
	private double currentJumpSpeed = maxJumpSpeed;

	private double maxFallSpeed = 8;
	private double currentFallSpeed = 0.1;
	public boolean win = false;
	public boolean hasKey = false;

	public boolean debugMonitor = false;
	public boolean noclip = false;
	private int noclipSpeed = 1;

	/*
	 * PLAYER CONSTRUCTOR
	 */
	public Player(int px, int py) {
		Level1.xOffset = px;
		Level1.yOffset = py;
		timer = new Timer(125, AnimTimer);
		timer.start();
		init();

	}

	/*
	 * PLAYER INITIALIZATION
	 */
	public void init() {
		playerAnimation = new PlayerAnimation();
	}

	/*
	 * PLAYER UPDATE
	 */
	public void update(Block[][] b, EndGate[][] endGate, Key[][] key) {

		int iX = (int) x;
		int iY = (int) y;

		/*
		 * BLOCK COLLISION
		 */
		if (!noclip) {
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					if (b[i][j].getID() == 1) {
						// right
						for (int k = 0; k <= height; k++) {
							if (Collision.playerBlock(
									new Point(iX + width + (int) State.xOffset + 4, iY + (int) State.yOffset + k - 1),
									b[i][j])) {
								//right = false;
								State.xOffset-=moveSpeed;
							}
						}

						// left
						for (int k = 0; k < height - 1; k++) {
							if (Collision.playerBlock(
									new Point(iX + (int) State.xOffset - 2, iY + (int) State.yOffset + k), b[i][j])) {
								State.xOffset+=moveSpeed;
								//left = false;
							}
						}

						// top
						for (int k = 0; k < width - 2; k++) {
							if (Collision.playerBlock(
									new Point(iX + (int) State.xOffset + k + 2, iY + (int) State.yOffset-5), b[i][j])) {
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
					if (endGate[i][j].getID() == 2) {

						// RIGHT
						for (int k = 0; k <= height; k++) {
							if (Collision.playerGate(
									new Point(iX + width + (int) State.xOffset, iY + (int) State.yOffset + k - 1),
									endGate[i][j])) {
								if (hasKey)
									win = true;
							}
						}

						// LEFT
						for (int k = 0; k < height - 1; k++) {
							if (Collision.playerGate(
									new Point(iX + (int) State.xOffset - 1, iY + (int) State.yOffset + k),
									endGate[i][j])) {
								if (hasKey)
									win = true;

							}
						}

						// TOP
						for (int k = 0; k < width - 2; k++) {
							if (Collision.playerGate(new Point(iX + (int) State.xOffset + k, iY + (int) State.yOffset),
									endGate[i][j])) {
								if (hasKey)
									win = true;
							}
						}
						// BOTTOM
						for (int k = 0; k < width - 8; k++) {
							if (Collision.playerGate(
									new Point(iX + (int) State.xOffset + k, iY + height + (int) State.yOffset + 1),
									endGate[i][j])) {
								if (hasKey)
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
					if (key[i][j].getID() == 3) {

						// RIGHT
						for (int k = 0; k <= height; k++) {
							if (Collision.playerKey(
									new Point(iX + width + (int) State.xOffset + 5, iY + (int) State.yOffset + k - 1),
									key[i][j])) {
								key[i][j].setID(0);
								hasKey = true;
							}
						}

						// LEFT
						for (int k = 0; k < height; k++) {
							if (Collision.playerKey(
									new Point(iX + (int) State.xOffset - 5, iY + (int) State.yOffset + k), key[i][j])) {
								key[i][j].setID(0);
								hasKey = true;
							}
						}

						// TOP
						for (int k = 0; k < width - 2; k++) {
							if (Collision.playerKey(new Point(iX + (int) State.xOffset + k, iY + (int) State.yOffset),
									key[i][j])) {
								key[i][j].setID(0);
								hasKey = true;
							}
						}
						// BOTTOM
						for (int k = 0; k < width - 8; k++) {
							if (Collision.playerKey(
									new Point(iX + (int) State.xOffset + k, iY + height + (int) State.yOffset + 1),
									key[i][j])) {
								key[i][j].setID(0);
								hasKey = true;
							}
						}
					}
				}
			}
			topCollision = false;
		}

		/*
		 * Movement Mechanics (temporary)
		 */
		if (right) {
			State.xOffset += moveSpeed;
		}
		if (left) {
			State.xOffset -= moveSpeed;
		}

		if (FacingRight && !right && !jumping && !falling) {
			maxFrames = playerAnimation.getSize("RI") - 1;
		}

		if (FacingLeft && !left && !jumping && !falling) {
			maxFrames = playerAnimation.getSize("LI") - 1;
		}
		if (right && !jumping && !falling) {
			maxFrames = playerAnimation.getSize("RR") - 1;
		}
		if (left && !jumping && !falling) {
			maxFrames = playerAnimation.getSize("LR") - 1;
		}

		/*
		 * Jumping/Falling Mechanics
		 */
		if (jumping)
			jump();
		else
			fall();

	}

	/*
	 * PLAYER RENDER
	 */
	public void render(Graphics2D g) {
		// character animations

		if (FacingRight && !right && !jumping && !falling) {
			g.drawImage(playerAnimation.getPlayerRightIdle(frameCount), (int) x, (int) y, null);
		}
		if (FacingLeft && !left && !jumping && !falling) {
			g.drawImage(playerAnimation.getPlayerLeftIdle(frameCount), (int) x, (int) y, null);
		}
		if (right && !jumping && !falling) {
			if (frameCount >= 6)
				frameCount = playerAnimation.getSize("RR") - 1;
			g.drawImage(playerAnimation.getPlayerRightRunning(frameCount), (int) x, (int) y, null);
		}
		if (left && !jumping && !falling) {
			if (frameCount >= 6)
				frameCount = playerAnimation.getSize("LR") - 1;
			g.drawImage(playerAnimation.getPlayerLeftRunning(frameCount), (int) x, (int) y, null);
		}
		if (jumping == true | falling == true) {
			if (FacingRight) {
				// if(frameCount>=6)
				// frameCount=RightJumping.size()-1;
				// g.drawImage(RightJumping.get(frameCount), (int) x, (int) y,
				// null);
				g.drawImage(playerAnimation.getPlayerRightJumping(frameCount), (int) x, (int) y, null);
			}
			if (FacingLeft) {
				// if(frameCount>=6)
				// frameCount=LeftJumping.size()-1;
				g.drawImage(playerAnimation.getPlayerLeftJumping(frameCount), (int) x, (int) y, null);
			}
		}
	}

	ActionListener AnimTimer = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (frameCount >= maxFrames) {
				frameCount = 0;
			} else {
				frameCount++;
			}

		}
	};

	/*
	 * KEY EVENTS
	 */
	public void keyPressed(int k) {					
		
		if(k==KeyEvent.VK_Y){						//WAS TRYING TO TEST
				System.out.println("Scale is 2");	//IF I CAN RESIZE+RESCALE JFRAME
		}else if(k == KeyEvent.VK_U){				//WITHIN THE GAME
				GamePanel.setSCALE(1);				//...SCALES BUT DONT KNOW HOW TO
				System.out.println("Scale is 1");	//RESIZE JFARME
		}
		
		if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) { // go right pressed
			if (noclip) {
				State.xOffset += noclipSpeed;
			} else {
				left = false;
				right = true;
				FacingLeft = false;
				FacingRight = true;
			}
		}

		if (k == KeyEvent.VK_T) { // debug monitor toggle
			debugMonitor = !debugMonitor;
		}

		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) { // go left pressed
			if (noclip) {
				State.xOffset -= noclipSpeed;
			} else {
				right = false;
				left = true;
				FacingRight = false;
				FacingLeft = true;
			}

		}

		if ((k == KeyEvent.VK_W || k == KeyEvent.VK_UP) && !jumping && !falling) { // jump
																					// pressed
			if (noclip) {
				State.yOffset -= noclipSpeed;
			} else {
				jumping = true;
				jump();
			}

		}
		if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
			if (noclip) {
				State.yOffset += noclipSpeed;
			} else {

			}
		}
		if (k == KeyEvent.VK_N) {
			falling = false;
			jumping = false;
			noclip = !noclip;
		}

	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {// go right released
			right = false;
			frameCount = 0;

		}
		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) { // go left released
			left = false;
			frameCount = 0;

		}
	}

	public void jump() {
		if (jumping) {
			State.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= .25;
			falling = false;

			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = maxJumpSpeed;
				jumping = false;
				falling = true;
			}
		}
	}

	public void fall() {
		if (falling) {
			State.yOffset += currentFallSpeed;
			if (currentFallSpeed <= maxFallSpeed) {
				currentFallSpeed += 0.25;

			}
		}

		if (!falling) {
			currentFallSpeed = .1;
		}
	}

	public void renderHitbox(Graphics2D g) {
		g.fillRect((int) x, (int) y, width, height);
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

	public int getAnimFrame() {
		return frameCount;
	}

	public int getAnimFrameMax() {
		return maxFrames;
	}

	public Timer getTimer() {
		return timer;
	}

	public PlayerAnimation getPlayerAnim() {
		return playerAnimation;
	}

}

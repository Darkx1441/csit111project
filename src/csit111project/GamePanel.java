package csit111project;

import javax.swing.JPanel;

import gamestate.GameStateManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements Runnable, ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;

	// dimensions
	// Frame will be x+6 y+29 bigger because it includes border
<<<<<<< HEAD
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final static double WIDTH = 800;
	private final static double HEIGHT = 480;
	private static int SCALE = 2;
=======
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	private int SCALE=1;
>>>>>>> origin/master
	FPSCounter fps = new FPSCounter();

	private Thread thread;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	boolean running = false;
	private GameStateManager gsm;

	public GamePanel() {
		super();
		
		if (screenSize.getWidth() > 1920) {  	
			SCALE = 2;							
		} else {								
			SCALE = 1;							
		}
		setPreferredSize(new Dimension((int) WIDTH * SCALE, (int) HEIGHT * SCALE));
		addKeyListener(this);
		setBackground(Color.black);
		setFocusable(true);
		requestFocus();

		gsm = new GameStateManager(GameStateManager.MENUSTATE);
		start();
	}

	private void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
		fps.start();
	}

	private void update() {
		gsm.update();
	}

	public void run() {
		long start, elapsed, wait;

		while (running) {
			start = System.nanoTime();
			update();
			repaint();
			fps.interrupt();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

			if (wait <= 0) {
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(SCALE, SCALE);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);
		g2.drawString("FPS:" + (int) fps.fps(), 0, 43);
		gsm.render(g2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e, e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e, e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public int getFPS() {
		return (int) fps.fps();
	}
	
	public static void setSCALE(int s){
		SCALE=s;
	}
	
	public int getSCALE(){
		return SCALE;
	}

	public static int getScreenWidth() {
		return (int) WIDTH;
	}

	public static int getScreenHeight() {
		return (int) HEIGHT;
	}
}

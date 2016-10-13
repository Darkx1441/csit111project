package csit111project;

import javax.swing.JPanel;

import gamestate.GameStateManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements Runnable, ActionListener, KeyListener, MouseListener 
{
	private static final long serialVersionUID = 1L;

	// dimensions
	// Frame will be x+6 y+29 bigger because it includes border
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	FPSCounter fps = new FPSCounter();

	private Thread thread;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	boolean running = false;
	private GameStateManager gsm;

	public GamePanel() 
	{
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addMouseListener(this);
		addKeyListener(this);
		setBackground(Color.black);
		setFocusable(true);
		requestFocus();

		gsm = new GameStateManager(GameStateManager.PLAYSTATE);
		start();
	}

	private void start() 
	{
		running = true;
		thread = new Thread(this);
		thread.start();
		fps.start();
	}

	private void update() 
	{
		gsm.update();
	}

	public void run() 
	{
		long start, elapsed, wait;
		
		while (running) 
		{
			start = System.nanoTime();
			update();
			repaint();
			fps.interrupt();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

			if (wait <= 0) 
			{
				wait = 5;
			}
			try 
			{
				Thread.sleep(wait);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}

		}

	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		gsm.render(g2);
		g2.drawString("FPS:" + (int)fps.fps(), 0, 43);

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		update();
		repaint();	
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		gsm.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		gsm.mouseReleased(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		gsm.keyPressed(e, e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		gsm.keyResealed(e, e.getKeyCode());
	}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}

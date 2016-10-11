package csit111project;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener 
{
	//Default serial version ID
	private static final long serialVersionUID = 1L;

	//dimensions
	//Frame will be x+6 y+29 bigger because it includes borde
	
	
	
	BufferedImage img;
	private Timer timer;
	private GameStateManager gsm;
	
	public GamePanel()
	{
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addMouseListener(this);
		addKeyListener(this);
		setBackground(Color.black);
		setFocusable(true);
		requestFocus();
		
		gsm = new GameStateManager(GameStateManager.PLAYSTATE);
		timer = new Timer(30, this); //game fps
		timer.start();
//		init();
	}

//	private void init(){
//		try{
//			img= ImageIO.read(getClass().getResourceAsStream("/images/Splitlevel.png"));
//		} catch (IOException e){
//			e.printStackTrace();
//			}
//	}
	
	private void update(){
		gsm.update();
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		gsm.render(g2);

	}
	

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gsm.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		gsm.mouseReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e, e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyResealed(e, e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}


}

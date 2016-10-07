package csit111project;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class GamePanel extends JPanel 
{
	//Default serial version ID
	private static final long serialVersionUID = 1L;

	//dimensions
	//Frame will be x+6 y+29 bigger because it includes border
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	
	BufferedImage img;
	boolean running;
	
	public GamePanel()
	{
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		init();
	}

	private void init(){
		try{
			img= ImageIO.read(getClass().getResourceAsStream("/images/Splitlevel.png"));
		} catch (IOException e){
			e.printStackTrace();
			}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		
		//set font
		Font myFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
		g.setFont(myFont);	
		//calc center of the screen
		int centerPanelX = WIDTH / 2;
		int centerPanelY = HEIGHT / 2;

		if (img!=null){
			g.drawImage(img, 0, 0, null);
		}
		
		
		
		
		

		
		
		
		g.drawLine(centerPanelX, 0, centerPanelX, HEIGHT);
		g.drawLine(0, centerPanelY, WIDTH, centerPanelY);
	
		
	}
}

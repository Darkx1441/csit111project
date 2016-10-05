package csit111project;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
	//Default serial version ID
	private static final long serialVersionUID = 1L;

	//dimensions
	//Frame will be x+6 y+29 bigger because it includes border
	public static final int WIDTH=800;
	public static final int HEIGHT=480;
	
	public GamePanel(){
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("HELLO", WIDTH/2, HEIGHT/2); //not accurately centered
		
		/*
		 * Re-drawing accurately centered string
		 */
		g.setColor(Color.RED);
		
		//get rectangle bounds of text
		FontMetrics metrics=g.getFontMetrics();
		Rectangle2D strRect=metrics.getStringBounds("HELLO", g);
		
		//calc center of the screen
		int centerPanelX= WIDTH/2;
		int centerPanelY= HEIGHT/2;
		
		//Calc starting point of centered string
		int strX=centerPanelX-(int)(strRect.getWidth()/2);
		int strY=centerPanelY-(int)(strRect.getHeight()/2);
		
		//draw centered string
		g.drawString("HELLO", strX, strY);
	}
	

}

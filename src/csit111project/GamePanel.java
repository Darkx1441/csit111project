package csit111project;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;

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
		//g.drawString("HELLO", WIDTH/2, HEIGHT/2); //not accurately centered
		
		/*
		 * Re-drawing accurately centered string
		 * and graph center lines
		 */
		g.setColor(Color.RED);
		
		//set font
		Font myFont=new Font(Font.SANS_SERIF, Font.BOLD, 30);
		g.setFont(myFont);
		
		//get rectangle bounds of text
		FontMetrics metrics=g.getFontMetrics();
		Rectangle2D strRect=metrics.getStringBounds("HELLO", g);
		
		//calc center of the screen
		int centerPanelX= WIDTH/2;
		int centerPanelY= HEIGHT/2;
		
		//Calc starting point of centered string
		int strX=centerPanelX-(int)(strRect.getWidth()/2);
		int strY=centerPanelY+(int)(strRect.getHeight()/2);
		
		//draw centered string
		//g.drawString("HELLO", strX, strY);
	
		g.drawLine(centerPanelX, 0, centerPanelX, HEIGHT);
		g.drawLine(0, centerPanelY, WIDTH, centerPanelY);
	
		/*
		 * Star Field
		 */
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Random r= new Random();
		Color randomColor=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
		g.setColor(randomColor);
		for(int i=0;i<3000;i++){
			int x = Math.abs(r.nextInt()%WIDTH);
			int y = Math.abs(Math.abs(r.nextInt()%HEIGHT));
			System.out.println("x: "+x+"/ty:"+y);
			g.drawLine(x, y, x, y);
			
		}
	
	}
	

}

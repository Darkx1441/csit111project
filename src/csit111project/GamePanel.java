package csit111project;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {

	//dimensions
	public static final int WIDTH=1280;
	public static final int HEIGHT=720;
	
	public GamePanel(){
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("HIIIIII", 500, 500);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

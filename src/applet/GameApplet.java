package applet;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JApplet;
import csit111project.GamePanel;

public class GameApplet extends JApplet 
{
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;

	public void init() 
	{
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		gamePanel = new GamePanel();
		pane.add(gamePanel);
		this.setSize(GamePanel.getScreenWidth(), GamePanel.getScreenHeight());
	}

}

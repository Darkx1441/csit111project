package csit111project;

import javax.swing.*;
import java.awt.*;

public class animation 
{
	JFrame frame;
	DrawPanel drawPanel;

	private int oneX = 300;
	private int oneY = 150;
	private int speed= 1; 	// animation speed scale

	boolean up = false;
	boolean down = true;
	boolean left = false;
	boolean right = true;

	public static void main(String[] args) 
	{
		new animation().run();
	}

	private void run() 
	{
		frame = new JFrame("Animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null); // centers the window
		
		move();
	}

	class DrawPanel extends JPanel 
	{
		public void paintComponent(Graphics g) 
		{
			g.setColor(Color.gray);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.WHITE);
			g.fillRect(3, 3, this.getWidth() - 6, this.getHeight() - 6);
			g.setColor(Color.BLACK);
			g.fillRect(oneX, oneY, 50, 50);
		}
	}

	private void move() 
	{
		while (true) 
		{
			if (oneX >= 1280 - 50 - 3) 
			{
				right = false;
				left = true;
			}
			
			if (oneX <= 3) 
			{
				right = true;
				left = false;
			}
			
			if (oneY >= 720 - 100 - 6) 
			{
				up = true;
				down = false;
			}
			
			if (oneY <= 3) 
			{
				up = false;
				down = true;
			}
			
			if (up)
			{
				oneY -= 1 * speed;
			}
			
			if (down)
			{
				oneY += 1 * speed;
			}
			
			if (left)
			{
				oneX -= 1 * speed;
			}
			
			if (right)
			{
				oneX += 1 * speed;
			}
			
			try 
			{
				Thread.sleep(3);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			frame.repaint();
		}
	}
}

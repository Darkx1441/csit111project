package csit111project;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Game 
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame("CALCULATOR IS FOR NOOBS");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		// System.out.println(window.getWidth()+" "+window.getHeight());
	}
}

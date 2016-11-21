package csit111project;
import javax.swing.JFrame;

public class Game
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame("Kevin's a Bitch");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setUndecorated(true); //on-off remove title, scroll bars etc
		window.setVisible(true);
		window.pack();
		window.setLocationRelativeTo(null);
		// System.out.println(window.getWidth()+" "+window.getHeight());
	}
}

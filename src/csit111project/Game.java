/*
 * Planrun
 * Written by Cristian Novac and Sammy Samcough
 * Art by Ryan Hoyt and Greg Ursitti
 * 
 * Key Layout:
 * 		Movement: W(Jump) A(Left) D(Right)
 *  	Menu selection: ArrowKeys or W/S,  Space/Enter
 *  	Other: 	Escape = menu/quit
 *  			N = toggle noclip
 *  			T = toggle show hitboxes
 */

package csit111project;
import javax.swing.JFrame;

public class Game
{
	public static void main(String[] args) 
	{
		JFrame window = new JFrame("Das Game");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setUndecorated(false); //on-off remove app window frame.
		window.setVisible(true);
		window.pack();
		window.setLocationRelativeTo(null);
	}
}

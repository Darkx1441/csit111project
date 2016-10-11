package csit111project;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public static int width = 800;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "game");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("CALCULATOR IS FOR NOOBS");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setUndecorated(false); // on-off remove title, scroll bars etc
		window.setVisible(true);
		window.pack();
		window.setLocationRelativeTo(null);
		// System.out.println(window.getWidth()+" "+window.getHeight());
	}

	@Override
	public void run() {
		while (running) {

		}

	}
}

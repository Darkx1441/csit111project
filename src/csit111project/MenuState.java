package csit111project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MenuState extends State {

	private String[] options = { "Play", "Options", "Quit" };
	private int currentSelect = 0;

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics2D g) {
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelect) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.WHITE);
			}
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString(options[i], GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2 - 100 + i * 50);
		}

	}

	@Override
	public void keyPressed(KeyEvent e, int k) {
		if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
			if (currentSelect < options.length - 1) {
				currentSelect += 1;
			} else {
				currentSelect = options.length - 1;
			}
		} else if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
			if (currentSelect > 0) {
				currentSelect -= 1;
			} else {
				currentSelect = 0;
			}
		}
		if (k == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE) {
			if (currentSelect == 0) {
				// play
			} else if (currentSelect == 1) {
				// options
			} else if (currentSelect == 2) {
				// quit
				System.exit(0);
			}
		}

	}

	@Override
	public void keyResealed(KeyEvent e, int k) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
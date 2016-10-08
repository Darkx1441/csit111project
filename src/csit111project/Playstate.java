package csit111project;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playstate extends State {

	public Playstate(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.drawLine(400, 0, 400, 800);
		g.drawLine(0, 240, 800, 240);	
	}

	@Override
	public void keyPressed(KeyEvent e, int k) {

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

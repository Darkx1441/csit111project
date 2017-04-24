package gamestate;

import javax.swing.Timer;

import entities.Player;
import mapping.Map;

public abstract class Level extends State{
	
	int stateid;
	private Player player;
	private Map map;
	
	Timer timer;
	final int timerDelay = 1000/5;
	
	private int color =1;
	
	double BGParraX = .90;
	double FGParra = 1.35;
	
	public Level(GameStateManager gsm) {
		super(gsm);
		timer = new Timer(timerDelay, timerAction);
	}
	
}

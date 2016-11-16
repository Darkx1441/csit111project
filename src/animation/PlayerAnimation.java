package animation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Player;

public class PlayerAnimation {
	
	static BufferedImage RightI01, RightI02, RightI03, RightI04, RightI05, RightI06, RightI07;
	static BufferedImage RightR01, RightR02, RightR03, RightR04, RightR05, RightR06;
	static BufferedImage RightJ01;

	static BufferedImage LeftI01, LeftI02, LeftI03, LeftI04, LeftI05, LeftI06, LeftI07;
	static BufferedImage LeftR01, LeftR02, LeftR03, LeftR04, LeftR05, LeftR06;
	static BufferedImage LeftJ01;
	
	static BufferedImage Trap1;
	static BufferedImage Turret1;
	
	static ArrayList <BufferedImage> RightIdle  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> RightRunning  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> LeftIdle  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> LeftRunning  = new ArrayList<BufferedImage>();

	public PlayerAnimation(){
		init();
	}
	public void init(){
		try {
			System.out.println("Importing Player Images...");
			RightI01 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle01.png"));
			RightI02 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle02.png"));
			RightI03 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle03.png"));
			RightI04 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle04.png"));
			RightI05 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle05.png"));
			RightI06 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle06.png"));
			RightI07 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle07.png"));
			
			LeftI01 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle01L.png"));
			LeftI02 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle02L.png"));
			LeftI03 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle03L.png"));
			LeftI04 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle04L.png"));
			LeftI05 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle05L.png"));
			LeftI06 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle06L.png"));
			LeftI07 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharIdle07L.png"));
			
			RightR01 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/right/CharRun01.png"));
			RightR02 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/right/CharRun02.png"));
			RightR03 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/right/CharRun03.png"));
			RightR04 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/right/CharRun04.png"));
			RightR05 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/right/CharRun05.png"));
			RightR06 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/right/CharRun06.png"));
			
			LeftR01 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/left/CharRun01L.png"));
			LeftR02 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/left/CharRun02L.png"));
			LeftR03 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/left/CharRun03L.png"));
			LeftR04 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/left/CharRun04L.png"));
			LeftR05 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/left/CharRun05L.png"));
			LeftR06 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/run/left/CharRun06L.png"));
	
			LeftJ01 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/left/CharLJump01.png"));
			RightJ01 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Charassets/actions/idle/right/CharJump01.png"));
			System.out.println("Player Images Imported");
		} catch (IOException e) {
		}
		System.out.println("Loading Player Images...");
		RightIdle.add(RightI01);
		RightIdle.add(RightI02);	
		RightIdle.add(RightI03);
		RightIdle.add(RightI04);
		RightIdle.add(RightI05);
		RightIdle.add(RightI06);
		RightIdle.add(RightI07);
		
		RightRunning.add(RightR01);
		RightRunning.add(RightR02);
		RightRunning.add(RightR03);
		RightRunning.add(RightR04);
		RightRunning.add(RightR05);
		RightRunning.add(RightR06);
		
		LeftRunning.add(LeftR01);
		LeftRunning.add(LeftR02);
		LeftRunning.add(LeftR03);
		LeftRunning.add(LeftR04);
		LeftRunning.add(LeftR05);
		LeftRunning.add(LeftR06);
		
		LeftIdle.add(LeftI01);
		LeftIdle.add(LeftI02);
		LeftIdle.add(LeftI03);
		LeftIdle.add(LeftI04);
		LeftIdle.add(LeftI05);
		LeftIdle.add(LeftI06);
		LeftIdle.add(LeftI07);
		System.out.println("Player Images Loaded");
	}
	
	public BufferedImage getPlayerRightIdle(int i){
		return RightIdle.get(i);
	}
	public BufferedImage getPlayerRightRunning(int i){
		return RightRunning.get(i);
	}
	public BufferedImage getPlayerRightJumping(int i){
		return RightJ01;
	}
	public BufferedImage getPlayerLeftIdle(int i){
		return LeftIdle.get(i);
	}
	public BufferedImage getPlayerLeftRunning(int i){
		return LeftRunning.get(i);	
	}
	public BufferedImage getPlayerLeftJumping(int i){
		return LeftJ01;
	}
	
	public int getSize(String s){
		if(s=="RI")
			return RightIdle.size();
		else if(s=="RR")
			return RightRunning.size();
		else if(s=="LI")
			return LeftIdle.size();
		else if(s=="LR")
			return LeftRunning.size();
		else
			return 0;
	}
	
	
}

package animation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PlayerAnim {
	BufferedImage RightI01, RightI02, RightI03, RightI04, RightI05, RightI06, RightI07, LeftI01, RightJ01, LeftJ01;
	BufferedImage  RightR01, RightR02, RightR03, RightR04, RightR05, RightR06, LeftR01;
	ArrayList <BufferedImage> RightIdle  = new ArrayList<BufferedImage>();
	ArrayList <BufferedImage> RightRunning  = new ArrayList<BufferedImage>();
	
	public PlayerAnim(){
		init();
	}
	
	public void init() {
		try {
		RightI01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle01.png"));
		RightI02 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle02.png"));
		RightI03 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle03.png"));
		RightI04 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle04.png"));
		RightI05 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle05.png"));
		RightI06 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle06.png"));
		RightI07 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharIdle07.png"));
		
		RightR01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun01.png"));
		RightR02 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun02.png"));
		RightR03 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun03.png"));
		RightR04 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun04.png"));
		RightR05 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun05.png"));
		RightR06 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun06.png"));
		
		LeftI01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/left/CharLIdle01.png"));
		RightR01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/run/right/CharRun01.png"));
		LeftR01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/left/CharLRun01.png"));
		LeftJ01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/left/CharLJump01.png"));
		RightJ01 = ImageIO
				.read(getClass().getResourceAsStream("/images/Charassets/actions/idle/right/CharJump01.png"));

	} catch (IOException e) {
	}
	
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
	
	}
	
	public int getRightRunningSize(){
		return RightRunning.size();
	}
	public int getRightIdleSize(){
		return RightIdle.size();
	}
	
	public BufferedImage getImage(String s, int n){
		if(s.equals("RI")){
		return (BufferedImage) RightIdle.get(n);
		}else if(s.equals("RR")){
			return(BufferedImage) RightRunning.get(n);
		}else if(s.equals("LI")){
			return (BufferedImage) LeftI01;
		}else if(s.equals("LR")){
			return (BufferedImage) LeftR01;
		}else if(s.equals("LJ")){
			return (BufferedImage) LeftJ01;
		}else if(s.equals("RJ")){
			return (BufferedImage) RightJ01;
		}
		
		else{
			return RightJ01;
		}
		
	}
}
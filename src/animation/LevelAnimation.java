package animation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Player;
import mapping.Map;

public class LevelAnimation {
	
	static BufferedImage Ground1;
	static BufferedImage Key1;
	static BufferedImage EndGate1;
	static BufferedImage BackGround1;
	static BufferedImage ForeGround1;
	static BufferedImage MidGround1;
	
	
	static ArrayList <BufferedImage> Ground  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> Key = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> EndGate  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> BackGround  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> ForeGround  = new ArrayList<BufferedImage>();
	
	private int mapHeight;
	private int mapWidth;
	public LevelAnimation(Map map){
		mapHeight= map.getMapHeight();
		mapWidth = map.getMapWidth();
	}
	
	int Wfactor = 1;
	int Hfactor = 1;
	
	public void init(){
		try {
			System.out.println("Importing Level Images...");
			Ground1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Levelassets/ground/ground1.png"));
			Key1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Levelassets/key/Key.png"));
			EndGate1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Levelassets/endgate/endgate1.png"));
			BackGround1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/BackgroundBG.png"));
			MidGround1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/MidgroundBG.png"));
			ForeGround1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/FGTEST.png"));
			System.out.println("Level Images Imported");

		} catch (IOException e) {
		}
		System.out.println("Loading Level Images...");
		
		Ground.add(Ground1);
		
		Key.add(Key1);
		
		EndGate.add(EndGate1);
		
		BackGround.add(BackGround1);
		BackGround.add(MidGround1);
		
		ForeGround.add(ForeGround1);
		
		System.out.println("Level Images Loaded");
		System.out.println("Map height= "+mapHeight+" width= "+mapWidth);
	}
	
	public BufferedImage getGround(int i){
		return Ground1;
	}
	public BufferedImage getKey(int i){
		return Key1;
	}
	public BufferedImage getEndGate(int i){
		return EndGate1;
	}
	
	public BufferedImage getBackGround(int i){
		return BackGround.get(i);
	}
	
	public BufferedImage getForeGround(int i){
		return ForeGround1;
	}
	
	public int getWidthFactor(int w){
		return ((mapWidth*32)/w)-1;
		
	}
	
	public int getHeightFactor(int h){
		//System.out.println((mapHeight*32)/h);
		return ((mapHeight*32)/h)-1;
		
	}
	
	public int getSize(String s){
		if(s=="GND")
			return Ground.size();
		else if(s=="KEY")
			return Key.size();
		else if(s=="EG")
			return EndGate.size();
		else
			return 0;
	}	
	
	public void clearAnim(){
		Ground.clear();
		Key.clear();
		EndGate.clear();
	}

}

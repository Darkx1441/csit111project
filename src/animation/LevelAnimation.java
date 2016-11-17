package animation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Player;

public class LevelAnimation {
	
	static BufferedImage Ground1;
	static BufferedImage Key1;
	static BufferedImage EndGate1;
	static BufferedImage BackGround1;
	static BufferedImage ForeGround1;
	
	
	static ArrayList <BufferedImage> Ground  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> Key = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> EndGate  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> BackGround  = new ArrayList<BufferedImage>();
	static ArrayList <BufferedImage> ForeGround  = new ArrayList<BufferedImage>();
	
	
	public void init(){
		try {
			System.out.println("Importing Level Images...");
			Ground1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Levelassets/ground/ground1.png"));
			Key1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Levelassets/key/key1.png"));
			EndGate1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/Levelassets/endgate/endgate1.png"));
			BackGround1 = ImageIO
					.read(Player.class.getResourceAsStream("/images/BGTEST.png"));
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
		
		ForeGround.add(ForeGround1);
		
		System.out.println("Level Images Loaded");
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
		return BackGround1;
	}
	
	public BufferedImage getForeGround(int i){
		return ForeGround1;
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

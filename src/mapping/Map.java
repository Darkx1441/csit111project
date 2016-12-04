package mapping;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.Timer;

import animation.LevelAnimation;
import objects.Block;
import objects.EndGate;
import objects.Key;

public class Map {

	private String path;
	private Timer timer;
	private int currentFrame=0;
	private int maxFrames;
	private int width, height;
	
	private Block[][] blocks;
	private EndGate[][] endGate;
	private Key[][] key;
	
	public Map(String loadpath, Timer ntimer){
		setTimer(ntimer);
		path= loadpath;

		loadMap();
	}
	
	public void render(Graphics2D g, LevelAnimation animation){
		for(int i =0;i<blocks.length;i++){
			for(int j=0;j<blocks[0].length;j++){
				//blocks[i][j].render(g,currentFrame, animation);
				//endGate[i][j].render(g, currentFrame, animation);
				key[i][j].render(g, currentFrame, animation);
				
			}
		}
	}
	
	public void renderHitbox(Graphics2D g){
		for(int i =0;i<blocks.length;i++){
			for(int j=0;j<blocks[0].length;j++){
				blocks[i][j].renderHitbox(g);
				endGate[i][j].renderHitbox(g);
				key[i][j].renderHitbox(g);
				
			}
		}
	}
	
	public void loadMap(){
		InputStream is= this.getClass().getResourceAsStream(path);
		BufferedReader br= new BufferedReader(new InputStreamReader(is));
		
		try {
			width= Integer.parseInt(br.readLine());
			height= Integer.parseInt(br.readLine());
			
			blocks= new Block[height][width];
			endGate = new EndGate[height][width];
			key= new Key[height][width];
			
			for(int y=0;y<height;y++){
				String line = br.readLine();
				String[] tokens = line.split("\\s+");				
				for(int x=0;x<width;x++){
					blocks[y][x] = new Block(x*Block.blocksize, y*Block.blocksize, Integer.parseInt(tokens[x]));
					endGate[y][x] = new EndGate(x*EndGate.blocksize, y*EndGate.blocksize, Integer.parseInt(tokens[x]));
					key[y][x] = new Key(x*Key.blocksize, y*Key.blocksize, Integer.parseInt(tokens[x]));

				}
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	ActionListener timerAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (currentFrame >= maxFrames){
				currentFrame=0;
			}else{
				currentFrame++;
			}
			
		}
	};
	
	
	public Block[][] getBlocks(){
		return blocks;
	}
	public int getMapWidth(){
		return blocks[0].length;
	}
	public int getMapHeight(){
		return blocks.length;
	}
	
	public EndGate[][] getEndGate(){
		return endGate;
	}
	public Key[][] getKey(){
		return key;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
}

package mapping;

import java.awt.Graphics2D;

import objects.Block;

public class Map {

	private String path;
	private int width, height;
	
	private Block[][] blocks;
	
	public Map(String loadpath, int width, int height){
		path= loadpath;
		this.width=width;
		this.height=height;
		
		blocks= new Block[height][width];
		
		for(int i =0;i<blocks.length;i++){
			for(int j=0;j<blocks[0].length;j++){
				blocks[i][j]=new Block(j*Block.blocksize, i* Block.blocksize);
			}
		}
	}
	
	public void render(Graphics2D g){
		for(int i =0;i<blocks.length;i++){
			for(int j=0;j<blocks[0].length;j++){
				blocks[i][j].render(g);
			}
		}
	}
	
}

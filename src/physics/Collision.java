package physics;

import java.awt.Point;

import objects.Block;
import objects.EndGate;
import objects.Key;

public class Collision 
{
	public static boolean playerBlock(Point p, Block b)
	{
		return b.contains(p);
	}
	
	public static boolean playerGate(Point p, EndGate e){
		return e.contains(p);
	}
	public static boolean playerKey(Point p , Key key){
		return key.contains(p);
	}
}

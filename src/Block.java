
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Block extends Rectangle {
	
	
	private static final long serialVersionUID = 1L;
	public static final int blockSize = 64;
	
	private int id;
	
	public Block(int x, int y, int id){
		setBounds(x,y, blockSize, blockSize);
		this.id = id;
		
		
	}
	
	public void tick(){
		
		
	}
	public void draw(Graphics g){
		if(id != 0){
			g.setColor(Color.BLACK);
			g.fillRect(x - (int)GameState.xOffSet,y - (int)GameState.yOffSet, width, height);
		}
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public int changeID(){
		return 0;
	}
}

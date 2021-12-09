import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Images {
	
	public static BufferedImage[] blocks;
	public static BufferedImage[] selectIMG ;
	public static BufferedImage[] playerIMG ;
	public static BufferedImage[] player2IMG ;
	
	public Images(){
		selectIMG = new BufferedImage[4];
		playerIMG = new BufferedImage[12];
		player2IMG = new BufferedImage[12];
		if(CharacterSelectState.b){
			playerIMG = new BufferedImage[14];
		}
		if(CharacterSelectState.bb){
			player2IMG = new BufferedImage[14];
		}
		
		
		try {
			selectIMG[0] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu P1.gif"));
			selectIMG[1] = ImageIO.read(this.getClass().getResourceAsStream("/Ken P1.gif"));
			selectIMG[2] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu P2.gif"));
			selectIMG[3] = ImageIO.read(this.getClass().getResourceAsStream("/Ken P2.gif"));
			
			playerIMG[0] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu walk(1).png"));
			playerIMG[1] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu walk(2).png"));
			playerIMG[2] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu walk(3).png"));
			
			playerIMG[3] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu jump.png"));
			
			playerIMG[4] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu block1.png"));
			
			playerIMG[5] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu light1.png"));
			
			playerIMG[7] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu heavy1.png"));
			playerIMG[6] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu heavy1(2).png"));
			
			playerIMG[8] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu ult1.png"));
			playerIMG[9] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu ult1(2).png"));
			
			playerIMG[10] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu jump attack1.png"));
			
			playerIMG[11] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu jumpheavy1.png"));
			
			
			player2IMG[0] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu walk(1)2.png"));
			player2IMG[1] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu walk(2)2.png"));
			player2IMG[2] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu walk(3)2.png"));
			player2IMG[3] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu jump2.png"));
			player2IMG[4] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu block2.png"));
			player2IMG[5] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu light2.png"));
			player2IMG[7] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu heavy2.png"));
			player2IMG[6] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu heavy2(2).png"));
			player2IMG[8] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu ult2.png"));
			player2IMG[9] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu ult2(2).png"));
			player2IMG[10] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu jump attack2.png"));
			player2IMG[11] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu jumpheavy2.png"));
			
			if(CharacterSelectState.b){
				playerIMG[0] = ImageIO.read(this.getClass().getResourceAsStream("/Ken(1).png"));
				playerIMG[1] = ImageIO.read(this.getClass().getResourceAsStream("/Ken walking(1).png"));
				playerIMG[2] = ImageIO.read(this.getClass().getResourceAsStream("/Ken walking(2).png"));
				playerIMG[3] = ImageIO.read(this.getClass().getResourceAsStream("/Ken jumping.png"));
				playerIMG[4] = ImageIO.read(this.getClass().getResourceAsStream("/Ken block.png"));
				playerIMG[5] = ImageIO.read(this.getClass().getResourceAsStream("/Ken light.png"));
				playerIMG[7] = ImageIO.read(this.getClass().getResourceAsStream("/Ken heavy.png"));
				playerIMG[6] = ImageIO.read(this.getClass().getResourceAsStream("/Ken heavy (2).png"));
				playerIMG[8] = ImageIO.read(this.getClass().getResourceAsStream("/Ken ult.png"));
				playerIMG[9] = ImageIO.read(this.getClass().getResourceAsStream("/Ken ult (2).png"));
				playerIMG[10] = ImageIO.read(this.getClass().getResourceAsStream("/Ken jumplight.png"));
				playerIMG[11] = ImageIO.read(this.getClass().getResourceAsStream("/Ken jump heavy.png"));
			}
			if(CharacterSelectState.bb){
				player2IMG[0] = ImageIO.read(this.getClass().getResourceAsStream("/Ken(2).png"));
				player2IMG[1] = ImageIO.read(this.getClass().getResourceAsStream("/Ken walking2(1).png"));
				player2IMG[2] = ImageIO.read(this.getClass().getResourceAsStream("/Ken walking2(2).png"));
				player2IMG[3] = ImageIO.read(this.getClass().getResourceAsStream("/Ken jumping2.png"));
				player2IMG[4] = ImageIO.read(this.getClass().getResourceAsStream("/Ken block2.png"));
				player2IMG[5] = ImageIO.read(this.getClass().getResourceAsStream("/Ken light2.png"));
				player2IMG[7] = ImageIO.read(this.getClass().getResourceAsStream("/Ken heavy2.png"));
				player2IMG[6] = ImageIO.read(this.getClass().getResourceAsStream("/Ken heavy2 (2).png"));
				player2IMG[8] = ImageIO.read(this.getClass().getResourceAsStream("/Ken ult2.png"));
				player2IMG[9] = ImageIO.read(this.getClass().getResourceAsStream("/Ken ult2 (2).png"));
				player2IMG[10] = ImageIO.read(this.getClass().getResourceAsStream("/Ken jumplight2.png"));
				player2IMG[11] = ImageIO.read(this.getClass().getResourceAsStream("/Ken jump heavy2.png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


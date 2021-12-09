import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class CharacterSelectState extends GameState{

	private String[] options = {"RYU","KEN","Back"};
	private String[] options2 = {"RYU","KEN","Back"};
	private int currentSelection = 0;
	private int currentSelection2 = 0;
	private Character[] chara = new Character[4];
	public static boolean b= false;
	public static boolean bb = false;
	
	public CharacterSelectState(GameStateManager gsm) {
		super(gsm);
		BufferedImage[] arr = set2();
		
		chara[0] = new Ryu("/Ryu1.png",arr[0]); 
		chara[1] = new Ken("/Ken.png",arr[1]); 
		chara[2] = new Ryu("/Ryu2.png",arr[2]); 
		chara[3] = new Ken("/Ken2.png",arr[3]); 
		
	}


	public void init() {
	
	
	}


	public void tick() {
	
	
	}
	
	public BufferedImage set(Graphics g){
		BufferedImage[] background ;
		background = new BufferedImage[1];
		try {
			background[0] = ImageIO.read(this.getClass().getResourceAsStream("/Menu.png"));
		} catch (IOException e) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
		return background[0];
	}
	
	public BufferedImage[] set2(){
		BufferedImage[] selectIMG;
		selectIMG = new BufferedImage[4];
		try {
			selectIMG[0] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu P1.gif"));
			selectIMG[1] = ImageIO.read(this.getClass().getResourceAsStream("/Ken P1.gif"));
			selectIMG[2] = ImageIO.read(this.getClass().getResourceAsStream("/Ryu P2.gif"));
			selectIMG[3] = ImageIO.read(this.getClass().getResourceAsStream("/Ken P2.gif"));
		} catch (IOException e) {
			
		}
		return selectIMG;
	}
	
	
	public BufferedImage selectIMG(int x){
		return chara[x].getImage();
	}
	public void draw2(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		draw3(g);
		for(int i = 0; i < options2.length; i++){
			if(i == currentSelection){
				g.setColor(Color.CYAN);
			}else{
				g.setColor(Color.WHITE);
	}
			if(currentSelection == 0){
				g.drawImage(selectIMG(0),250, 200, 450, 600, null);	
			}
			if(currentSelection == 1){
				g.drawImage(selectIMG(1),250, 200, 450, 600, null);	
			}
//			g.drawImage(selectIMG(0),700, 200, 900, 600, null);	
			g.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 450, 200 + i * 100);
		}
		g.setColor(Color.CYAN);
		g.drawString("CHOOSE YOUR CHARACTER", 350, 100);
	}
	public void draw3(Graphics g){
		g.drawImage(set(g),0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);		
	}
	public void draw(Graphics g) {		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		draw2(g);
		
		for(int i = 0; i < options.length; i++){
			if(i == currentSelection2){
				g.setColor(Color.CYAN);
			}else{
				g.setColor(Color.WHITE);
			}
			if(currentSelection2 == 0){
				g.drawImage(selectIMG(2),650, 200, 450, 600, null);	
			}
			if(currentSelection2 == 1){
				g.drawImage(selectIMG(3),650, 200, 450, 600, null);		
			}

			g.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
			g.drawString(options[i], GamePanel.WIDTH / 2 + 100, 200 + i * 100);
		}
		g.setColor(Color.CYAN);
		g.drawString("CHOOSE YOUR CHARACTER", 350, 100);
	}


	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			currentSelection2++;
			if(currentSelection2 >= options.length){
				currentSelection2 = 0;
			}
		}else if(k == KeyEvent.VK_UP){
			currentSelection2--;
			if(currentSelection2 < 0){
				currentSelection2 = options.length -1;
			}
		}
		if(k == KeyEvent.VK_S){
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		}else if(k == KeyEvent.VK_W){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length -1;
			}
		}
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection == 2 ||currentSelection2 == 2){
				gsm.states.push(new MenuState(gsm));
			}
			if(currentSelection == 0 && currentSelection2 == 0){
				gsm.states.push(new StageSelectState(gsm, chara[currentSelection],chara[currentSelection2 + 2]));
			}else if(currentSelection == 0 && currentSelection2 == 1){
				bb = true;
				gsm.states.push(new StageSelectState(gsm, chara[currentSelection],chara[currentSelection2 + 2]));
			}else if(currentSelection == 1 && currentSelection2 == 0){
				b = true;
				gsm.states.push(new StageSelectState(gsm, chara[currentSelection],chara[currentSelection2 + 2]));
			}else if(currentSelection == 1 && currentSelection2 == 1){
				b = true;bb = true;
				gsm.states.push(new StageSelectState(gsm, chara[currentSelection],chara[currentSelection2 + 2]));
			}
			
		}
		
	}


	public void keyReleased(int k) {


	}

}

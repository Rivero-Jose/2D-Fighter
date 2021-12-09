import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class StageSelectState extends GameState{
	private String[] options = {"Night City","Oriental Rooftop","Dark Void","Back"};
	private int currentSelection = 0;
	private Character Select1;
	private Character Select2;
	Stages[] stages = new Stages[3];
//	private ImageIcon picture = new ImageIcon(MenuState.class.getResource("dotpict_20170218_124011.png"));
	public StageSelectState(GameStateManager gsm,Character p1, Character p2) {
		super(gsm);
		Select1 = p1;
		Select2 = p2;
		BufferedImage[] arr = set2();
		stages[0] = new Stages(new Sound("/Most Wondrous Battle Music Ever God Mode by Sons of Amon.wav"),arr[0]);
		stages[1] = new Stages(new Sound("/Most Wondrous Battle Music Ever Killing The King.wav"),arr[1]);
		stages[2] = new Stages(new Sound("/Most Wondrous Battle Music Ever The Comrades Song.wav"),arr[2]);
		stages[0].getSound().play();
	}
	
	

	public void init() {
	
	
	}


	public void tick() {
	
	
	}
	public BufferedImage[] set2(){
		BufferedImage[] background ;
		background = new BufferedImage[3];
		try {
			background[0] = ImageIO.read(this.getClass().getResourceAsStream("/Stage1.png"));
			background[1] = ImageIO.read(this.getClass().getResourceAsStream("/Stage2.png"));
			background[2] = ImageIO.read(this.getClass().getResourceAsStream("/Stage3.png"));
		} catch (IOException e) {
			
		}
		return background;
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
	public void draw2(Graphics g){
		g.drawImage(set(g),0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);		
	}
	public void draw(Graphics g) {	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		draw2(g);
		for(int i = 0; i < options.length; i++){
			if(i == currentSelection){
				g.setColor(Color.CYAN);
			}else{
				g.setColor(Color.WHITE);
			}
			if(currentSelection == 0){
				g.drawImage(stages[0].getImage(), 600,200,750,400,null);
			}else if(currentSelection == 1){
				g.drawImage(stages[1].getImage(), 600,200,750,400,null);
			}else if(currentSelection == 2){
				g.drawImage(stages[2].getImage(), 600,200,750,400,null);
				
			}
			g.setFont(new Font("TimesNewRoman", Font.PLAIN, 60));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 500, 300 + i * 100);
		}
		
		g.setColor(Color.CYAN);
		g.drawString("CHOOSE THE STAGE", 210, 100);
	}


	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			stages[0].getSound().stop();
			stages[1].getSound().stop();
			stages[2].getSound().stop();
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}if(currentSelection < 3){
				stages[currentSelection].getSound().play();
			}else{
				stages[currentSelection - 1].getSound().stop();
				stages[0].getSound().stop();
			}
		}else if(k == KeyEvent.VK_UP){
			stages[0].getSound().stop();
			stages[1].getSound().stop();
			stages[2].getSound().stop();
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length -1;
			}
			if(currentSelection < 3){
				stages[currentSelection].getSound().play();
			}else{
				stages[currentSelection - 1].getSound().stop();
				stages[0].getSound().stop();
			}
				
			
			
		}
		
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection == 0){
				stages[currentSelection].getSound().stop();
				gsm.states.push(new BattleState(gsm, Select1, Select2, stages[currentSelection]));
			}else if(currentSelection == 1){
				stages[currentSelection].getSound().stop();
				gsm.states.push(new BattleState(gsm, Select1, Select2, stages[currentSelection]));
			}else if(currentSelection == 2){
				stages[currentSelection].getSound().stop();
				gsm.states.push(new BattleState(gsm, Select1, Select2, stages[currentSelection]));
			}else if(currentSelection == 3){
				stages[currentSelection - 1].getSound().stop();
				stages[0].getSound().stop();
				gsm.states.push(new CharacterSelectState(gsm));
			}
		}	
	}


	public void keyReleased(int k) {


	}

}

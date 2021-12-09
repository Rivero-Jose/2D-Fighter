import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class MenuState extends GameState{

	private String[] options = {"Character Select","Controls","Quit"};
	private int currentSelection = 0;
//	private ImageIcon picture = new ImageIcon(MenuState.class.getResource("dotpict_20170218_124011.png"));
	public MenuState(GameStateManager gsm) {
		super(gsm);
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

			g.setFont(new Font("TimesNewRoman", Font.PLAIN, 60));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 200, 300 + i * 100);
		}
		g.setColor(Color.CYAN);
		g.drawString("AreaZERO", 430, 100);
	}


	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		}else if(k == KeyEvent.VK_UP){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length -1;
			}
		}
		
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection == 0){
				gsm.states.push(new CharacterSelectState (gsm));
			}else if(currentSelection == 1){
				gsm.states.push(new ControlsState (gsm));
				
			}else if(currentSelection == 2){
				System.exit(0);//QUIT
			}
		}
	}


	public void keyReleased(int k) {


	}

}

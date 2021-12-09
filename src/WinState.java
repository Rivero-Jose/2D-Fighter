import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class WinState extends GameState{
	private String[] options = {"Character Select","Controls","Quit"};
	private int currentSelection = 0;
	private String s;
//	private ImageIcon picture = new ImageIcon(MenuState.class.getResource("dotpict_20170218_124011.png"));
	public WinState(GameStateManager gsm, String S) {
		super(gsm);
		s = S;
		Player.win = false; 
		Player.win2 = false;
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
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 60));
		g.setColor(Color.CYAN);
		g.drawString(s, GamePanel.WIDTH / 2 - 250, GamePanel.HEIGHT / 2);
	}


	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection == 0){
				gsm.states.push(new MenuState(gsm));
			}else if(currentSelection == 1){
				
			}
		}
	}


	public void keyReleased(int k) {


	}
}

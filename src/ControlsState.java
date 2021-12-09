import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class ControlsState extends GameState{
	private String[] options = {"Character Select","Controls","Quit"};
	private int currentSelection = 0;
//	private ImageIcon picture = new ImageIcon(MenuState.class.getResource("dotpict_20170218_124011.png"));
	public ControlsState(GameStateManager gsm) {
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
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 60));
		g.setColor(Color.CYAN);
		g.drawString("CONTROLS", 100, 100);
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
		g.drawString("PLAYER 1: WASD for movement, C for Light, V for Heavy, B for Ultimate", 100, 200);
		g.drawString("PLAYER 2: ARROW KEYS for movement, < for Light, > for Heavy, / for Ultimate", 100, 300);
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

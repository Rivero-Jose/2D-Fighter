
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BattleState extends GameState {
	
	private Player player;
	private Map map;
	private Stages stage;
	public BattleState(GameStateManager gsm, Character C1, Character C2, Stages S){
		super(gsm);
		stage = S;
		stage.getSound().loop();
		init();
	}

	public void init() {
		
		map = new Map("/map1.map");
		player = new Player(100,300);
		xOffSet = 0;
		yOffSet = -600;
		
	}
	
	public void tick() {
		
		
		player.tick(map.getBlocks());
		player.tick2(map.getBlocks());
		if(player.win){
			stage.getSound().stop();
			gsm.states.push(new WinState(gsm, "PLAYER 1 WINS"));
		}else if(player.win2){
			stage.getSound().stop();
			gsm.states.push(new WinState(gsm, "PLAYER 2 WINS"));
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(stage.getImage(),0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		map.draw(g);
		player.draw2(g);
		player.draw(g);
		
		
		drawbar(g);
	}
	
	public void drawbar(Graphics g){
		//health P1
		g.setColor(Color.RED);
		g.drawRect(25, 25, 400, 40);
		//health P2
		g.drawRect(GamePanel.WIDTH / 2 + 150, 25, 400, 40);
		//Ultimate P1
		g.setColor(Color.CYAN);
		g.drawRect(50, 620, 300, 20);
		//Ultimate P2
	
		g.drawRect(GamePanel.WIDTH / 2 + 200, 620, 300, 20);
		
	}
	
	public void keyPressed(int k) {
		player.keyPressed(k);
		player.keyPressed2(k);
		}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
		player.keyReleased2(k);
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
 
import javax.imageio.ImageIO;

 
 
public class Player extends Rectangle {
	
	
		private boolean animateR2 = false, animateL2 = false, animateJ2 = false , animateB2 = false, animateLI2 = false, animateH2 = false, animateU2 = false;
		private int frameDelay2 = 0, health2 = 425, ultcharge2 = 0, maxhealth2 = 425;
		private int frameR2 = 0, frameL2 = 0, frameJ2 = 3, frameB2 = 4, frameLI2 = 5, frameH2 = 6, frameU2 = 8;
		private boolean right2 = false, left2 = false, jumping2 = false, falling2 = false, block2 = false, light2 = false, heavy2 = false, ult2 = false;
		static boolean win2 = false;
		private boolean topCollision2 = false;
		private Images IMG;
		static final long serialVersionUID2 =1L;
	 
		
		
			public static int lives2 = 3;
			public static double x2,y2;
			private int width2,height2;
			private int frameRate2 = 5, frameHit2 = 0, frameHitRate2 = 3;
			private double jumpSpeed2 = 6.5;
			private double currentJumpSpeed2 = jumpSpeed2;
			public static double maxFallSpeed2 = 6.5;
			 public static double currentFallSpeed2 = .1;
			
			
		
	public void tick2(Block[][] b){
			
			
			int iX = (int)x2;
			int iY = (int)y2;
			
			
			
			for(int i = 0; i < b.length; i++){
				for(int j = 0; j < b[i].length; j++){
				
				if(b[i][j].getID() != 0){
				//right
				if(Collision.playerBlock(new Point(iX + width2 +(int)GameState.xOffSet + 2, iY +(int)GameState.yOffSet + 2),b[i][j]) || 
						Collision.playerBlock(new Point(iX + width2 +(int)GameState.xOffSet + 2, iY + height2 +(int)GameState.yOffSet - 1),b[i][j] )){
					right2 = false;
				}
				//left
				if(Collision.playerBlock(new Point(iX +(int)GameState.xOffSet - 1, iY +(int)GameState.yOffSet + 2),b[i][j]) || 
						Collision.playerBlock(new Point(iX + width2 +(int)GameState.xOffSet - 1, iY + height2 +(int)GameState.yOffSet - 1),b[i][j] )){
					left2 = false;
				}
				if(Collision.playerBlock(new Point(iX +(int)GameState.xOffSet + 1, iY +(int)GameState.yOffSet),b[i][j]) || 
						Collision.playerBlock(new Point(iX + width2 +(int)GameState.xOffSet - 2, iY+(int)GameState.yOffSet),b[i][j] )){
					jumping2 = false;
					falling2 = true;
				}
				if(Collision.playerBlock(new Point(iX +(int)GameState.xOffSet + 3, iY + height2 +(int)GameState.yOffSet + 2),b[i][j]) || 
						Collision.playerBlock(new Point(iX + width2 +(int)GameState.xOffSet - 3, iY + height2 +(int)GameState.yOffSet + 2),b[i][j] )){
					y2 = b[i][j].getY() - height2 - GameState.yOffSet;
					falling2 = false;
					topCollision2 = true;
				}else{
					if(!topCollision2 && !jumping2){
						falling2 = true;
					}
				}
				
			}
		}
		}
			
			if(x2 - x < 120 || (x - x2 > -120 && x - x2 < 0)){
				if(!block){
				if(light2 && !left2 && !right2 && !heavy2 && !block2){
					frameHit2++;
					if(frameHit2 >= frameHitRate2){
						frameHit2 = 0;
						health--;
						ultcharge+=2;
					}
				}if(heavy2 && !left2 && !right2 && !light2 && !block2){
					frameHit2++;
					if(frameHit2 >= frameHitRate2){
						frameHit2 = 0;
						health-=2;
						ultcharge += 4;
					}
				}
				}
				if(ultcharge2 == 300){
					if(ult2 && !left2 && !right2 && !light2 && !block2 && !heavy2){
						health -= 100;
					}
				}
			}
			if(x2 < x + width){
				x2 = x + width;
			}
			if(x2 + 100 >= GamePanel.WIDTH){
				x2 = GamePanel.WIDTH - 100;
			}
			if(ultcharge >= 300){
				ultcharge = 300;
			}
			if(right2){ x2+=2; }
			if(left2){ x2-=2; }
			topCollision2 = false;
			if(y2 <= 600){
			if(jumping2){
				
//				System.out.println(GameState.xOffSet + "   " + GameState.yOffSet);
				currentJumpSpeed2 -= .1;
				if(currentJumpSpeed2 <= 0){
					currentJumpSpeed2 = jumpSpeed2;
					jumping2 = false;
					falling2 = true;
				}
				
			}if(falling2){
				
//				System.out.println(GameState.xOffSet + "   " + GameState.yOffSet);
				if(currentFallSpeed2 < maxFallSpeed2){
					currentFallSpeed2 += .1;
							
				}
//				if(currentFallSpeed > maxFallSpeed){
//					currentFallSpeed = 0;
//					falling = false;
//				}
			}
			if(!falling2){
				currentFallSpeed2 = .1;
			}
			}
			if(health2 <= 0){
				win = true;
			}
		
		}
		
		private Thread thread = new Thread();
		public void draw2(Graphics g){
			try{
				thread.start();
			}catch(Exception e){
				
			}
			
			g.setColor(Color.RED);
			g.fillRect(GamePanel.WIDTH / 2 + 150, 25, maxhealth2 - health2,40);
			g.setColor(Color.CYAN);
			g.fillRect(50, 620, ultcharge, 20);
			if(right2){
				animateR2 = true;
				try{
					g.drawImage(Images.player2IMG[frameR2],(int)x2, (int)y2, width, height, null);
				}catch(Exception e){
					
				}
			}else if(left2){
				animateL2 = true;
				try{
					g.drawImage(Images.player2IMG[frameL2],(int)x2, (int)y2, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(block2){
				animateB2 = true;
				try{
					g.drawImage(Images.player2IMG[frameB2],(int)x2, (int)y2, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(jumping2){
				animateJ2 = true;
				try{
					g.drawImage(Images.player2IMG[frameJ2],(int)x2, (int)y2, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(light2){
				animateLI2 = true;
				try{
					g.drawImage(Images.player2IMG[frameLI2],(int)x2, (int)y2, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(heavy2){
				animateH2 = true;
				try{
					g.drawImage(Images.player2IMG[frameH2],(int)x2, (int)y2, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(ultcharge2 == 300){
				g.drawImage(Images.player2IMG[0],(int)x2, (int)y2, width, height, null);
			
				if(ult2 ){
				animateU2 = true;
				try{
					g.drawImage(Images.player2IMG[frameU2],(int)x2, (int)y2, width, height, null);
					
				}catch(Exception e){
					
				}
				ultcharge2 -= 300;
				}
			}else{
				g.drawImage(Images.player2IMG[0],(int)x2, (int)y2, width, height, null);
				
				animateR2 = false;
				animateL2 = false;
				animateB2 = false;
				animateLI2 = false;
				animateH2 = false;
				animateJ2 = false;
				
			}
			if(animateR2){
				frameDelay2++;
					if(frameDelay2 >= frameRate2){
						frameDelay2 = 0;
						frameR2++;
						if(frameR2 == 2){
							frameR2 = 0;
					}
				}
			}
			if(animateL2){
				frameDelay2++;
					if(frameDelay2 >= frameRate2){
						frameDelay2 = 0;
						frameL2++;
						if(frameL2 == 2){
							frameL2 = 0;
					}
				}
			}
			
			if(animateJ2){
				frameDelay2++;
					if(frameDelay2 >= frameRate2){
						frameDelay2 = 0;
//						if(frameJ2 == 3){
//							frameJ2 = 3;
//					}
				}
			}
			if(animateB2){
				frameDelay2++;
					if(frameDelay2 >= frameRate2){
						frameDelay2 = 0;
//						if(frameB2 == 4){
//							frameB2 = 4;
//					}
				}
			}if(animateLI2){
				frameDelay2++;
				if(frameDelay2 >= frameRate2){
					frameDelay2 = 0;
//					if(frameLI2 == 5){
//						frameLI2 = 5;
//				}
			}if(animateH2){
				frameDelay2++;
				if(frameDelay2 >= frameRate2){
					frameDelay2 = 0;
					frameH2++;
					if(frameH2 == 7){
						frameH2 = 6;
				}
			
			}
			}if(animateU2){
				frameDelay2++;
				if(frameDelay2 >= frameRate2){
					frameDelay2 = 0;
					frameU2++;
					if(frameU2 == 10){
						frameU2 = 8;
					}
				}
			}
		}	
	}
		public void keyPressed2(int k){
			if(k == KeyEvent.VK_RIGHT){
				right2 = true;
			}else if(k == KeyEvent.VK_LEFT){
				left2 = true;
			}else if(k == KeyEvent.VK_UP && !jumping2 && !falling2){
				jumping2 = true;
			}else if(k == KeyEvent.VK_COMMA){
				light2 = true;
			}else if(k == KeyEvent.VK_PERIOD){
				heavy2 = true;
			}else if(k == KeyEvent.VK_SLASH){
				ult2 = true;
			}else if(k == KeyEvent.VK_SHIFT){
				if(!left2 && !right2 && !light2 && !heavy2){
					block2 = true;
				}else{
					block2 = false;
				}
			}
		}
		
		public void keyReleased2(int k){
			if(k == KeyEvent.VK_RIGHT){
				right2 = false;
			}else if(k == KeyEvent.VK_LEFT){
				left2 = false;
			}else if(k == KeyEvent.VK_COMMA){
				light2 = false;
			}else if(k == KeyEvent.VK_PERIOD){
				heavy2 = false;
			}else if(k == KeyEvent.VK_SLASH){
				ult2 = false;
			}else if(k == KeyEvent.VK_SHIFT){
				block2 = false;
			}
			
		}	
	
	// Variables for Player 1
	private boolean animateR = false, animateL = false, animateJ = false , animateB = false, animateLI = false, animateH = false, animateU = false;
	private int frameDelay = 0, health = 425, ultcharge =0, maxhealth = 425;
	private int frameR = 0, frameL = 0, frameJ = 3, frameB = 4, frameLI = 5, frameH = 6, frameU = 8;
	private boolean right = false, left = false, jumping = false, falling = false, block = false, light = false, heavy = false, ult = false;
	static boolean win = false;
	private boolean topCollision = false;
	
	static final long serialVersionUID =1L;
	
	
 
	public static int lives = 3;
	public static double x,y;
	private int width,height;
	private int frameRate = 5, frameHit = 0, frameHitRate = 3;
	private double jumpSpeed = 6.5;
	private double currentJumpSpeed = jumpSpeed;
	public static double maxFallSpeed = 6.5;
	 public static double currentFallSpeed = .1;
	
	
 
	
	
	
	
		
///////////////////////////////////////////////////////////////////////	//////////////////////////////////////////////	
	
	
 
	public Player( int width, int height){
		x = 100;
		y = 300;
		this.width = width;
		this.height = height;
		
		x2 = 900;
		y2 = 300;
		
		IMG = new Images();
		
		
		
		
	}
	
// TICK METHOD FOR PLAYER 1	
	public void tick(Block[][] b){
		
		
		int iX = (int)x;
		int iY = (int)y;
		
			
		
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[i].length; j++){
			
			if(b[i][j].getID() != 0){
			//right
			if(Collision.playerBlock(new Point(iX + width +(int)GameState.xOffSet + 2, iY +(int)GameState.yOffSet + 2),b[i][j]) || 
					Collision.playerBlock(new Point(iX + width +(int)GameState.xOffSet + 2, iY + height +(int)GameState.yOffSet - 1),b[i][j] )){
				right = false;
			}
			//left
			if(Collision.playerBlock(new Point(iX +(int)GameState.xOffSet - 1, iY +(int)GameState.yOffSet + 2),b[i][j]) || 
					Collision.playerBlock(new Point(iX + width +(int)GameState.xOffSet - 1, iY + height +(int)GameState.yOffSet - 1),b[i][j] )){
				left = false;
			}
			if(Collision.playerBlock(new Point(iX +(int)GameState.xOffSet + 1, iY +(int)GameState.yOffSet),b[i][j]) || 
					Collision.playerBlock(new Point(iX + width +(int)GameState.xOffSet - 2, iY+(int)GameState.yOffSet),b[i][j] )){
				jumping = false;
				falling = true;
			}
			if(Collision.playerBlock(new Point(iX +(int)GameState.xOffSet + 3, iY + height +(int)GameState.yOffSet + 2),b[i][j]) || 
					Collision.playerBlock(new Point(iX + width +(int)GameState.xOffSet - 3, iY + height +(int)GameState.yOffSet + 2),b[i][j] )){
				y = b[i][j].getY() - height - GameState.yOffSet;
				falling = false;
				topCollision = true;
			}else{
				if(!topCollision && !jumping){
					falling = true;
				}
			}
			
		}
	}
	}
		
		if(x2 - x < 120 || (x - x2 > -120 && x - x2 < 0)){
			if(!block2){
			if(light && !left && !right && !heavy && !block){
				frameHit++;
				if(frameHit >= frameHitRate){
					frameHit = 0;
					health2--;
					ultcharge2+=2;
				}
			}if(heavy && !left && !right && !light && !block){
				frameHit++;
				if(frameHit >= frameHitRate){
					frameHit = 0;
					health2-=2;
					ultcharge2 += 4;
				}
			}
			}
			if(ultcharge == 300){
				if(ult && !left && !right && !light && !block && !heavy){
					health2 -= 100;
				}
			}
		}
		if(x + 100 >  x2){
			x = x2 -100;
		}
		if(x <= 0){
			x = 0;
		}
		if(right){ x+=2; }
		if(left){ x-=2; }
		topCollision = false;
		if(ultcharge2 >= 300){
			ultcharge2 = 300;
		}
		if(health <= 25){
			win2 = true;
		}
	}
	
	
 
	
	
		
		public void draw(Graphics g){
			try{
				thread.start();
			}catch(Exception e){
				
			}
			
			g.setColor(Color.RED);
			g.fillRect(health, 25, maxhealth - health,40);
			g.setColor(Color.CYAN);
			g.fillRect(GamePanel.WIDTH/ 2 + 200, 620, ultcharge2, 20);
			if(right){
				animateR = true;
				try{
					g.drawImage(Images.playerIMG[frameR],(int)x, (int)y, width, height, null);
				}catch(Exception e){
					
				}
			}else if(left){
				animateL = true;
				try{
					g.drawImage(Images.playerIMG[frameL],(int)x, (int)y, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(block){
				animateB = true;
				try{
					g.drawImage(Images.playerIMG[frameB],(int)x, (int)y, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(light){
				animateLI = true;
				try{
					g.drawImage(Images.playerIMG[frameLI],(int)x, (int)y, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(heavy){
				animateH = true;
				try{
					g.drawImage(Images.playerIMG[frameH],(int)x, (int)y, width, height, null);
					
				}catch(Exception e){
					
				}
			}else if(ultcharge == 300){
				g.drawImage(Images.playerIMG[0],(int)x, (int)y, width, height, null);
				
				if(ult){
				animateU = true;
				try{
					g.drawImage(Images.playerIMG[frameU],(int)x, (int)y, width, height, null);
					
				}catch(Exception e){
					
				}
				ultcharge -= 300;
				}
			}else{
				g.drawImage(Images.playerIMG[0],(int)x, (int)y, width, height, null);
				
				animateR = false;
				animateL = false;
				animateB = false;
				animateLI = false;
				animateH = false;
				animateJ = false;
				
			}
			if(animateR){
				frameDelay++;
					if(frameDelay >= frameRate){
						frameDelay = 0;
						frameR++;
						if(frameR == 2){
							frameR = 0;
					}
				}
			}
			if(animateL){
				frameDelay++;
					if(frameDelay >= frameRate){
						frameDelay = 0;
						frameL++;
						if(frameL == 2){
							frameL = 0;
					}
				}
			}
			
			
			if(animateB){
				frameDelay++;
					if(frameDelay >= frameRate){
						frameDelay = 0;
//						if(frameB == 4){
//							frameB = 4;
//					}
				}
			}if(animateLI){
				frameDelay++;
				if(frameDelay >= frameRate){
					frameDelay = 0;
//					if(frameLI == 5){
//						frameLI = 5;
//				}
			}if(animateH){
				frameDelay++;
				if(frameDelay >= frameRate){
					frameDelay = 0;
					frameH++;
					if(frameH == 7){
						frameH = 6;
				}
			
			}if(animateU){
				frameDelay++;
				if(frameDelay >= frameRate){
					frameDelay = 0;
					frameU++;
					if(frameU == 10){
						frameU = 8;
					}
		
				}
			}
		}
	}
}
		
	
// KEY METHODS FOR PLAYER 1	
	
	public void keyPressed(int k){
		if(k == KeyEvent.VK_D){
			right = true;
		}else if(k == KeyEvent.VK_A){
			left = true;
		}else if(k == KeyEvent.VK_W && !jumping && !falling){
			jumping = true;
		}else if(k == KeyEvent.VK_C){
			light = true;
		}else if(k == KeyEvent.VK_V){
			heavy = true;
		}else if(k == KeyEvent.VK_B){
			ult = true;
		}else if(k == KeyEvent.VK_Q){
			if(!left && !right && !light && !heavy){
				block = true;
			}else{
				block = false;
			}
			
		}
	}
	
	public void keyReleased(int k){
		if(k == KeyEvent.VK_D){
			right = false;
		}else if(k == KeyEvent.VK_A){
			left = false;
		}else if(k == KeyEvent.VK_C){
			light = false;
		}else if(k == KeyEvent.VK_V){
			heavy = false;
		}else if(k == KeyEvent.VK_B){
			ult = false;
		}else if(k == KeyEvent.VK_Q){
			block = false;
		}
	}
	
	
	
	
	
// KEY METHODS FOR PLAYER 2
	
	
}
 

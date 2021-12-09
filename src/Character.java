import java.awt.image.BufferedImage;


public class Character {

	/**
	 * Character's HP.
	 */
	private int HP;
	/**
	 * Character's run speed.
	 */
	private int runSpeed;
	/**
	 * Character's Light Attack Damage.
	 */
	private int Light;
	/**
	 * Character's Heavy Attack Damage.
	 */
	private int Heavy;
	/**
	 * The amount of damage reduced when character is shielding. 
	 */
	private int Shield;
	/**
	 * The amount of frames that the character's light attack is out for.
	 */
	private int Lframes;
	/**
	 * The amount of frames that the character's heavy attack is out for.
	 */
	private int Hframes;
	/**
	 * The amount of frames the character is vulnerable after doing a light attack.
	 */
	private int Llag;
	/**
	 * The amount of frames the character is vulnerable after doing a light attack.
	 */
	private int Hlag;
	/**
	 * Character's Name (Use for character selection menu).
	 */
	private String Name;
	/**
	 * Character's Voice Clip (Should play when character is selected).
	 */
	private Sound Voiceclip;
	/**
	 * Character's Spritesheet.
	 */
	private String Spritesheet;
	
	private BufferedImage Image;
	
	
	public Character(int hp, int runspeed, int light, int lframes, int llag, int heavy, int hframes, int hlag, int shield, String name, /*Sound voiceclip,*/ String spritesheet, BufferedImage IMG){
		HP = hp;
		runSpeed = runspeed;
		Light = light;
		Heavy = heavy;
		Shield = shield;
		Lframes = lframes;
		Hframes = hframes;
		Name = name;
//		Voiceclip = voiceclip;
		Llag = llag;
		Hlag = hlag;
		Spritesheet = spritesheet;
		Image = IMG;
		
	}

	public int getHP() {
		return HP;
	}

	public int getRunSpeed() {
		return runSpeed;
	}

	public int getLight() {
		return Light;
	}

	public int getHeavy() {
		return Heavy;
	}

	public int getShield() {
		return Shield;
	}

	public int getLframes() {
		return Lframes;
	} 


	public int getHframes() {
		return Hframes;
	}
	public String getName(){
		return Name;
	}
	public Sound getVoiceclip(){
		return Voiceclip;
	}
	public int getLlag(){
		return Llag;
	}
	public int getHlag(){
		return Hlag;
	}
	public String getSpritesheet(){
		return Spritesheet;
	}
	public BufferedImage getImage(){
		return Image;
	}
	
	
}


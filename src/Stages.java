import java.awt.image.BufferedImage;


public class Stages {
	private Sound audioClip;
	private BufferedImage Image;
	public Stages (Sound clip, BufferedImage IMG){
		audioClip = clip;
		Image = IMG;		
	}
	
	public Sound getSound(){
		return audioClip;
	}
	public BufferedImage getImage(){
		return Image;
	}
}

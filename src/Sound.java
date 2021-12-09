
import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.*;
	public class Sound{
	    private Clip clip;
	    private String name;
	    public Sound (String fileName) {
	    	name = fileName;
	        try {
	        	InputStream input = new BufferedInputStream(this.getClass().getResourceAsStream(fileName));
	            AudioInputStream ais = AudioSystem.getAudioInputStream(input);
	            clip = AudioSystem.getClip();
	            clip.open(ais);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void play() {
	        try {
	            if (clip != null) {
	                new Thread() {
	                    public void run() {
	                        synchronized (clip) {
	                            clip.stop();
	                            clip.setFramePosition(0);
	                            clip.start();
	                        }
	                    }
	                }.start();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void stop(){
	        if(clip == null) return;
	        clip.stop();
	    }
	    public void loop() {
	        try {
	            if (clip != null) {
	                new Thread() {
	                    public void run() {
	                        synchronized (clip) {
	                            clip.stop();
	                            clip.setFramePosition(0);
	                            clip.loop(Clip.LOOP_CONTINUOUSLY);// me too
	                        }
	                    }
	                }.start();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	    public boolean isActive(){
	        return clip.isActive();
	    }
	    
	    public String getName(){
	    	return name.substring(0,name.indexOf("."));
	    }

}

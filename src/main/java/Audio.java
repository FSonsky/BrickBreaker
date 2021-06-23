import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    public void playPaddleHit() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/paddleHit.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(paddleHit);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void playBrickHit() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/brickHit.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(paddleHit);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void playGameOver() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/gameOver.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(paddleHit);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
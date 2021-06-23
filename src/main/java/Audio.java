import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    public Clip clip;

    public void playTheme() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/gameMusic.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(paddleHit);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            this.clip = clip;
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

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

    public void playPaddleSizeBrickHit() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/paddleSizeBrick.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(paddleHit);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void playSpeedBrickHit() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/speedBrick.wav").getAbsoluteFile());
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

    public void playLevelComplete() {
        try {
            AudioInputStream paddleHit = AudioSystem.getAudioInputStream(new File("src/sounds/levelComplete.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(paddleHit);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}

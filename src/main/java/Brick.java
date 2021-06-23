import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Brick {
    public int startX;
    public int startY;
    public int width;
    public int heigth;
    private final char brickChar= '\u2588';
    public List<Position> brickPos = new ArrayList<>();
    public int life = 3;
    public BrickType brickType = BrickType.NORMAL;


    public Brick(int startX, int startY, int width, int height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.heigth = height;
        setupList();
        randomBrickType();
    }

    public void randomBrickType () {
        Random rand = new Random();
        int randomBrick = rand.nextInt(4);
        switch (randomBrick) {
            case 0:
                this.brickType = BrickType.NORMAL;
                break;
            case 1:
                this.brickType = BrickType.BALL_SPEED_INCREASE;
                break;
            case 2:
                this.brickType = BrickType.PADDLE_SIZE_DECREASE;
                break;
            default:
                this.brickType = BrickType.PADDLE_SIZE_INCREASE;
        }
    }

    public void setBrickType (BrickType brickType) {
        this.brickType = brickType;
    }

    public void reduceLife () {
        this.life--;
    }

    public boolean isAlive () {
        return this.life != 1;
    }

    private void setupList () {
        for (int i = this.startX; i < this.width + startX; i++) {
            for (int j = this.startY; j < this.heigth + startY; j++) {
                this.brickPos.add(new Position(i, j));
            }
        }
    }

    public boolean invertX (int x, int y) {
        for (Position p : brickPos) {
            if (p.x + 1 == x || p.x - 1 == x && p.y == y) {
                return true;
            }
        }
        return false;
    }
    public boolean invertY (int x, int y) {
        for (Position p : brickPos) {
            if (p.y + 1 == y || p.y - 1 == y && p.x == x) {
                return true;
            }
        }
        return false;
    }

    public void drawBrick (Terminal terminal) throws IOException {

        if (this.life == 2) {
            color = new TextColor.RGB(10, 10, 200);
        } else if (this.life == 1) {
            color = new TextColor.RGB(200, 10, 10);
        }
        for (Position p : this.brickPos) {
            terminal.setForegroundColor(color);
            terminal.setCursorPosition(p.x, p.y);
            terminal.putCharacter(this.brickChar);
        }
        //terminal.setForegroundColor(standardColor);
    }



    public void removeBrick (Terminal terminal) throws IOException {
        for (Position p : this.brickPos) {
            terminal.setCursorPosition(p.x, p.y);
            terminal.putCharacter(' ');
        }
    }


}
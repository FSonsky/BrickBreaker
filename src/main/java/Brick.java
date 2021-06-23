import com.googlecode.lanterna.terminal.Terminal;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Brick {
    public int startX;
    public int startY;
    public int width;
    public int heigth;
    private final char brickChar= '\u2588';
    public List<Position> brickPos = new ArrayList<>();;


    public Brick(int startX, int startY, int width, int height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.heigth = height;
        setupList();
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
        for (Position p : this.brickPos) {
            terminal.setCursorPosition(p.x, p.y);
            terminal.putCharacter(this.brickChar);
        }
    }

    public void removeBrick (Terminal terminal) throws IOException {
        for (Position p : this.brickPos) {
            terminal.setCursorPosition(p.x, p.y);
            terminal.putCharacter(' ');
        }
    }


}
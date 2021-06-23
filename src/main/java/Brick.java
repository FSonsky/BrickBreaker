import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Brick {
    public int startX;
    public int startY;
    public int width;
    public int heigth;
    public final char icon = '\u2588';
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

    private boolean invertX (int x, int y) {
        for (Position p : brickPos) {
            if (p.x + 1 == x || p.x - 1 == x && p.y == y) {
                return true;
            }
        }
        return false;
    }
    private boolean invertY (int x, int y) {
        for (Position p : brickPos) {
            if (p.y + 1 == y || p.y - 1 == y && p.x == x) {
                return true;
            }
        }
        return false;
    }

    public void draw(Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(icon);
        terminal.flush();
    }

    public void remove(Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(' ');
        terminal.flush();
    }
}
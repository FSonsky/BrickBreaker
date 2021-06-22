import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Brick {
    public int startX;
    public int startY;
    public int endX;
    public int endY;

    public Brick(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public boolean isHitByBall (int x, int y) {
        return false;
    }

    public void drawBrick (Terminal terminal) throws IOException {

        TextGraphics tGraphics = terminal.newTextGraphics();

        tGraphics.drawRectangle(
                new TerminalPosition(startX,startY), new TerminalSize(10,1), '\u2588');
        /*
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                terminal.setCursorPosition(i, j);
                terminal.putCharacter('\u2588');
            }
        }
        */
    }
}

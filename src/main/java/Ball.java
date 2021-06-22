import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Ball {
    public int x;
    public int y;
    public int prevX;
    public int prevY;
    public int xAccel;
    public int yAccel;
    public int speedFactor = 1;
    public final char icon = 'O';

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.prevX = x;
        this.prevY = y;
    }

    public Ball(int x, int y, int xAccel, int yAccel) {
        this.x = x;
        this.y = y;
        this.prevX = x;
        this.prevY = y;
        this.xAccel = xAccel;
        this.yAccel = yAccel;
    }

    public void draw(Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        terminal.setCursorPosition(prevX, prevY);
        terminal.putCharacter(' ');
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(icon);
    }

    public void setNewPosition(Terminal terminal, Player player, int playerJustMoved) throws IOException {
        prevX = x;
        prevY = y;
        x += xAccel;
        y += yAccel;

        // See if we hit edges of screen
        if (x <= 0 || x >= terminal.getTerminalSize().getColumns() - 1) {
            xAccel *= -1;
        }
        if (y <= 0) {
            yAccel *= -1;
        }

        // See if we hit paddle
        if (player.isHitByBall(x, y)) {
            if (playerJustMoved != 0) {
                xAccel += playerJustMoved;
            }
            yAccel *= -1;
            y = prevY;
            y += yAccel;
        }
    }
}

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Player {
    public final char playCharacter = '\u2586';
    public int x;
    public int y;
    public int oldX;
    public int oldY;
    public int paddelSize;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
        this.paddelSize = 7;


    }

    public void setPaddelSize(int paddelSize) {
        this.paddelSize = paddelSize;
    }

    public void draw(Terminal terminal) throws IOException {

        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        for (int i = 0; i < paddelSize; i++){
           terminal.setCursorPosition(oldX+i, oldY);
           terminal.putCharacter(' ');

        }

        for (int i = 0; i < paddelSize; i++){


            if (i==0 || i==paddelSize-1){
                terminal.setForegroundColor(new TextColor.RGB(230, 250, 51));

            }
            else{
                terminal.setForegroundColor(new TextColor.RGB(78,51,250));
            }
            terminal.setCursorPosition(x + i, y);
            terminal.putCharacter(playCharacter);

        }
    }

    public void setNewPositionPlayer(Terminal terminal, int move) throws IOException {
        oldX = x;
        oldY = y;
        x += move;
        if (x < 0 || x > terminal.getTerminalSize().getColumns() - paddelSize) {
            x = oldX;
        }

    }

    public boolean isHitByBall(int x, int y) {
        if (y == this.y) {
            if (x >= this.x && x <= this.x + 5) {
                return true;
            }
        }
        return false;
    }
}

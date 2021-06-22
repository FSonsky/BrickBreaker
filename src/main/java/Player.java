import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Player {
    public final char playCharacter = '\u23AF';
    public int x;
    public int y;
    public int oldX;
    public int oldY;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;


    }

    public void draw(Terminal terminal) throws IOException {

        terminal.setCursorPosition(oldX, oldY);
        terminal.putCharacter(' ');
        terminal.setCursorPosition(oldX+1, oldY);
        terminal.putCharacter(' ');
        terminal.setCursorPosition(oldX+2, oldY);
        terminal.putCharacter(' ');
        terminal.setCursorPosition(oldX+3, oldY);
        terminal.putCharacter(' ');
        terminal.setCursorPosition(oldX+4, oldY);
        terminal.putCharacter(' ');
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(playCharacter);
        terminal.setCursorPosition(x+1, y);
        terminal.putCharacter(playCharacter);
        terminal.setCursorPosition(x+2, y);
        terminal.putCharacter(playCharacter);
        terminal.setCursorPosition(x+3, y);
        terminal.putCharacter(playCharacter);
        terminal.setCursorPosition(x+4, y);
        terminal.putCharacter(playCharacter);
    }

    public void setNewPositionPlayer(Terminal terminal, int move) throws IOException{
        oldX = x;
        oldY = y;
        x+=move;
        if (x<0 || x>terminal.getTerminalSize().getColumns()-5){
            x=oldX;
        }

    }
}

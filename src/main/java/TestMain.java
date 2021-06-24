import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.*;

public class TestMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        TerminalSize ts = new TerminalSize(100, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        LevelSB levelSB = new LevelSB();
        List<Brick> bricks = levelSB.bricks;

        for (Brick b :
                bricks) {
            b.drawBrick(terminal);
        }
        terminal.flush();
    }




}
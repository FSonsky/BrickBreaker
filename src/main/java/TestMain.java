import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws IOException {
        //TerminalSize ts = new TerminalSize(400, 420);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        //terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        TextGraphics tGraphics = terminal.newTextGraphics();

        //tGraphics.drawRectangle(
          //      new TerminalPosition(3,3), new TerminalSize(10,10), '*');


        Brick brick = new Brick(1, 2, 15, 4);
        brick.drawBrick(terminal);
        //List<Brick> bricks = makeBricks(5, 10, brick);
        terminal.flush();
    }

    private static List<Brick> makeBricks(int height, int length, Brick brick) {
        return null;
    }
}

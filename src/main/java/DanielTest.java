import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DanielTest {
    public static void main(String[] args) throws IOException {
        TerminalSize ts = new TerminalSize(100, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        Brick brick;

        List<Brick> bricks = new ArrayList<Brick>();

        bricks.add(new Brick(5, 3, 5, 1));
        bricks.add(new Brick(7, 8, 5,1));
        bricks.add(new Brick(20, 22, 5,1));
        bricks.add(new Brick(80, 15, 5,1));
        bricks.add(new Brick(75, 10, 5,1));
        bricks.add(new Brick(50, 12, 5,1));
        bricks.add(new Brick(75, 2, 5,1));
        bricks.add(new Brick(40, 2, 5,1));
        bricks.add(new Brick(90, 13, 5,1));
        bricks.add(new Brick(45, 20, 5,1));
        bricks.add(new Brick(30, 10, 5,1));
        bricks.add(new Brick(35, 15, 5,1));
        bricks.add(new Brick(5, 10, 5,1));
        bricks.add(new Brick(95, 20, 5,1));
        bricks.add(new Brick(60, 5, 5,1));

        for (Brick br : bricks){
            br.drawBrick(terminal);
        }


    }
}

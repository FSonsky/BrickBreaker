import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class MarieTest {

    public static void main(String[] args) throws IOException {
        TerminalSize ts = new TerminalSize(100, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        Brick brick;

        List<Brick> bricks = new ArrayList<Brick>();

        bricks.add(new Brick(2, 3, BrickType.NORMAL));
        bricks.add(new Brick(10, 3, BrickType.NORMAL));
        bricks.add(new Brick(18, 3, BrickType.NORMAL));
        bricks.add(new Brick(26, 3,BrickType.NORMAL));
        bricks.add(new Brick(34, 3, BrickType.NORMAL));
        bricks.add(new Brick(42, 3, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(50, 3, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(58, 3, BrickType.NORMAL));
        bricks.add(new Brick(66, 3, BrickType.NORMAL));
        bricks.add(new Brick(74, 3, BrickType.NORMAL));
        bricks.add(new Brick(82, 3, BrickType.NORMAL));
        bricks.add(new Brick(90, 3, BrickType.BALL_SPEED_INCREASE));

        bricks.add(new Brick(2, 6, BrickType.NORMAL));
        bricks.add(new Brick(10, 6, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(18, 6, BrickType.NORMAL));
        bricks.add(new Brick(26, 6,BrickType.NORMAL));
        //bricks.add(new Brick(34, 6, BrickType.NORMAL));
        //bricks.add(new Brick(42, 6, BrickType.NORMAL));
        //bricks.add(new Brick(50, 6, BrickType.NORMAL));
        //bricks.add(new Brick(58, 6, BrickType.NORMAL));
        bricks.add(new Brick(66, 6, BrickType.NORMAL));
        bricks.add(new Brick(74, 6, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(82, 6, BrickType.NORMAL));
        bricks.add(new Brick(90, 6, BrickType.NORMAL));

        bricks.add(new Brick(2, 9, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(10, 9, BrickType.NORMAL));
        bricks.add(new Brick(18, 9, BrickType.NORMAL));
        bricks.add(new Brick(26, 9,BrickType.NORMAL));
        //bricks.add(new Brick(34, 9, BrickType.NORMAL));
        bricks.add(new Brick(42, 9, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(50, 9, BrickType.BALL_SPEED_INCREASE));
        //bricks.add(new Brick(58, 9, BrickType.NORMAL));
        bricks.add(new Brick(66, 9, BrickType.NORMAL));
        bricks.add(new Brick(74, 9, BrickType.NORMAL));
        bricks.add(new Brick(82, 9, BrickType.NORMAL));
        bricks.add(new Brick(90, 9, BrickType.NORMAL));

        bricks.add(new Brick(2, 12, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(10, 12, BrickType.NORMAL));
        bricks.add(new Brick(18, 12, BrickType.NORMAL));
        //bricks.add(new Brick(26, 12,BrickType.NORMAL));
        //bricks.add(new Brick(34, 12, BrickType.NORMAL));
        bricks.add(new Brick(42, 12, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(50, 12, BrickType.NORMAL));
        //bricks.add(new Brick(58, 12, BrickType.NORMAL));
        //bricks.add(new Brick(66, 12, BrickType.NORMAL));
        bricks.add(new Brick(74, 12, BrickType.NORMAL));
        bricks.add(new Brick(82, 12, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(90, 12, BrickType.NORMAL));

        bricks.add(new Brick(2, 15, BrickType.NORMAL));
        bricks.add(new Brick(10, 15, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(18, 15, BrickType.NORMAL));
        //bricks.add(new Brick(26, 12,BrickType.NORMAL));
        //bricks.add(new Brick(34, 12, BrickType.NORMAL));
        bricks.add(new Brick(42, 15, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(50, 15, BrickType.NORMAL));
        //bricks.add(new Brick(58, 12, BrickType.NORMAL));
        //bricks.add(new Brick(66, 12, BrickType.NORMAL));
        bricks.add(new Brick(74, 15, BrickType.NORMAL));
        bricks.add(new Brick(82, 15, BrickType.NORMAL));
        bricks.add(new Brick(90, 15, BrickType.PADDLE_SIZE_DECREASE));


        for (Brick br : bricks){
            br.drawBrick(terminal);
        }


    }
    }






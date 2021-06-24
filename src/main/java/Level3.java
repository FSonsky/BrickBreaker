import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level3 {
    public static void main(String[] args) throws IOException {
        TerminalSize ts = new TerminalSize(100, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);


        List<Brick> bricks = new ArrayList<>();

        {
            bricks.add(new Brick(2, 3, BrickType.NORMAL));
            bricks.add(new Brick(10, 3, BrickType.NORMAL));
            bricks.add(new Brick(18, 3, BrickType.NORMAL));
            bricks.add(new Brick(26, 3, BrickType.NORMAL));
            bricks.add(new Brick(34, 3, BrickType.NORMAL));
            //bricks.add(new Brick(42, 3, BrickType.BALL_SPEED_INCREASE));
            //bricks.add(new Brick(50, 3, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(58, 3, BrickType.NORMAL));
            bricks.add(new Brick(66, 3, BrickType.NORMAL));
            bricks.add(new Brick(74, 3, BrickType.NORMAL));
            bricks.add(new Brick(82, 3, BrickType.NORMAL));
            bricks.add(new Brick(90, 3, BrickType.NORMAL));

            bricks.add(new Brick(2, 6, BrickType.NORMAL));
            bricks.add(new Brick(10, 6, BrickType.NORMAL));
            bricks.add(new Brick(18, 6, BrickType.NORMAL));
            bricks.add(new Brick(26, 6, BrickType.NORMAL));
            bricks.add(new Brick(34, 6, BrickType.NORMAL));
            //bricks.add(new Brick(42, 6, BrickType.NORMAL));
            //bricks.add(new Brick(50, 6, BrickType.NORMAL));
            bricks.add(new Brick(58, 6, BrickType.NORMAL));
            bricks.add(new Brick(66, 6, BrickType.NORMAL));
            bricks.add(new Brick(74, 6, BrickType.NORMAL));
            bricks.add(new Brick(82, 6, BrickType.NORMAL));
            bricks.add(new Brick(90, 6, BrickType.NORMAL));

            bricks.add(new Brick(2, 9, BrickType.NORMAL));
            bricks.add(new Brick(10, 9, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(18, 9, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(26, 9, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(34, 9, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(42, 9, BrickType.NORMAL));
            bricks.add(new Brick(50, 9, BrickType.NORMAL));
            bricks.add(new Brick(58, 9, BrickType.NORMAL));
            bricks.add(new Brick(66, 9, BrickType.NORMAL));
            bricks.add(new Brick(74, 9, BrickType.NORMAL));
            bricks.add(new Brick(82, 9, BrickType.NORMAL));
            bricks.add(new Brick(90, 9, BrickType.NORMAL));

            bricks.add(new Brick(2, 12, BrickType.NORMAL));
            //bricks.add(new Brick(10, 12, BrickType.NORMAL));
            //bricks.add(new Brick(18, 12, BrickType.NORMAL));
            //bricks.add(new Brick(26, 12,BrickType.NORMAL));
            //bricks.add(new Brick(34, 12, BrickType.NORMAL));
            //bricks.add(new Brick(42, 12, BrickType.PADDLE_SIZE_INCREASE));
            bricks.add(new Brick(50, 12, BrickType.NORMAL));
            bricks.add(new Brick(58, 12, BrickType.NORMAL));
            bricks.add(new Brick(66, 12, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(74, 12, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(82, 12, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(90, 12, BrickType.PADDLE_SIZE_DECREASE));

            bricks.add(new Brick(2, 15, BrickType.NORMAL));
            //bricks.add(new Brick(10, 15, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(18, 15, BrickType.NORMAL));
            bricks.add(new Brick(26, 15,BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(34, 15, BrickType.NORMAL));
            //bricks.add(new Brick(42, 15, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(50, 15, BrickType.NORMAL));
            //bricks.add(new Brick(58, 15, BrickType.NORMAL));
            //bricks.add(new Brick(66, 15, BrickType.NORMAL));
            //bricks.add(new Brick(74, 15, BrickType.NORMAL));
            //bricks.add(new Brick(82, 15, BrickType.NORMAL));
            //bricks.add(new Brick(90, 15, BrickType.PADDLE_SIZE_DECREASE));

            bricks.add(new Brick(2, 18, BrickType.NORMAL));
            //bricks.add(new Brick(10, 18, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(18, 18, BrickType.NORMAL));
            bricks.add(new Brick(26, 18,BrickType.NORMAL));
            bricks.add(new Brick(34, 18, BrickType.NORMAL));
            //bricks.add(new Brick(42, 18, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(50, 18, BrickType.PADDLE_SIZE_INCREASE));
            //bricks.add(new Brick(58, 18, BrickType.NORMAL));
            bricks.add(new Brick(66, 18, BrickType.NORMAL));
            bricks.add(new Brick(74, 18, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(82, 18, BrickType.NORMAL));
            //bricks.add(new Brick(90, 18, BrickType.PADDLE_SIZE_DECREASE));

            bricks.add(new Brick(2, 21, BrickType.NORMAL));
            //bricks.add(new Brick(10, 21, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(18, 21, BrickType.PADDLE_SIZE_INCREASE));
            bricks.add(new Brick(26, 21,BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(34, 21, BrickType.PADDLE_SIZE_INCREASE));
            //bricks.add(new Brick(42, 21, BrickType.PADDLE_SIZE_DECREASE));
            bricks.add(new Brick(50, 21, BrickType.PADDLE_SIZE_INCREASE));
            //bricks.add(new Brick(58, 21, BrickType.NORMAL));
            bricks.add(new Brick(66, 21, BrickType.PADDLE_SIZE_INCREASE));
            bricks.add(new Brick(74, 21, BrickType.BALL_SPEED_INCREASE));
            bricks.add(new Brick(82, 21, BrickType.PADDLE_SIZE_INCREASE));
            //bricks.add(new Brick(90, 21, BrickType.PADDLE_SIZE_DECREASE));

            for (Brick b : bricks) {
                b.drawBrick(terminal);
            }
        }
    }
}

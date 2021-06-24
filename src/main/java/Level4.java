import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Level4 {
        public static void main(String[] args) throws IOException {
                TerminalSize ts = new TerminalSize(100, 30);
                DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
                terminalFactory.setInitialTerminalSize(ts);
                Terminal terminal = terminalFactory.createTerminal();
                terminal.setCursorVisible(false);
                Brick brick;

                List<Brick> bricks = new ArrayList<Brick>();

                bricks.add(new Brick(3, 2, BrickType.NORMAL));
                bricks.add(new Brick(15, 2, BrickType.NORMAL));
                bricks.add(new Brick(21, 2, BrickType.BALL_SPEED_INCREASE));
                bricks.add(new Brick(27, 2, BrickType.NORMAL));
                bricks.add(new Brick(33, 2, BrickType.NORMAL));
                bricks.add(new Brick(39, 2, BrickType.PADDLE_SIZE_DECREASE));
                bricks.add(new Brick(45, 2, BrickType.NORMAL));
                bricks.add(new Brick(51, 2, BrickType.NORMAL));
                bricks.add(new Brick(57, 2, BrickType.PADDLE_SIZE_DECREASE));
                bricks.add(new Brick(63, 2, BrickType.NORMAL));
                bricks.add(new Brick(69, 2, BrickType.NORMAL));
                bricks.add(new Brick(75, 2, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(81, 2, BrickType.NORMAL));
                bricks.add(new Brick(93, 2, BrickType.NORMAL));


                bricks.add(new Brick(3, 4, BrickType.NORMAL));
                bricks.add(new Brick(21, 4, BrickType.NORMAL));
                bricks.add(new Brick(27, 4, BrickType.NORMAL));
                bricks.add(new Brick(33, 4, BrickType.NORMAL));
                bricks.add(new Brick(39, 4, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(45, 4, BrickType.NORMAL));
                bricks.add(new Brick(51, 4, BrickType.NORMAL));
                bricks.add(new Brick(57, 4, BrickType.BALL_SPEED_INCREASE));
                bricks.add(new Brick(63, 4, BrickType.NORMAL));
                bricks.add(new Brick(69, 4, BrickType.NORMAL));
                bricks.add(new Brick(75, 4, BrickType.NORMAL));
                bricks.add(new Brick(93, 4, BrickType.NORMAL));


                bricks.add(new Brick(3, 6, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(27, 6, BrickType.NORMAL));
                bricks.add(new Brick(33, 6, BrickType.PADDLE_SIZE_DECREASE));
                bricks.add(new Brick(39, 6, BrickType.NORMAL));
                bricks.add(new Brick(45, 6, BrickType.BALL_SPEED_INCREASE));
                bricks.add(new Brick(51, 6, BrickType.NORMAL));
                bricks.add(new Brick(57, 6, BrickType.NORMAL));
                bricks.add(new Brick(63, 6, BrickType.PADDLE_SIZE_DECREASE));
                bricks.add(new Brick(69, 6, BrickType.NORMAL));
                bricks.add(new Brick(93, 6, BrickType.PADDLE_SIZE_INCREASE));


                bricks.add(new Brick(3, 8, BrickType.NORMAL));
                bricks.add(new Brick(33, 8, BrickType.NORMAL));
                bricks.add(new Brick(39, 8, BrickType.NORMAL));
                bricks.add(new Brick(45, 8, BrickType.NORMAL));
                bricks.add(new Brick(51, 8, BrickType.NORMAL));
                bricks.add(new Brick(57, 8, BrickType.NORMAL));
                bricks.add(new Brick(63, 8, BrickType.NORMAL));
                bricks.add(new Brick(93, 8, BrickType.NORMAL));


                bricks.add(new Brick(3, 10, BrickType.BALL_SPEED_INCREASE));
                bricks.add(new Brick(45, 10, BrickType.NORMAL));
                bricks.add(new Brick(51, 10, BrickType.NORMAL));
                bricks.add(new Brick(93, 10, BrickType.BALL_SPEED_INCREASE));


                bricks.add(new Brick(3, 12, BrickType.NORMAL));
                bricks.add(new Brick(33, 12, BrickType.NORMAL));
                bricks.add(new Brick(39, 12, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(45, 12, BrickType.NORMAL));
                bricks.add(new Brick(51, 12, BrickType.NORMAL));
                bricks.add(new Brick(57, 12, BrickType.PADDLE_SIZE_DECREASE));
                bricks.add(new Brick(63, 12, BrickType.NORMAL));
                bricks.add(new Brick(93, 12, BrickType.NORMAL));


                bricks.add(new Brick(3, 14, BrickType.PADDLE_SIZE_DECREASE));
                bricks.add(new Brick(27, 14, BrickType.NORMAL));
                bricks.add(new Brick(33, 14, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(39, 14, BrickType.NORMAL));
                bricks.add(new Brick(45, 14, BrickType.NORMAL));
                bricks.add(new Brick(51, 14, BrickType.BALL_SPEED_INCREASE));
                bricks.add(new Brick(57, 14, BrickType.NORMAL));
                bricks.add(new Brick(63, 14, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(69, 14, BrickType.NORMAL));
                bricks.add(new Brick(93, 14, BrickType.PADDLE_SIZE_DECREASE));


                bricks.add(new Brick(3, 16, BrickType.NORMAL));
                bricks.add(new Brick(21, 16, BrickType.NORMAL));
                bricks.add(new Brick(27, 16, BrickType.NORMAL));
                bricks.add(new Brick(33, 16, BrickType.NORMAL));
                bricks.add(new Brick(39, 16, BrickType.NORMAL));
                bricks.add(new Brick(45, 16, BrickType.NORMAL));
                bricks.add(new Brick(51, 16, BrickType.NORMAL));
                bricks.add(new Brick(57, 16, BrickType.NORMAL));
                bricks.add(new Brick(63, 16, BrickType.NORMAL));
                bricks.add(new Brick(69, 16, BrickType.NORMAL));
                bricks.add(new Brick(75, 16, BrickType.NORMAL));
                bricks.add(new Brick(93, 16, BrickType.NORMAL));


                bricks.add(new Brick(3, 18, BrickType.NORMAL));
                bricks.add(new Brick(15, 18, BrickType.NORMAL));
                bricks.add(new Brick(21, 18, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(27, 18, BrickType.NORMAL));
                bricks.add(new Brick(33, 18, BrickType.NORMAL));
                bricks.add(new Brick(39, 18, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(45, 18, BrickType.NORMAL));
                bricks.add(new Brick(51, 18, BrickType.NORMAL));
                bricks.add(new Brick(57, 18, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(63, 18, BrickType.NORMAL));
                bricks.add(new Brick(69, 18, BrickType.NORMAL));
                bricks.add(new Brick(75, 18, BrickType.PADDLE_SIZE_INCREASE));
                bricks.add(new Brick(81, 18, BrickType.NORMAL));
                bricks.add(new Brick(93, 18, BrickType.NORMAL));

                for (Brick br : bricks){
                        br.drawBrick(terminal);
                }


        }
}

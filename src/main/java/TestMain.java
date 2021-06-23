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
        TextGraphics tGraphics = terminal.newTextGraphics();

        List<Brick> brickList = makeBricks((terminal.getTerminalSize().getColumns() / 2), 6, 15);

        boolean invertX;
        boolean invertY;

        int x = terminal.getTerminalSize().getColumns() / 2, y = 20;

        Player player = new Player(48, 28);
        player.draw(terminal);

        Random rand = new Random();
        Ball ball = new Ball(x, y, rand.nextBoolean() ? -1 : 1, -1);
        ball.draw(terminal);

        int ballPauseCount = 0;
        List<Integer> playerJustMoved = new ArrayList<>();


        boolean isRunning = true;
        KeyStroke keyStroke;
        playerJustMoved.add(0);

        while (isRunning) {
            Thread.sleep(100);
            drawBrick(terminal, brickList);
            keyStroke = terminal.pollInput();

            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case ArrowRight:
                        player.setNewPositionPlayer(terminal, 2);
                        player.draw(terminal);
                        playerJustMoved.add(1);
                        break;
                    case ArrowLeft:
                        player.setNewPositionPlayer(terminal,-2);
                        player.draw(terminal);
                        playerJustMoved.add(-1);
                        break;
                    case Escape:
                        isRunning = false;
                        break;
                }
            }

            // Move ball
            if (ballPauseCount >= 20) {
                // Check if brick hit
                Brick brickHit = brickHit(brickList, ball);
                if (brickHit != null) {
                    if (brickHit.invertX(ball.x, ball.y)) {
                        ball.xAccel *= -1;
                    }
                    if (brickHit.invertY(ball.x, ball.y)) {
                        ball.yAccel *= -1;
                    }
                }

                ball.setNewPosition(terminal, player, playerJustMoved);
                ball.draw(terminal);
                ballPauseCount = 0;
            }
            //ball.setNewPosition(terminal);
            ball.draw(terminal);

            terminal.flush();
            ballPauseCount++;
            playerJustMoved.remove(0);
        }

        System.out.println("Quit");
        terminal.close();

    }

    private static List<Brick> makeBricks(int midPointX, int blocksY, int blocksX) {
        List<Brick> bricks = new ArrayList<>();
        int brickWidth = 4;
        int brickHeight = 1;
        for (int i = 2; i <= blocksY*brickHeight; i+=brickHeight) {
            for (int j = (midPointX - (brickWidth * (blocksX/2)));
                 j <= (midPointX + (brickWidth * (blocksX/2))); j+=brickWidth) {
                bricks.add(new Brick(j, i, brickWidth, brickHeight));
            }
        }
        return bricks;
    }

    private static void drawBrick (Terminal terminal, List<Brick> brickPos) throws IOException {
        TextColor standardColor = new TextColor.RGB(55, 55, 55);
        for (Brick b : brickPos) {
            b.drawBrick(terminal);
        }
    }

    public static Brick brickHit(List<Brick> bricks, Ball ball) {
        for (Brick b : bricks) {
            if (ball.y <= b.startY + b.heigth && ball.y >= b.startY - 1) {
                if (ball.x >= b.startX && ball.x <= b.startX + b.width) {
                    return b;
                }
            }
        }

        return null;
    }


}
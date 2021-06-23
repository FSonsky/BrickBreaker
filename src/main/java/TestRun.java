import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRun {

    public static void main(String[] args) throws IOException, InterruptedException {
        TerminalSize ts = new TerminalSize(100, 30);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        Audio audio = new Audio();

        int x = terminal.getTerminalSize().getColumns() / 2, y = 27;

        Player player = new Player(48, 28);
        player.draw(terminal);

        Random rand = new Random();
        Ball ball = new Ball(x, y, rand.nextBoolean() ? -1 : 1, -1);
        ball.draw(terminal);

        terminal.flush();

        boolean isRunning = true;
        KeyStroke keyStroke;

        int ballPauseCount = 0;
        List<Integer> playerJustMoved = new ArrayList<>();

        // Create bricks
        List<Brick> bricks = new ArrayList<>();
        addBricks(bricks);

        // Draw bricks
        for (Brick b : bricks) {
            b.drawBrick(terminal);
        }

        int resetPaddleSizeCount = 0;
        boolean isSpecialPaddleSize = false;

        int resetBallSpeedCounter = 0;
        boolean isSpecialBallSpeed = false;

        int score = 0;
        printScore(score, terminal);

        while (isRunning) {
            Thread.sleep(1);
            keyStroke = terminal.pollInput();
            playerJustMoved.add(0);


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
                Brick brickHit = brickHit(bricks, ball);
                if (brickHit != null) {
                    if (brickHit.invertX(ball.x, ball.y)) {
                        ball.xAccel *= -1;
                    }
                    if (brickHit.invertY(ball.x, ball.y)) {
                        ball.yAccel *= -1;
                    }
                    audio.playBrickHit();
                    brickHit.reduceLife();

                    if (!brickHit.isAlive()) {
                        brickHit.removeBrick(terminal);
                        bricks.remove(brickHit);
                    } else {
                        brickHit.drawBrick(terminal);
                    }

                    switch (brickHit.brickType) {
                        case PADDLE_SIZE_INCREASE:
                            player.setPaddelSize(12, terminal);
                            resetPaddleSizeCount = 30;
                            isSpecialPaddleSize = true;
                            break;
                        case PADDLE_SIZE_DECREASE:
                            player.setPaddelSize(5, terminal);
                            resetPaddleSizeCount = 30;
                            isSpecialPaddleSize = true;
                            break;
                        case BALL_SPEED_INCREASE:
                            ball.speedFactor = 2;
                            resetBallSpeedCounter = 30;
                            isSpecialBallSpeed = true;
                    }

                    score++;
                    printScore(score, terminal);
                }

                if (ball.setNewPosition(terminal, player, playerJustMoved)) {
                    audio.playPaddleHit();
                }
                ball.draw(terminal);
                ballPauseCount = 0;

                // Take care of timed resets (Paddle size / Speed)
                // Paddle size
                if (isSpecialPaddleSize && resetPaddleSizeCount == 0) {
                    player.setPaddelSize(8, terminal);
                    isSpecialPaddleSize = false;
                } else if (isSpecialPaddleSize) {
                    resetPaddleSizeCount--;
                }
                // Ball speed
                if (isSpecialBallSpeed && resetBallSpeedCounter == 0) {
                    ball.speedFactor = 1;
                    isSpecialBallSpeed = false;
                } else if (isSpecialBallSpeed) {
                    resetBallSpeedCounter--;
                }
            }

            // Check for Game Over
            if (ball.y >= terminal.getTerminalSize().getRows()) {
                String gameOver = "Game Over";
                terminal.setForegroundColor(TextColor.ANSI.RED);
                for (int i = 0; i < gameOver.length(); i++) {
                    terminal.setCursorPosition(46 + i, 15);
                    terminal.putCharacter(gameOver.charAt(i));
                }
                ball.remove(terminal);
                terminal.flush();
                audio.playGameOver();
                Thread.sleep(4000);
                break;
            }

            terminal.flush();

            ballPauseCount++;
            playerJustMoved.remove(0);
        }

        System.out.println("Quit");
        terminal.close();
    }

    private static void addBricks(List<Brick> bricks) {
        bricks.add(new Brick(10, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(20, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(30, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(40, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(50, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(60, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(70, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(80, 10, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(90, 10, BrickType.PADDLE_SIZE_DECREASE));
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

    private static void printScore(int score, Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.WHITE);
        String text = "Score: " + score;
        for (int i = text.length() - 1; i >= 0; i--) {
            terminal.setCursorPosition(1 + i, 1);
            terminal.putCharacter(text.charAt(i));
        }
    }
}

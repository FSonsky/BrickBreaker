import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        Level1 level = new Level1();
        List<Brick> bricks = level.bricks;

        // Draw bricks
        for (Brick b : bricks) {
            b.drawBrick(terminal);
        }

        int resetPaddleSizeCount = 0;
        boolean isSpecialPaddleSize = false;

        int resetBallSpeedCounter = 0;
        boolean isSpecialBallSpeed = false;

        int score = 0;
        final int highScore = readHighScoreFromFile();
        printScore(score, highScore, terminal);

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
                            audio.playPaddleSizeBrickHit();
                            break;
                        case PADDLE_SIZE_DECREASE:
                            player.setPaddelSize(5, terminal);
                            resetPaddleSizeCount = 30;
                            isSpecialPaddleSize = true;
                            audio.playPaddleSizeBrickHit();
                            break;
                        case BALL_SPEED_INCREASE:
                            ball.speedFactor = 2;
                            resetBallSpeedCounter = 30;
                            isSpecialBallSpeed = true;
                            audio.playSpeedBrickHit();
                        default:
                            audio.playBrickHit();
                            break;
                    }

                    score++;
                    printScore(score, highScore, terminal);
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

        if (score > highScore) {
            saveScore(score);
        }

        terminal.close();
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

    private static void printScore(int score, int highScore, Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.WHITE);
        terminal.enableSGR(SGR.UNDERLINE);
        String text = "Score: " + score + "  Best: " + highScore;
        for (int i = text.length() - 1; i >= 0; i--) {
            terminal.setCursorPosition(1 + i, 1);
            terminal.putCharacter(text.charAt(i));
        }

        for (int i = text.length(); i < 100; i++) {
            terminal.setCursorPosition(1 + i, 1);
            terminal.putCharacter(' ');
        }
        terminal.disableSGR(SGR.UNDERLINE);
    }

    private static void saveScore(int score) {
        try {
            FileWriter myWriter = new FileWriter("highScore.txt");
            myWriter.write(Integer.toString(score));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static int readHighScoreFromFile() {
        int highScore = 0;
        try {
            File myObj = new File("highScore.txt");
            Scanner myReader = new Scanner(myObj);
            highScore = myReader.nextInt();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return highScore;
    }
}

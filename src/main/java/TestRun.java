import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

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

        drawMenu(terminal);

        boolean isRunning = true;
        KeyStroke keyStroke;
        //Audio audio = new Audio();
        //audio.playTheme();
        while (isRunning) {
            keyStroke = terminal.pollInput();
            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case Character:
                        char c = keyStroke.getCharacter();
                        if (c == '1') {
                            terminal.clearScreen();
                            //audio.clip.stop();
                            runGame(terminal, 1);
                            drawMenu(terminal);
                            //audio.clip.start();
                        } else if (c == '2') {
                            terminal.clearScreen();
                            viewLevels(terminal);
                            drawMenu(terminal);
                        }
                        break;
                    case Escape:
                        isRunning = false;
                        break;
                }
            }

            Thread.sleep(10);
        }

        //audio.clip.stop();
        terminal.close();
    }

    public static void drawMenu(Terminal terminal) throws IOException {
        terminal.clearScreen();
        terminal.setForegroundColor(TextColor.ANSI.RED);
        // Frame
        terminal.setCursorPosition(42, 9);
        terminal.putCharacter('\u25DC');
        terminal.setCursorPosition(58, 9);
        terminal.putCharacter('\u25DD');

        for (int i = 0; i < 15; i++) {
            terminal.setCursorPosition(43 + i, 9);
            terminal.putCharacter('-');
        }

        terminal.setCursorPosition(42, 17);
        terminal.putCharacter('\u25DF');
        terminal.setCursorPosition(58, 17);
        terminal.putCharacter('\u25DE');

        for (int i = 0; i < 15; i++) {
            terminal.setCursorPosition(43 + i, 17);
            terminal.putCharacter('-');
        }

        for (int i = 0; i < 7; i++) {
            terminal.setCursorPosition(42, 10 + i);
            terminal.putCharacter('|');
        }

        for (int i = 0; i < 7; i++) {
            terminal.setCursorPosition(58, 10 + i);
            terminal.putCharacter('|');
        }

        // Menu text
        String text = "Brick Breaker";
        terminal.enableSGR(SGR.BOLD);
        terminal.enableSGR(SGR.UNDERLINE);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition((50 - 6) + i, 10);
            terminal.putCharacter(text.charAt(i));
        }
        terminal.disableSGR(SGR.BOLD);
        terminal.disableSGR(SGR.UNDERLINE);

        text = "1. Play Game";
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition((50 - 6) + i, 12);
            terminal.putCharacter(text.charAt(i));
        }

        text = "2. View Levels";
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition((50 - 6) + i, 14);
            terminal.putCharacter(text.charAt(i));
        }

        text = "Esc. Quit";
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition((50 - 6) + i, 16);
            terminal.putCharacter(text.charAt(i));
        }

        text = "Created by: Daniel Gidlund, Marie Svensson, Frederik Sonsky, Sebastian Berg";
        terminal.setForegroundColor(TextColor.ANSI.CYAN);
        terminal.enableSGR(SGR.ITALIC);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition(1 + i, 28);
            terminal.putCharacter(text.charAt(i));
        }
        terminal.disableSGR(SGR.ITALIC);
        terminal.flush();
    }

    private static void runGame(Terminal terminal, int currentLevel) throws IOException, InterruptedException {
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
        Levels levels = new Levels();
        List<Brick> bricks = levels.levels.get(currentLevel - 1);

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
            Thread.sleep(5);
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
                        // TODO remove clear()
                        //bricks.clear();
                        // Check for level complete
                        if (bricks.isEmpty()) {
                            levelComplete(terminal, audio);
                            currentLevel++;
                            if (currentLevel > levels.levels.size()) {
                                levels = new Levels();
                                currentLevel = 1;
                            }
                            bricks = levels.levels.get(currentLevel - 1);
                            // Draw bricks
                            for (Brick b : bricks) {
                                b.drawBrick(terminal);
                            }
                            ball = new Ball(50, 27, rand.nextBoolean() ? -1 : 1, -1);
                            ball.draw(terminal);
                            player = new Player(48, 28);
                            player.draw(terminal);
                            terminal.flush();
                            continue;
                        }
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
            if (!playerJustMoved.isEmpty()) {
                playerJustMoved.remove(0);
            }
        }

        System.out.println("Quit");

        if (score > highScore) {
            saveScore(score);
        }
    }

    private static void viewLevels(Terminal terminal) throws IOException {
        terminal.clearScreen();
        Levels levels = new Levels();
        int selectedLevel = 1;
        boolean isRunning = true;
        KeyStroke keyStroke;

        drawLevel(terminal, selectedLevel, levels);

        while (isRunning) {
            keyStroke = terminal.pollInput();

            if (keyStroke != null) {

                switch (keyStroke.getKeyType()) {
                    case ArrowLeft:
                        if (selectedLevel > 1) {
                            selectedLevel--;
                            drawLevel(terminal, selectedLevel, levels);
                        }
                        break;
                    case ArrowRight:
                        if (selectedLevel < levels.levels.size()) {
                            selectedLevel++;
                            drawLevel(terminal, selectedLevel, levels);
                        }
                        break;
                    case Escape:
                        isRunning = false;
                        break;
                }
            }
        }
    }

    private static void drawLevel(Terminal terminal, int level, Levels levels) throws IOException {
        terminal.clearScreen();
        String text = "Level " + level + " of " + levels.levels.size();
        terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition(1 + i, 1);
            terminal.putCharacter(text.charAt(i));
        }

        text = "\u2190 Prev   Next \u2192";
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition(50 - (text.length() / 2) + i, 28);
            terminal.putCharacter(text.charAt(i));
        }

        text = "ESC: Back";
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition(1 + i, 28);
            terminal.putCharacter(text.charAt(i));
        }

        List<Brick> bricks = levels.levels.get(level - 1);
        for (Brick brick : bricks) {
            brick.drawBrick(terminal);
        }

        terminal.flush();
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

    private static void levelComplete(Terminal terminal, Audio audio) throws IOException, InterruptedException {
        String text = "Level Complete";
        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition(43 + i, 15);
            terminal.putCharacter(text.charAt(i));
        }
        terminal.flush();
        audio.playLevelComplete();
        Thread.sleep(5000);
        for (int i = 0; i < text.length(); i++) {
            terminal.setCursorPosition(43 + i, 15);
            terminal.putCharacter(' ');
        }
        terminal.flush();
        terminal.clearScreen();
    }
}

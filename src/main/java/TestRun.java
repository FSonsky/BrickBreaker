import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Random;

public class TestRun {

    public static void main(String[] args) throws IOException, InterruptedException {
        //TerminalSize ts = new TerminalSize(400, 420);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        //terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        int x = terminal.getTerminalSize().getColumns() / 2, y = 20;

        Player player = new Player(40, 22);
        player.draw(terminal);

        Random rand = new Random();
        Ball ball = new Ball(x, y, rand.nextBoolean() ? -1 : 1, -1);
        ball.draw(terminal);

        terminal.flush();

        boolean isRunning = true;
        KeyStroke keyStroke;

        int ballPauseCount = 0;

        while (isRunning) {
            Thread.sleep(1);
            keyStroke = terminal.pollInput();
            int playerJustMoved = 0;

            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case ArrowRight:
                        player.setNewPositionPlayer(terminal, 1);
                        player.draw(terminal);
                        playerJustMoved = 1;
                        break;
                    case ArrowLeft:
                        player.setNewPositionPlayer(terminal,-1);
                        player.draw(terminal);
                        playerJustMoved = -1;
                        break;
                    case Escape:
                        isRunning = false;
                        break;
                }
            }

            // Move ball
            if (ballPauseCount >= 30) {
                ball.setNewPosition(terminal, player, playerJustMoved);
                ball.draw(terminal);
                ballPauseCount = 0;
            }

            // Check for Game Over
            if (ball.y >= terminal.getTerminalSize().getRows()) {
                String gameOver = "Game Over";
                terminal.setForegroundColor(TextColor.ANSI.RED);
                for (int i = 0; i < gameOver.length(); i++) {
                    terminal.setCursorPosition(35 + i, 12);
                    terminal.putCharacter(gameOver.charAt(i));
                }
                terminal.flush();
                Thread.sleep(4000);
                break;
            }

            terminal.flush();

            ballPauseCount++;
        }

        System.out.println("Quit");
        terminal.close();
    }
}

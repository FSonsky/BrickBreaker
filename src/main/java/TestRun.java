import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TestRun {

    public static void main(String[] args) throws IOException, InterruptedException {
        //TerminalSize ts = new TerminalSize(400, 420);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        //terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        int x = terminal.getTerminalSize().getColumns() / 2, y = 20;

        Ball ball = new Ball(x, y, 1, -1);
        ball.draw(terminal);

        boolean isRunning = true;
        KeyStroke keyStroke;

        while (isRunning) {
            Thread.sleep(100);
            keyStroke = terminal.pollInput();

            if (keyStroke != null) {
                if (keyStroke.getKeyType() == KeyType.Escape) {
                    isRunning = false;
                }
            }

            // Move ball
            ball.setNewPosition(terminal);
            ball.draw(terminal);

            terminal.flush();
        }

        System.out.println("Quit");
        terminal.close();
    }
}

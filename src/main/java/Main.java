import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //TerminalSize ts = new TerminalSize(400, 420);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        //terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
    }
}

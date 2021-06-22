import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
public class Paddel {



    public static void main(String[]args) throws IOException, InterruptedException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        terminal.setCursorVisible(false);







        /*tGraphics.drawRectangle(
                new TerminalPosition(40,22), new TerminalSize(5,1), '*');
        screen.refresh();*/

        //int x = 40;
        //int y = 22;
        Player player = new Player(40, 22);


       player.draw(terminal);

        boolean continueReadingInput = true;
        while(continueReadingInput) {

            KeyStroke keyStroke = null;
            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
            } while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();

            if (c == Character.valueOf('q')) {
                continueReadingInput = false;
                terminal.close();
                System.out.println("Leaving program");
            }

            Player oldPosition = new Player(player.x, player.y);

            switch (keyStroke.getKeyType()){
                case ArrowRight:
                    player.setNewPositionPlayer(terminal, 1);
                    break;
                case ArrowLeft:
                    player.setNewPositionPlayer(terminal,-1);
                    break;
            }
            player.draw(terminal);
            terminal.flush();
        }

        screen.readInput();
        screen.stopScreen();
    }
}

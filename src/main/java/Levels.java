import java.util.ArrayList;
import java.util.List;

public class Levels {
    List<List> levels;

    public Levels() {
        levels = new ArrayList<>();
        levels.add(new Level1().bricks);
        levels.add(new Level2().bricks);
        levels.add(new LevelF().bricks);
        levels.add(new Level3().bricks);
    }
}

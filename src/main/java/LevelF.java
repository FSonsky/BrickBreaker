import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelF {
    List<Brick> bricks = new ArrayList<>();

    public LevelF() {
        // Left cluster
        for (int i = 0; i < 7; i++) {
            bricks.add(new Brick(19, 6+(i*2), getBrickType()));
        }
        for (int i = 0; i < 5; i++) {
            bricks.add(new Brick(25, 8+(i*2), getBrickType()));
        }
        for (int i = 0; i < 3; i++) {
            bricks.add(new Brick(31, 10+(i*2), getBrickType()));
        }
        for (int i = 0; i < 1; i++) {
            bricks.add(new Brick(37, 12+(i*2), getBrickType()));
        }
        for (int i = 0; i < 5; i++) {
            bricks.add(new Brick(13, 8+(i*2), getBrickType()));
        }
        for (int i = 0; i < 3; i++) {
            bricks.add(new Brick(7, 10+(i*2), getBrickType()));
        }
        for (int i = 0; i < 1; i++) {
            bricks.add(new Brick(1, 12+(i*2), getBrickType()));
        }

        // Right cluster
        for (int i = 0; i < 1; i++) {
            bricks.add(new Brick(58, 12+(i*2), getBrickType()));
        }
        for (int i = 0; i < 3; i++) {
            bricks.add(new Brick(64, 10+(i*2), getBrickType()));
        }
        for (int i = 0; i < 5; i++) {
            bricks.add(new Brick(70, 8+(i*2), getBrickType()));
        }
        for (int i = 0; i < 7; i++) {
            bricks.add(new Brick(76, 6+(i*2), getBrickType()));
        }
        for (int i = 0; i < 5; i++) {
            bricks.add(new Brick(82, 8+(i*2), getBrickType()));
        }
        for (int i = 0; i < 3; i++) {
            bricks.add(new Brick(88, 10+(i*2), getBrickType()));
        }
        for (int i = 0; i < 1; i++) {
            bricks.add(new Brick(94, 12+(i*2), getBrickType()));
        }

        // Top cluster
        for (int i = 0; i < 7; i++) {
            bricks.add(new Brick(30 + (i * 6), 3, getBrickType()));
        }
        for (int i = 0; i < 5; i++) {
            bricks.add(new Brick(36 + (i * 6), 5, getBrickType()));
        }
        for (int i = 0; i < 3; i++) {
            bricks.add(new Brick(42 + (i * 6), 7, getBrickType()));
        }
        for (int i = 0; i < 1; i++) {
            bricks.add(new Brick(48 + (i * 6), 9, getBrickType()));
        }
    }

    private BrickType getBrickType() {
        Random rand = new Random();
        int value = rand.nextInt(12) + 1;
        if (value == 1) {
            return BrickType.BALL_SPEED_INCREASE;
        } else if (value == 2) {
            return BrickType.PADDLE_SIZE_DECREASE;
        } else if (value == 3) {
            return BrickType.PADDLE_SIZE_INCREASE;
        }

        return BrickType.NORMAL;
    }
}

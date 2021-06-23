import java.util.ArrayList;
import java.util.List;

public class Level1 {

    List<Brick> bricks = new ArrayList<>();

    public Level1() {
        bricks.add(new Brick(2, 3, BrickType.NORMAL));
        bricks.add(new Brick(10, 3, BrickType.NORMAL));
        bricks.add(new Brick(18, 3, BrickType.NORMAL));
        bricks.add(new Brick(26, 3,BrickType.NORMAL));
        bricks.add(new Brick(34, 3, BrickType.NORMAL));
        bricks.add(new Brick(42, 3, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(50, 3, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(58, 3, BrickType.NORMAL));
        bricks.add(new Brick(66, 3, BrickType.NORMAL));
        bricks.add(new Brick(74, 3, BrickType.NORMAL));
        bricks.add(new Brick(82, 3, BrickType.NORMAL));
        bricks.add(new Brick(90, 3, BrickType.BALL_SPEED_INCREASE));

        bricks.add(new Brick(2, 6, BrickType.NORMAL));
        bricks.add(new Brick(10, 6, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(18, 6, BrickType.NORMAL));
        bricks.add(new Brick(26, 6,BrickType.NORMAL));
        //bricks.add(new Brick(34, 6, BrickType.NORMAL));
        //bricks.add(new Brick(42, 6, BrickType.NORMAL));
        //bricks.add(new Brick(50, 6, BrickType.NORMAL));
        //bricks.add(new Brick(58, 6, BrickType.NORMAL));
        bricks.add(new Brick(66, 6, BrickType.NORMAL));
        bricks.add(new Brick(74, 6, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(82, 6, BrickType.NORMAL));
        bricks.add(new Brick(90, 6, BrickType.NORMAL));

        bricks.add(new Brick(2, 9, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(10, 9, BrickType.NORMAL));
        bricks.add(new Brick(18, 9, BrickType.NORMAL));
        bricks.add(new Brick(26, 9,BrickType.NORMAL));
        //bricks.add(new Brick(34, 9, BrickType.NORMAL));
        bricks.add(new Brick(42, 9, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(50, 9, BrickType.BALL_SPEED_INCREASE));
        //bricks.add(new Brick(58, 9, BrickType.NORMAL));
        bricks.add(new Brick(66, 9, BrickType.NORMAL));
        bricks.add(new Brick(74, 9, BrickType.NORMAL));
        bricks.add(new Brick(82, 9, BrickType.NORMAL));
        bricks.add(new Brick(90, 9, BrickType.NORMAL));

        bricks.add(new Brick(2, 12, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(10, 12, BrickType.NORMAL));
        bricks.add(new Brick(18, 12, BrickType.NORMAL));
        //bricks.add(new Brick(26, 12,BrickType.NORMAL));
        //bricks.add(new Brick(34, 12, BrickType.NORMAL));
        bricks.add(new Brick(42, 12, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(50, 12, BrickType.NORMAL));
        //bricks.add(new Brick(58, 12, BrickType.NORMAL));
        //bricks.add(new Brick(66, 12, BrickType.NORMAL));
        bricks.add(new Brick(74, 12, BrickType.NORMAL));
        bricks.add(new Brick(82, 12, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(90, 12, BrickType.NORMAL));

        bricks.add(new Brick(2, 15, BrickType.NORMAL));
        bricks.add(new Brick(10, 15, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(18, 15, BrickType.NORMAL));
        //bricks.add(new Brick(26, 12,BrickType.NORMAL));
        //bricks.add(new Brick(34, 12, BrickType.NORMAL));
        bricks.add(new Brick(42, 15, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(50, 15, BrickType.NORMAL));
        //bricks.add(new Brick(58, 12, BrickType.NORMAL));
        //bricks.add(new Brick(66, 12, BrickType.NORMAL));
        bricks.add(new Brick(74, 15, BrickType.NORMAL));
        bricks.add(new Brick(82, 15, BrickType.NORMAL));
        bricks.add(new Brick(90, 15, BrickType.PADDLE_SIZE_DECREASE));
    }
}

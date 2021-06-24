import java.util.ArrayList;
import java.util.List;

public class Level2 {

    List<Brick> bricks = new ArrayList<>();

    public Level2() {
        bricks.add(new Brick(37, 1, BrickType.NORMAL));
        bricks.add(new Brick(44, 1, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(51, 1, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(58, 1, BrickType.NORMAL));

        bricks.add(new Brick(2, 3, BrickType.NORMAL));
        //bricks.add(new Brick(9, 3, BrickType.NORMAL));
        //bricks.add(new Brick(16, 3, BrickType.NORMAL));
        bricks.add(new Brick(23, 3, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(30, 3, BrickType.NORMAL));
        bricks.add(new Brick(37, 3, BrickType.NORMAL));
        //bricks.add(new Brick(44, 3, BrickType.NORMAL));
        //bricks.add(new Brick(51, 3, BrickType.NORMAL));
        bricks.add(new Brick(58, 3, BrickType.NORMAL));
        bricks.add(new Brick(65, 3, BrickType.NORMAL));
        bricks.add(new Brick(72, 3, BrickType.PADDLE_SIZE_INCREASE));
        //bricks.add(new Brick(79, 3, BrickType.NORMAL));
        //bricks.add(new Brick(86, 3, BrickType.NORMAL));
        bricks.add(new Brick(93, 3, BrickType.NORMAL));

        bricks.add(new Brick(2, 5, BrickType.BALL_SPEED_INCREASE));
        //bricks.add(new Brick(9, 5, BrickType.NORMAL));
        bricks.add(new Brick(16, 5, BrickType.NORMAL));
        bricks.add(new Brick(23, 5, BrickType.NORMAL));
        bricks.add(new Brick(30, 5, BrickType.NORMAL));
        bricks.add(new Brick(37, 5, BrickType.NORMAL));
        //bricks.add(new Brick(44, 5, BrickType.NORMAL));
        //bricks.add(new Brick(51, 5, BrickType.NORMAL));
        bricks.add(new Brick(58, 5, BrickType.NORMAL));
        bricks.add(new Brick(65, 5, BrickType.NORMAL));
        bricks.add(new Brick(72, 5, BrickType.NORMAL));
        bricks.add(new Brick(79, 5, BrickType.NORMAL));
        //bricks.add(new Brick(86, 5, BrickType.NORMAL));
        bricks.add(new Brick(93, 5, BrickType.BALL_SPEED_INCREASE));

        //bricks.add(new Brick(2, 7, BrickType.NORMAL));
        //bricks.add(new Brick(9, 7, BrickType.NORMAL));
        bricks.add(new Brick(16, 7, BrickType.NORMAL));
        bricks.add(new Brick(23, 7, BrickType.NORMAL));
        bricks.add(new Brick(30, 7, BrickType.NORMAL));
        bricks.add(new Brick(37, 7, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(44, 7, BrickType.NORMAL));
        bricks.add(new Brick(51, 7, BrickType.NORMAL));
        bricks.add(new Brick(58, 7, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(65, 7, BrickType.NORMAL));
        bricks.add(new Brick(72, 7, BrickType.NORMAL));
        bricks.add(new Brick(79, 7, BrickType.NORMAL));
        //bricks.add(new Brick(86, 7, BrickType.NORMAL));
        //bricks.add(new Brick(93, 7, BrickType.NORMAL));

        bricks.add(new Brick(2, 9, BrickType.PADDLE_SIZE_DECREASE));
        //bricks.add(new Brick(9, 9, BrickType.NORMAL));
        //bricks.add(new Brick(16, 9, BrickType.NORMAL));
        bricks.add(new Brick(23, 9, BrickType.NORMAL));
        bricks.add(new Brick(30, 9, BrickType.NORMAL));
        bricks.add(new Brick(37, 9, BrickType.NORMAL));
        //bricks.add(new Brick(44, 9, BrickType.NORMAL));
        //bricks.add(new Brick(51, 9, BrickType.NORMAL));
        bricks.add(new Brick(58, 9, BrickType.NORMAL));
        bricks.add(new Brick(65, 9, BrickType.NORMAL));
        bricks.add(new Brick(72, 9, BrickType.NORMAL));
        //bricks.add(new Brick(79, 9, BrickType.NORMAL));
        //bricks.add(new Brick(86, 9, BrickType.NORMAL));
        bricks.add(new Brick(93, 9, BrickType.PADDLE_SIZE_INCREASE));

        bricks.add(new Brick(2, 11, BrickType.NORMAL));
        bricks.add(new Brick(9, 11, BrickType.NORMAL));
        //bricks.add(new Brick(16, 11, BrickType.NORMAL));
        //bricks.add(new Brick(23, 11, BrickType.NORMAL));
        bricks.add(new Brick(30, 11, BrickType.NORMAL));
        bricks.add(new Brick(37, 11, BrickType.NORMAL));
        //bricks.add(new Brick(44, 11, BrickType.NORMAL));
        //bricks.add(new Brick(51, 11, BrickType.NORMAL));
        bricks.add(new Brick(58, 11, BrickType.NORMAL));
        bricks.add(new Brick(65, 11, BrickType.NORMAL));
        //bricks.add(new Brick(72, 11, BrickType.NORMAL));
        //bricks.add(new Brick(79, 11, BrickType.NORMAL));
        bricks.add(new Brick(86, 11, BrickType.NORMAL));
        bricks.add(new Brick(93, 11, BrickType.NORMAL));

        bricks.add(new Brick(2, 13, BrickType.NORMAL));
        bricks.add(new Brick(9, 13, BrickType.NORMAL));
        bricks.add(new Brick(16, 13, BrickType.NORMAL));
        //bricks.add(new Brick(23, 13, BrickType.NORMAL));
        //bricks.add(new Brick(30, 13, BrickType.NORMAL));
        bricks.add(new Brick(37, 13, BrickType.NORMAL));
        bricks.add(new Brick(44, 13, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(51, 13, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(58, 13, BrickType.NORMAL));
        //bricks.add(new Brick(65, 13, BrickType.NORMAL));
        //bricks.add(new Brick(72, 13, BrickType.NORMAL));
        bricks.add(new Brick(79, 13, BrickType.NORMAL));
        bricks.add(new Brick(86, 13, BrickType.NORMAL));
        bricks.add(new Brick(93, 13, BrickType.NORMAL));
    }
}

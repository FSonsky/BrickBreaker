import java.util.ArrayList;
import java.util.List;

public class LevelSB {
    List<Brick> bricks = new ArrayList<>();

    public LevelSB() {


        bricks.add(new Brick(4, 5, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(11, 5, BrickType.NORMAL));
        //bricks.add(new Brick(16, 5, BrickType.NORMAL));
        bricks.add(new Brick(33, 5, BrickType.NORMAL));
        bricks.add(new Brick(40, 5, BrickType.NORMAL));
        //bricks.add(new Brick(37, 5, BrickType.NORMAL));
        //bricks.add(new Brick(46, 5, BrickType.NORMAL));
        //bricks.add(new Brick(53, 5, BrickType.NORMAL));
        //bricks.add(new Brick(58, 5, BrickType.NORMAL));
        bricks.add(new Brick(56, 5, BrickType.NORMAL));
        bricks.add(new Brick(64, 5, BrickType.NORMAL));
        //bricks.add(new Brick(79, 5, BrickType.NORMAL));
        bricks.add(new Brick(84, 5, BrickType.NORMAL));
        bricks.add(new Brick(91, 5, BrickType.BALL_SPEED_INCREASE));

        bricks.add(new Brick(2, 7, BrickType.NORMAL));
        bricks.add(new Brick(9, 7, BrickType.NORMAL));
        bricks.add(new Brick(16, 7, BrickType.NORMAL));
        //bricks.add(new Brick(23, 7, BrickType.NORMAL));
        bricks.add(new Brick(30, 7, BrickType.NORMAL));
        bricks.add(new Brick(37, 7, BrickType.BALL_SPEED_INCREASE));
        //bricks.add(new Brick(44, 7, BrickType.NORMAL));
        //bricks.add(new Brick(51, 7, BrickType.NORMAL));
        bricks.add(new Brick(58, 7, BrickType.BALL_SPEED_INCREASE));
        bricks.add(new Brick(65, 7, BrickType.NORMAL));
        //bricks.add(new Brick(72, 7, BrickType.NORMAL));
        bricks.add(new Brick(79, 7, BrickType.NORMAL));
        bricks.add(new Brick(86, 7, BrickType.NORMAL));
        bricks.add(new Brick(93, 7, BrickType.NORMAL));

        bricks.add(new Brick(4, 9, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(11, 9, BrickType.NORMAL));
        bricks.add(new Brick(18, 9, BrickType.NORMAL));
        //bricks.add(new Brick(25, 9, BrickType.NORMAL));
        bricks.add(new Brick(32, 9, BrickType.NORMAL));
        bricks.add(new Brick(39, 9, BrickType.PADDLE_SIZE_DECREASE));
        //bricks.add(new Brick(44, 9, BrickType.NORMAL));
        //bricks.add(new Brick(51, 9, BrickType.NORMAL));
        bricks.add(new Brick(56, 9, BrickType.NORMAL));
        bricks.add(new Brick(63, 9, BrickType.NORMAL));
        //bricks.add(new Brick(70, 9, BrickType.NORMAL));
        bricks.add(new Brick(77, 9, BrickType.NORMAL));
        bricks.add(new Brick(84, 9, BrickType.NORMAL));
        bricks.add(new Brick(91, 9, BrickType.PADDLE_SIZE_INCREASE));

        bricks.add(new Brick(2, 11, BrickType.NORMAL));
        bricks.add(new Brick(9, 11, BrickType.NORMAL));
        bricks.add(new Brick(16, 11, BrickType.BALL_SPEED_INCREASE));
        //bricks.add(new Brick(23, 11, BrickType.NORMAL));
        bricks.add(new Brick(30, 11, BrickType.NORMAL));
        bricks.add(new Brick(37, 11, BrickType.NORMAL));
        //bricks.add(new Brick(44, 11, BrickType.NORMAL));
        //bricks.add(new Brick(51, 11, BrickType.NORMAL));
        bricks.add(new Brick(58, 11, BrickType.NORMAL));
        bricks.add(new Brick(65, 11, BrickType.NORMAL));
        //bricks.add(new Brick(72, 11, BrickType.NORMAL));
        bricks.add(new Brick(79, 11, BrickType.NORMAL));
        bricks.add(new Brick(86, 11, BrickType.NORMAL));
        bricks.add(new Brick(93, 11, BrickType.NORMAL));

        //bricks.add(new Brick(2, 13, BrickType.NORMAL));
        bricks.add(new Brick(5, 13, BrickType.NORMAL));
        bricks.add(new Brick(12, 13, BrickType.NORMAL));
        bricks.add(new Brick(19, 13, BrickType.PADDLE_SIZE_INCREASE));
        //bricks.add(new Brick(26, 13, BrickType.NORMAL));
        bricks.add(new Brick(33, 13, BrickType.NORMAL));
        bricks.add(new Brick(40, 13, BrickType.NORMAL));
        bricks.add(new Brick(55, 13, BrickType.NORMAL));
        bricks.add(new Brick(62, 13, BrickType.NORMAL));
        //bricks.add(new Brick(69, 13, BrickType.NORMAL));
        bricks.add(new Brick(76, 13, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(83, 13, BrickType.NORMAL));
        bricks.add(new Brick(90, 13, BrickType.NORMAL));
        //bricks.add(new Brick(93, 13, BrickType.NORMAL));

        bricks.add(new Brick(34, 15, BrickType.BALL_SPEED_INCREASE));
        //bricks.add(new Brick(44, 15, BrickType.PADDLE_SIZE_INCREASE));
        //bricks.add(new Brick(51, 15, BrickType.PADDLE_SIZE_DECREASE));
        bricks.add(new Brick(61, 15, BrickType.BALL_SPEED_INCREASE));

        //bricks.add(new Brick(2, 17, BrickType.NORMAL));
        bricks.add(new Brick(9, 17, BrickType.NORMAL));
        bricks.add(new Brick(16, 17, BrickType.NORMAL));
        bricks.add(new Brick(23, 17, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(30, 17, BrickType.NORMAL));
        bricks.add(new Brick(37, 17, BrickType.NORMAL));
        //bricks.add(new Brick(44, 17, BrickType.NORMAL));
        //bricks.add(new Brick(51, 17, BrickType.NORMAL));
        bricks.add(new Brick(58, 17, BrickType.NORMAL));
        bricks.add(new Brick(65, 17, BrickType.NORMAL));
        bricks.add(new Brick(72, 17, BrickType.PADDLE_SIZE_INCREASE));
        bricks.add(new Brick(79, 17, BrickType.NORMAL));
        bricks.add(new Brick(86, 17, BrickType.NORMAL));
        //bricks.add(new Brick(93, 17, BrickType.NORMAL));
    }
}

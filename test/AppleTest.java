import game.*;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class AppleTest {

    @Test
    public void spawnTest(){
        Snake snake = new Snake();
        Apple apple = new Apple(snake, Color.RED, new Position(3, 2));
        apple.spawn();
        Position pos = apple.getPos();

        for(int i = 0; i < snake.getSnake().size(); i++) {
            Position snakeBody = snake.getSnake().get(i);
            Assert.assertFalse(pos.getX() == snakeBody.getX() && pos.getY() == snakeBody.getY());
        }
    }

    @Test
    public void eatenTest(){
        Snake snake = new Snake();
        Apple apple = new Apple(snake, Color.RED, new Position(3, 2));
        apple.setPos(4, 6);
        snake.move(snake.getActual());
        Assert.assertTrue(apple.isEaten());
    }
}

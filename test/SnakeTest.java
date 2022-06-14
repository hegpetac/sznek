import game.*;
import org.junit.Assert;
import org.junit.Test;

public class SnakeTest {

    @Test
    public void testGrow(){
        Snake snake = new Snake();
        int snakeBaseSize = snake.getSnake().size();
        snake.grow(new Position(5, 9));
        int snakeGrownSize = snake.getSnake().size();
        Assert.assertEquals(snakeBaseSize + 1, snakeGrownSize);
    }

    @Test
    public void testMove(){
        Snake snake = new Snake();
        Position pos = new Position(4, 6);
        snake.move(snake.getActual());
        Position snakeHead = snake.getSnake().get(0);
        Assert.assertTrue(snakeHead.getX() == pos.getX() && snakeHead.getY() == pos.getY());
    }

    @Test
    public void testCollision(){
        Snake snake = new Snake();
        snake.move(Direction.UP);
        snake.move(Direction.RIGHT);
        snake.move(Direction.DOWN);
        Assert.assertTrue(snake.collision());
    }
}

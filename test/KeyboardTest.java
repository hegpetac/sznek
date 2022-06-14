import game.*;
import org.junit.Assert;
import org.junit.Test;

public class KeyboardTest {

    @Test
    public void invertTest(){
        Snake snake = new Snake();
        Keyboard keyboard = new Keyboard(snake);
        PoisonedApple poisonedApple = new PoisonedApple(snake, keyboard, new Position(4, 6));
        poisonedApple.effect(3, 0);
        Assert.assertTrue(keyboard.isInvert());
        poisonedApple.countereffect();
        Assert.assertFalse(keyboard.isInvert());
    }
}

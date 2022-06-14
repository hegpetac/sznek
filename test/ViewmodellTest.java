import game.*;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.View;
import java.util.ArrayList;

public class ViewmodellTest {

    @Test
    public void goldenAppleTest(){
        Snake snake = new Snake();
        Viewmodell viewmodell = new Viewmodell("vm");
        GoldenApple goldenApple = new GoldenApple(snake, viewmodell, new Position(15, 16));
        goldenApple.effect(0, 1);
        Assert.assertEquals(viewmodell.getBasescore(), 200);
        goldenApple.countereffect();
        Assert.assertEquals(viewmodell.getBasescore(), 100);
    }

    @Test
    public void greenAppleTest(){
        Snake snake = new Snake();
        Viewmodell viewmodell = new Viewmodell("vm");
        GreenApple greenApple = new GreenApple(snake, viewmodell, new Position(6, 0));
        greenApple.effect(1, 0);
        Assert.assertEquals(viewmodell.getTickrate(), 150);
        greenApple.countereffect();
        Assert.assertEquals(viewmodell.getTickrate(), 300);
    }

    @Test
    public void loadTest(){
        Viewmodell viewmodell = new Viewmodell("vm");
        ArrayList<Score> scores = viewmodell.load("scores");
        viewmodell.list(scores);
        for(int i = 0; i < scores.size() - 1; i++){
            Assert.assertTrue(scores.get(4).getHighscore() > scores.get(i).getHighscore());
        }
    }

    @Test
    public void highscoreTest(){
        int testvalue = 10000000;
        Viewmodell viewmodell = new Viewmodell("vm");
        ArrayList<Score> scores = viewmodell.load("scores");
        scores.add(new Score("Test", testvalue));
        viewmodell.list(scores);
        Assert.assertEquals(testvalue, scores.get(4).getHighscore());
    }
}

package game;

import java.awt.*;

public class PoisonedApple extends Apple{
    private Keyboard kb;

    /**
     * Beállítja a példány attribútumait a megfelelő értékre.
     * @param snake kapott snake
     * @param keyboard kapott keyboard
     */
    public PoisonedApple(Snake snake, Keyboard keyboard, Position pos){
        super(snake, new Color(101, 67,33), pos);
        kb = keyboard;
    }

    /**
     * átállítja a hozzátartozó keyboard invert attribútumát truera
     */
    public int effect(int eaten, int lastspecial){
        kb.setInvert(true);
        return eaten;
    }

    /**
     * átállítja a hozzátartozó keyboard invert attribútumát falsera
     */
    public void countereffect (){
        kb.setInvert(false);
    }

    public void spawn(){
        setPos(15, 15);
    }
}

package game;

import java.awt.*;

public class GreenApple extends Apple{
    private Viewmodell view;

    /**
     * Beállítja a példány attribútumait a megfelelő értékre.
     * @param snake kapott snake
     * @param v kapott viewmodell
     */
    public GreenApple(Snake snake,  Viewmodell v, Position pos){
        super(snake, Color.GREEN, pos);
        view = v;
    }

    /**
     * Felgyorsítja a kígyó sebességét kétszeresére
     */
    public int effect(int eaten, int lastspecial){
        view.setTickrate(150);
        return eaten;
    }

    /**
     * Vissza állítja a kígyó gyorsaságát
     */
    public void countereffect (){
        view.setTickrate(300);
    }

    public void spawn(){
        setPos(15, 15);
    }
}

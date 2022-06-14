package game;

import java.awt.*;

public class GoldenApple extends Apple{
    private Viewmodell viewmodell;

    /**
     * Beállítja a példány attribútumait a megfelelő értékre.
     * @param snake kapott snake
     * @param v kapott viewmodell példány
     */
    public GoldenApple(Snake snake, Viewmodell v, Position pos){
        super(snake, Color.YELLOW, pos);
        viewmodell = v;
    }

    /**
     * Megduplázza az egy alma elfogyasztásáért járó pontszámot.
     */
    public int effect(int eaten, int lastspecial){
        viewmodell.setBasescore(200);
        return eaten;
    }

    /**
     * Visszaállítja az egy alma elfogyasztásáért járó pontszámot.
     */
    public void countereffect (){
        viewmodell.setBasescore(100);
    }

    public void spawn(){
        setPos(15, 15);
    }
}

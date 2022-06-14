package game;

import java.awt.*;
import java.util.ArrayList;

public class Apple {
    private Position pos;
    private Snake sznek;
    private Color color;

    /**
     * Nincs jelentősége, öröklés miatt kell.
     */
    public Apple(){}

    /**
     * Beállítja a példány attribútumait a megfelelő értékre.
     * @param snake kapott snake
     */
    public Apple(Snake snake, Color _color, Position _pos){
        sznek = snake;
        color = _color;
        pos = _pos;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x, int y){
        getPos().setPosition(x, y);
    }

    /**
     * ellenőrzi, hogy az adott pillanatban megették-e az almát
     * @return true, ha az almát megették, false ha nem
     */
    public boolean isEaten(){
        Position snakeHead = sznek.getSnake().get(0);
        if(snakeHead.getX() == pos.getX() && snakeHead.getY() == pos.getY()) {
            return true;
        }
        return false;
    }

    /**
     * Nincs jelentősége, öröklés miatt kell.
     */
    public int effect(int eaten, int lastspecial){
        return lastspecial;
    }

    /**
     * Nincs jelentősége, öröklés miatt kell.
     */
    public void countereffect(){}

    /**
     * Ha megették az almát újra elhelyezi.
     */
    public void spawn(){
        pickNewPosition();
    }

    protected void pickNewPosition(){
        boolean adequate = false;
        while(!adequate) {
            pos.setPosition((int)(Math.random() * 12), (int)(Math.random()*9));
            for(int i = 0; i < sznek.getSnake().size(); i++) {
                adequate = true;
                Position snakeBody = sznek.getSnake().get(i);
                if ((snakeBody.getX() == pos.getX()) && (snakeBody.getY() == pos.getY())) {
                    adequate = false;
                    break;
                }
            }
        }
    }

    Color getColor(){
        return color;
    }
}

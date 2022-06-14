package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private Snake sznek;
    private boolean invert = false;

    /**
     * Beállítja a példány attribútumait a megfelelő értékre.
     * @param snake kapott snake
     */
    public Keyboard(Snake snake){
        sznek = snake;
    }

    /**
     * Nincs jelentősége, öröklés miatt kell.
     * @param e
     */
    public void keyTyped(KeyEvent e){}

    /**
     * A kígyó mozgásirányát változtatja a kapott inputnak megfelelően.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(invert)
            inverseKeyPressed(e);

        else
            normalKeyPressed(e);
    }

    public void setInvert(boolean invert) {
        this.invert = invert;
    }

    public boolean isInvert() {
        return invert;
    }

    private void normalKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W)
            checkMove(Direction.UP);
        else if(e.getKeyCode() == KeyEvent.VK_S)
            checkMove(Direction.DOWN);
        else if(e.getKeyCode() == KeyEvent.VK_D)
            checkMove(Direction.RIGHT);
        else if(e.getKeyCode() == KeyEvent.VK_A)
            checkMove(Direction.LEFT);
    }

    private void inverseKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W)
            checkMove(Direction.DOWN);
        else if(e.getKeyCode() == KeyEvent.VK_S)
            checkMove(Direction.UP);
        else if(e.getKeyCode() == KeyEvent.VK_D)
            checkMove(Direction.LEFT);
        else if(e.getKeyCode() == KeyEvent.VK_A)
            checkMove(Direction.RIGHT);
    }

    private void checkMove(Direction chosen){
        Direction actual = sznek.getActual();
        if((chosen.getValue() - actual.getValue()) % 2 != 0)
            sznek.setActual(chosen);
    }


    /**
     * Nincs jelentősége, öröklés miatt kell.
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}

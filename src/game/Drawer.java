package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Drawer extends JPanel {
    private Snake snake;
    private ArrayList<Apple> apples;

    /**
     * Beállítja a példány attribútumait a megfelelő értékre, és beállítja a JPanel attribútumait is.
     * @param _snake
     * @param _apples
     */
    public Drawer(Snake _snake, ArrayList<Apple> _apples){
        setBackground(Color.BLACK);
        setSize(12*30, 9*30);
        snake = _snake;
        apples = _apples;
    }

    /**
     * A játék elemeinek kirajzolásáért felelős függvény.
     * @param g
     */
    public void paintComponent(Graphics g){
        int px = 30;
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        ArrayList<Position> snakeBody = snake.getSnake();
        for(int i = 0; i < snakeBody.size(); i++){
            g.fillRect(snakeBody.get(i).getX() * px, snakeBody.get(i).getY() * px, px, px);
        }

        for(int i = 0; i < apples.size(); i++){
            drawApple(apples.get(i), g, px);
        }
    }


    /**
     * Segédfüggvény a különböző típusú almák kirajzolásához
     * @param apple a kirajzolandó alma
     * @param g
     * @param px egy mező mérete a játékban
     */
    public void drawApple(Apple apple, Graphics g, int px){
        g.setColor(apple.getColor());
        Position applePos = apple.getPos();
        g.fillRect(applePos.getX() * px, applePos.getY() * px, px, px);
    }
}

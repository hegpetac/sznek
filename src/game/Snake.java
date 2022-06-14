package game;

import java.util.*;

public class Snake{
    private ArrayList<Position> snake;
    private Direction actual;

    /**
     * Beállítja a snake kezdeti állapotát, és létrehoz egy 5 hosszúságú snaket.
     */
    public Snake(){
        snake = new ArrayList<>();
        this.init();
    }

    public ArrayList<Position> getSnake() {
        return snake;
    }


    public Direction getActual() {
        return actual;
    }
    public void setActual(Direction d) {actual = d;}


    /**
     * A snake mozgatásáért felel a kapott irány alapján
     * @param dir kapott irány.
     */
    public void move(Direction dir){
        for(int i = snake.size() - 1; i > 0; i--){
            snake.get(i).setPosition(snake.get(i-1));
        }

        Position snakeHead = snake.get(0);
        snakeHead.move(dir);

    }

    /**
     * Megnöveli a snake hosszát eggyel
     * @param plus az új elem helye
     */
    public void grow (Position plus){
        Position pos = new Position(plus.getX(), plus.getY());
        snake.add(pos);
    }

    /**
     * Ellenőrzi, hogy a kígyó belement-e önmagába.
     * @return true ha a kígyó belement önmagába, más esetben false
     */
    public boolean collision(){
        Position snakeHead = snake.get(0);
        for(int i = 1; i < snake.size(); i++){
            Position snakeBody = snake.get(i);
            if((snakeHead.getX() == snakeBody.getX()) && (snakeHead.getY() == snakeBody.getY()))
                return true;
        }
        return false;
    }

    /**
     * Visszaállítja a kígyót az eredeti állopatába.
     */
    public void init(){
        for(int i = snake.size(); i > 0; i --){
            snake.remove(i-1);
        }
        actual = Direction.LEFT;

        Position p1 = new Position(5,6);
        Position p2 = new Position(6,6);
        Position p3 = new Position(7,6);
        Position p4 = new Position(8, 6);
        Position p5 = new Position(9,6);
        snake.add(p1);
        snake.add(p2);
        snake.add(p3);
        snake.add(p4);
        snake.add(p5);
    }

}

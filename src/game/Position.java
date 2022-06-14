package game;

public class Position {
    private int x, y;

    public Position(int a, int b){
        x = a;
        y = b;
    }

    public void setPosition(int a, int b){
        x = a;
        y = b;
    }
    public void setPosition(Position pos){
        x = pos.getX();
        y = pos.getY();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

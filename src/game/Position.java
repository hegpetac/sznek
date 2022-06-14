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

    public void move(Direction dir){
        if(dir == Direction.UP)
            y = (((y - 1) % 9) + 9) % 9;
        else if(dir == Direction.RIGHT) {
            x = (x + 1) % 12;
        }
        else if(dir == Direction.DOWN){
            y = (y + 1) % 9;
        }
        else if(dir == Direction.LEFT){
            x = (((x - 1) % 12) + 12) % 12;
        }
    }
}

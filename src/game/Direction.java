package game;

public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private int value;

    private Direction(int param){
        this.value = param;
    }

    public int getValue(){
        return value;
    }
}

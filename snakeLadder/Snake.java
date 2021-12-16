package snakeLadder;

import java.util.HashMap;

public class Snake {
    private int start;
    private int end;
    public static HashMap<Integer, Integer>SnakePosition = new HashMap<>();

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
        this.SnakePosition.put(start,end);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public HashMap<Integer, Integer> getSnakePosition() {
        return SnakePosition;
    }
}

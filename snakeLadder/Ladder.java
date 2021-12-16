package snakeLadder;

import java.util.HashMap;

public class Ladder {
    private int start;
    private int end;
    public static HashMap<Integer,Integer>LadderPosition= new HashMap<>();

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
        LadderPosition.put(start,end);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public HashMap<Integer, Integer> getLadderPosition() {
        return LadderPosition;
    }

}

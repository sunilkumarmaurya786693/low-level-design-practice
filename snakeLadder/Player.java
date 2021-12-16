package snakeLadder;

import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private int position;
    private boolean isWin;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.position=1;
        isWin=false;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}

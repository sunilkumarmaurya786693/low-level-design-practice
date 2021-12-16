package snakeLadder;

import java.util.LinkedList;
import java.util.List;

public class Board {
    static int size=100;
    static int noOfDice=1;
    static int diceNumber=6;
    List<Snake> snakes;
    List<Ladder>ladders;
//    List<snakeLadder.Player>players;

    public Board() {
//        this.size = 100;
//        this.noOfDice=1;
        snakes = new LinkedList<Snake>();
        ladders = new LinkedList<Ladder>();
    }

    public int getSize() {
        return size;
    }

    public int getNoOfDice() {
        return noOfDice;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setSnake(Snake snake) {
        this.snakes.add(snake);
    }

    public void setLadder(Ladder ladder) {
        this.ladders.add(ladder);
    }



    public  int getDiceNumber() {
        return diceNumber;
    }

    public  void setDiceNumber(int diceNumber) {
        Board.diceNumber = diceNumber;
    }
}

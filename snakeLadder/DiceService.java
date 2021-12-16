package snakeLadder;

import java.util.Random;

public class DiceService {
    public static int roll() {
        return ((new Random().nextInt(Board.diceNumber))+1)* Board.noOfDice;
    }
   public static void snakeLadder.main(String args[]){
       System.out.println(roll());
   }
}

package snakeLadder;

import java.util.List;


public class main {
    public static void main(String args[]){
        int numPlayer=3;
        int numLadder=0;
        int numSnake=0;

        SnakeLadderService game = new SnakeLadderService(numPlayer);
        game.addPlayer("sunil");
        game.addPlayer("Akash");
        game.addPlayer("Vinay");
        game.addSnake(30,10);
        game.addSnake(50,40);
        game.addSnake(99,80);
        game.addSnake(90,60);
        game.addSnake(10,80);
        game.addLadder(20,50);
        game.addLadder(25,70);
        game.addLadder(40,76);
        game.addLadder(50,95);
        game.addLadder(28,77);
        System.out.println(game.isGameCompleted());
        game.start();
        List<Player> p= game.getWinner();
        List<Player> q= game.getPlayers();
        System.out.println(p);
        System.out.println(q);
    }
}

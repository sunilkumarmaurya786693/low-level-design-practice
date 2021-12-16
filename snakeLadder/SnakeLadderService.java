package snakeLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeLadderService {
    private int numberPlayer;
    private List<Player>Players;
    private Queue<Player>waitingPlayer;
    private boolean isGameCompleted;
    private List<Player>Winner;
    private Board board;


    public SnakeLadderService(int numberPlayer) {
        this.isGameCompleted=false;
        this.numberPlayer=numberPlayer;
        this.Players = new LinkedList<Player>();
        waitingPlayer = new LinkedList<Player>();
        Winner = new LinkedList<Player>();
        board = new Board();

        if(numberPlayer==1){
//            throw "Number of player should be more than 1";
        }
    }


    public Queue<Player> getwaitingPlayer() {
        return waitingPlayer;
    }

//    public void setwaitingPlayer(Queue<snakeLadder.Player> waitingPlayer) {
//        waitingPlayer = waitingPlayer;
//    }

    public boolean isGameCompleted() {
        return isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }

    public List<Player> getWinner() {
        return Winner;
    }

    public void setWinner(Player winner) {
        Winner.add(winner);
    }

    public List<Player> getPlayers() {
        return Players;
    }
    public void addPlayer(String name) {
        Player player = new Player(name);
        this.Players.add( player);
        this.waitingPlayer.add(player);
    }

    public int getNumberPlayer() {
        return numberPlayer;
    }

    public void setNumberPlayer(int numberPlayer) {
        this.numberPlayer = numberPlayer;
    }


    public void addSnake(int start, int end){
        this.board.setSnake(new Snake(start,end));
    }

    public void addLadder(int start, int end){
        this.board.setLadder(new Ladder(start,end));
    }


    public void movePlayer(Player currentPlayer){
        int position = currentPlayer.getPosition();
        int boardSize = Board.size;
        int diceMove = DiceService.roll();

        int newPosition = position+diceMove <= boardSize ? position+diceMove : position;
        //check snake and ladder
        boolean isSnakeCell = Snake.SnakePosition.containsKey(newPosition);
        if(isSnakeCell) {
            System.out.println(currentPlayer.getName()+" cut by snakeLadder.Snake at position "+ newPosition+ " and move to "+ Snake.SnakePosition.get(newPosition));
            newPosition =Snake.SnakePosition.get(newPosition);
        }
        boolean isLadderCell = Ladder.LadderPosition.containsKey(newPosition);
        if(isLadderCell){
            System.out.println(currentPlayer.getName()+" get a ladder from position "+ newPosition+ " to "+Ladder.LadderPosition.get(newPosition));
            newPosition=Ladder.LadderPosition.get(newPosition);
        }
        if(newPosition==boardSize){
            setWinner(currentPlayer);
            currentPlayer.setWin(true);
        }
        currentPlayer.setPosition(newPosition);
        System.out.println(currentPlayer.getName()+" rolled a dice "+diceMove+" and move from "+ position+" to "+newPosition);
    }

    public void start(){
        System.out.println("Game Start");
        while(isGameCompleted==false){
            Player currentPlayer = waitingPlayer.poll();
            movePlayer(currentPlayer);
            if(!currentPlayer.isWin()){
                waitingPlayer.add(currentPlayer);
            }
            if(waitingPlayer.size()==1){
                setGameCompleted(true);
            }
        }
        for(int i=0;i<Winner.size();i++){
            System.out.println(i+1+" "+Winner.get(i).getName());
        }
        System.out.println("Game end");
    }

}

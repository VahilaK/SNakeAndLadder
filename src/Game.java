import java.util.LinkedList;

public class Game {
    Board board;
    LinkedList players;
    Player currentPlayer;
    int currentIndex;
    Dice dice;

    Boolean gameWon = false;

    int numberOfRounds = 3;

    public Game(Board board, LinkedList players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    void addPlayer(Player p){
        players.add(p);
    }

    void setPlayersPosition() {
        for (int i = 0; i < players.size(); i++) {
            ((Player) players.get(i)).setPos(1);
        }
    }

    void setWinsAndLosses(){
        for (Object player : players) {
            ((Player) player).setWins(0);
            ((Player) player).setLosses(0);
        }
    }

    void startNewGame(){
        setWinsAndLosses();
        setPlayersPosition();
        for(int i=0;i<numberOfRounds;i++){
            restartRound();
        }
        printScoreOfPlayers();
    }

    void printScoreOfPlayers(){
        for(int i=0;i<players.size();i++){
            System.out.println("Player " + i + " won " + ((Player) players.get(i)).getWins() + " and lost " + ((Player) players.get(i)).getLosses());
        }
    }

    void restartRound(){
        gameWon = false;
        currentPlayer = (Player) players.peek();
        currentIndex = 0;
        setPlayersPosition();
        playGame();
    }

    Boolean gameWon(){
        if(currentPlayer.getPos() >= board.getSize()){
            gameWon = true;
            return true;
        }
        return false;
    }

    void setnextPlayer(){
        if(currentIndex == players.size()-1){
            currentPlayer = (Player) players.peek();
            currentIndex = 0;
        }
        else{
            currentPlayer = (Player) players.get(currentIndex+1);
            currentIndex++;
        }
    }

    void setPosition(int distance){
        int destination = currentPlayer.getPos() + distance;
        if(destination > board.getSize()){
            return;
        }

        if(board.m.containsKey(destination)){
            currentPlayer.setPos(board.m.get(destination));
            return;
        }

        currentPlayer.setPos(destination);
    }

    void setScore(){
        currentPlayer.scoreForRoundWon();
        for(int i=0;i<players.size();i++){
            if(i != currentIndex){
                ((Player) players.get(i)).scoreForRoundLost();
            }
        }
    }

    void playGame(){
        while (!gameWon){
            int distance = dice.rollDice();
            setPosition(distance);
            if(gameWon()){
                setScore();
            };
            setnextPlayer();
        }
    }
}

import java.util.LinkedList;

public class DriverClass {

    public  static void main(String args[]){
        Board board = new Board(25);

        LinkedList players = new LinkedList<Player>();
        for(int i=0;i<3;i++){
            players.add(new Player(1));
        }

        Dice dice = new Dice(6);

        Game game = new Game(board, players, dice);

        game.startNewGame();
    }
}

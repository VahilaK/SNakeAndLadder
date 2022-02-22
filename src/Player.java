public class Player {
    int pos;
    int wins;
    int losses;

    public Player(int pos) {
        this.pos = pos;
        this.wins = 0;
        this.losses = 0;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public void scoreForRoundWon(){
        wins++;
    }

    public void scoreForRoundLost(){
        losses++;
    }
}

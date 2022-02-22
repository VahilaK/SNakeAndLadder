import java.util.Random;

public class Dice {
    int limit;

    public int getLimit() {
        return limit;
    }

    public Dice(int limit) {
        this.limit = limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    Random random = new Random();
    int rollDice(){
        int nextNumber = random.nextInt(limit-1) + 1;
        return nextNumber;
    }
}

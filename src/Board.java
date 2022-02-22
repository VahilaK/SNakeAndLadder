import java.util.HashMap;
import java.util.Map;

public class Board {
    int size;
    Map<Integer, Integer> m = new HashMap<>();

    public Board(int size) {
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void addElement(int start, int end){
        if(!m.containsKey(start)){
            m.put(start, end);
        }
    }
}

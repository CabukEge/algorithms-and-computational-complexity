import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyChange {

    private static final List<Integer> coins = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200);


    public static void main(String[] args) {
        System.out.printf(calcEuroChange(39).toString());
    }

    private static List<Integer> calcEuroChange(int v) {
        List<Integer> change = new ArrayList<>();
        int i;
        int x;
        while (v > 0) {
            x = coins.get(coins.size() - 1);
            i = coins.size() - 1;
            while (v < coins.get(i)) {
                i--;
                x = coins.get(i);
            }
            if (i == 0 && (v - x) < 0) break;
            change.add(x);
            v -= x;
        }
        return change;
    }
}
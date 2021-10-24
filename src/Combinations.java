import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combines = new ArrayList<>();

        findCombine(combines, new ArrayList<>(), 1, n, k);

        return combines;
    }

    private void findCombine(List<List<Integer>> combines, List<Integer> combine, int start, int n, int k) {
        if (k == 0) {
            combines.add(combine);
            return;
        }

        for (int i = start; i <= n; i++) {
            ArrayList<Integer> newCombine = new ArrayList<>(combine);
            newCombine.add(i);
            findCombine(combines, newCombine, i + 1, n, k - 1);
        }
    }
}

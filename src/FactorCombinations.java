import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> factor = new ArrayList<>();
        getFactor(n, 2, factor, result);

        return result;
    }

    private void getFactor(int n, int start, ArrayList<Integer> factor, List<List<Integer>> result) {
        if (n == 1 && factor.size() > 1) {
            result.add(new ArrayList<>(factor));
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                factor.add(i);
                getFactor(n / i, i, factor, result);
                factor.remove(factor.size() - 1);
            }
        }
    }
}

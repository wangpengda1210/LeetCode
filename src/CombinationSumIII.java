import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, new ArrayList<>(), 0, 1, k, n);
        return result;
    }

    private void findCombinations(List<List<Integer>> result, List<Integer> curr, int currSum, int next, int k, int n) {
        if (currSum == n && curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (curr.size() == k || currSum > n) {
            return;
        }

        for (int i = next; i <= 9; i++) {
            curr.add(i);
            findCombinations(result, curr, currSum + i, i + 1, k, n);
            curr.remove(curr.size() - 1);
        }
    }
}

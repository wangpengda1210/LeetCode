import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();

        findCombination(combinations, new ArrayList<>(), candidates, target, 0);
        return combinations;
    }

    private void findCombination(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int start) {
        if (target == 0) {
            combinations.add(combination);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }

            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(candidates[i]);
            findCombination(combinations, newCombination, candidates, target - candidates[i], i);
        }
    }
}

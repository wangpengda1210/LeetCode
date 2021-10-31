import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (target < candidates[i]) {
                return;
            }

            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(candidates[i]);
            findCombination(combinations, newCombination, candidates, target - candidates[i], i + 1);
        }
    }
}

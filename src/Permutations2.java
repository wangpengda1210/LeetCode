import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> numsRemain = Arrays.stream(nums).boxed().collect(Collectors.toList());

        getPermute(permutations, new ArrayList<>(), numsRemain);

        int current = 0;
        while (current < nums.length) {

            current++;
            while (current < nums.length && nums[current] == nums[current - 1]) {
                current++;
            }
        }

        return permutations;
    }

    private void getPermute(List<List<Integer>> permutations, List<Integer> permutation, List<Integer> numbersRemain) {
        if (numbersRemain.isEmpty()) {
            permutations.add(permutation);
            return;
        }

        int i = 0;
        while (i < numbersRemain.size()) {
            List<Integer> newNumsRemain = new ArrayList<>(numbersRemain);
            List<Integer> newPermutation = new ArrayList<>(permutation);

            newPermutation.add(newNumsRemain.get(i));
            newNumsRemain.remove(i);
            getPermute(permutations, newPermutation, newNumsRemain);

            i++;
            while (i < numbersRemain.size() && numbersRemain.get(i) == numbersRemain.get(i - 1)) {
                i++;
            }
        }
    }
}

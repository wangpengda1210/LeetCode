import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> numsRemain = Arrays.stream(nums).boxed().collect(Collectors.toList());

        findPermutation(permutations, new ArrayList<>(), numsRemain);

        return permutations;
    }

    private void findPermutation(List<List<Integer>> permutations, List<Integer> permutation, List<Integer> numsRemain) {
        if (numsRemain.isEmpty()) {
            permutations.add(permutation);
            return;
        }

        for (int i = 0; i < numsRemain.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            List<Integer> newRemain = new ArrayList<>(numsRemain);

            newPermutation.add(newRemain.get(i));
            newRemain.remove(i);
            findPermutation(permutations, newPermutation, newRemain);
        }
    }
}

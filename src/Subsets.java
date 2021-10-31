import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        getSubset(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }


    private void getSubset(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            getSubset(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }

        subsets.add(new ArrayList<>(subset));
    }
}

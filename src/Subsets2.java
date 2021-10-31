import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();

        getSubset(subsets, new ArrayList<>(), nums, 0);

        return subsets;
    }

    private void getSubset(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
        int i = index;
        while (i < nums.length) {
            subset.add(nums[i]);
            getSubset(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
            i++;

            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        subsets.add(new ArrayList<>(subset));
    }
}

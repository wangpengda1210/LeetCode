import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length == 0) {
            ans.add(List.of(lower, upper));
            return ans;
        }

        int prev = lower - 1;

        for (int curr : nums) {
            if (curr - prev > 1) {
                ans.add(List.of(prev + 1, curr - 1));
            }
            prev = curr;
        }

        if (upper > prev) {
            ans.add(List.of(prev + 1, upper));
        }

        return ans;
    }
}

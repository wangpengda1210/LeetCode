import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSums = new ArrayList<>();

        if (nums.length < 3) {
            return threeSums;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int p1 = i + 1;
                int p2 = nums.length - 1;

                while (p1 < p2) {
                    int sum = nums[p1] + nums[p2] + nums[i];
                    if (sum == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[p1]);
                        triple.add(nums[p2]);
                        threeSums.add(triple);

                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--;
                        }
                        p1++;
                        p2--;
                    } else if (sum < 0) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }
        }

        return threeSums;
    }
}

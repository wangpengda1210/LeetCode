import java.util.HashMap;

public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> twoSum = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                twoSum.put(sum, twoSum.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int comp = -i - j;
                count += twoSum.getOrDefault(comp, 0);
            }
        }

        return count;
    }
}

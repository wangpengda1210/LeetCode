import java.util.HashMap;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) > 0) {
                count++;
                map.put(num, map.get(num) - 1);
            } else {
                map.put(k - num, map.getOrDefault(k - num, 0) + 1);
            }
        }

        return count;
    }
}

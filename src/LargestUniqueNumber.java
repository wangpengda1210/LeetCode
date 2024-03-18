import java.util.HashMap;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int unique = -1;
        for (int num : count.keySet()) {
            if (count.get(num) == 1) {
                unique = Math.max(unique, num);
            }
        }

        return unique;
    }
}

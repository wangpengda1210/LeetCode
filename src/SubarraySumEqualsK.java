import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);

        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += sumCount.getOrDefault(sum - k, 0);

            if (sumCount.containsKey(sum)) {
                sumCount.put(sum, sumCount.get(sum) + 1);
            } else {
                sumCount.put(sum, 1);
            }
        }

        return count;
    }
}

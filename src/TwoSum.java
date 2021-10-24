import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int second = nums[i];
            int first = target - second;
            if (numbers.containsKey(first)) {
                return new int[] { numbers.get(first), i };
            }
            numbers.put(second, i);
        }

        return null;
    }
}

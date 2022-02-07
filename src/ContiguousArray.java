import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int count = 0;
        countMap.put(0, -1);
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count += num == 0 ? -1 : 1;

            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }

        return maxLength;
    }
}

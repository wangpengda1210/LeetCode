import java.util.Stack;

public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Stack<Integer> numbers = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];

            while (!numbers.isEmpty() && numbers.peek() < curr) {
                int next = numbers.pop();
                if (next > min[i]) {
                    return true;
                }
            }

            numbers.push(curr);
        }

        return false;
    }
}

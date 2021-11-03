import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];

        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && j <= i + nums[i]) {
                if (steps[i] + 1 < steps[j]) {
                    steps[j] = steps[i] + 1;
                }
                j++;
            }

        }

        return steps[steps.length - 1];
    }
}

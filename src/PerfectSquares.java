import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squareNumbers = new ArrayList<>();
        int[] nums = new int[n + 1];

        for (int i = 1; i <= Math.sqrt(n); i++) {
            squareNumbers.add(i * i);
            nums[i * i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (nums[i] != 0) {
                continue;
            }

            int minNum = Integer.MAX_VALUE;
            for (int squareNumber : squareNumbers) {
                if (i - squareNumber > 0 && nums[i - squareNumber] + 1 < minNum) {
                    minNum = nums[i - squareNumber] + 1;
                }
            }

            nums[i] = minNum;
        }

        return nums[n];
    }
}

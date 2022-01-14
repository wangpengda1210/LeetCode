public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int[][] minLargest = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 1) {
                    minLargest[j][i] = preSum[n] - preSum[j];
                    continue;
                }

                int smallestLargest = Integer.MAX_VALUE;
                for (int k = j; k <= n - i; k++) {
                    int firstSum = preSum[k + 1] - preSum[j];
                    int largestSum = Math.max(firstSum, minLargest[k + 1][i - 1]);
                    smallestLargest = Math.min(smallestLargest, largestSum);

                    if (firstSum >= smallestLargest) {
                        break;
                    }
                }

                minLargest[j][i] = smallestLargest;
            }
        }

        return minLargest[0][m];
    }
}

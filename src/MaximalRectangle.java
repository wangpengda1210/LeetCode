import java.util.Arrays;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int max = 0;

        Arrays.fill(right, n);

        for (char[] chars : matrix) {
            int currLeft = 0;
            int currRight = n - 1;

            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (chars[j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = n;
                    currRight = j - 1;
                }
            }

            for (int j = 0; j < n; j++) {
                max = Math.max(max, height[j] * (right[j] - left[j] + 1));
            }
        }

        return max;
    }
}

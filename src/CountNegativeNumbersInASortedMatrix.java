/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 */

public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int j = 0;
        for (int i = m - 1; i >= 0; i--) {
            while (j < n && grid[i][j] >= 0) {
                j++;
            }
            count += n - j;
        }

        return count;
    }
}

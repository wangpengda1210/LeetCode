/**
 * You are given a 2D binary array grid. You need to find 3 non-overlapping rectangles having non-zero areas with horizontal and vertical sides
 * such that all the 1's in grid lie inside these rectangles.
 * <p>
 * Return the minimum possible sum of the area of these rectangles.
 * <p>
 * Note that the rectangles are allowed to touch.
 */

public class FindTheMinimumAreaToCoverAllOnesII {
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                min = Math.min(min, size(0, n - 1, 0, i, grid) +
                        size(0, n - 1, i + 1, j, grid) + size(0, n - 1, j + 1, m - 1, grid));
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                min = Math.min(min, size(0, i, 0, m - 1, grid) +
                        size(i + 1, j, 0, m - 1, grid) + size(j + 1, n - 1, 0, m - 1, grid));
            }
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                min = Math.min(min, size(0, n - 1, 0, i, grid) +
                        size(0, j, i + 1, m - 1, grid) + size(j + 1, n - 1, i + 1, m - 1, grid));

                min = Math.min(min, size(0, j, 0, i, grid) +
                        size(j + 1, n - 1, 0, i, grid) + size(0, n - 1, i + 1, m - 1, grid));

                min = Math.min(min, size(0, j, 0, m - 1, grid) +
                        size(j + 1, n - 1, 0, i, grid) + size(j + 1, n - 1, i + 1, m - 1, grid));

                min = Math.min(min, size(0, j, 0, i, grid) +
                        size(0, j, i + 1, m - 1, grid) + size(j + 1, n - 1, 0, m - 1, grid));
            }
        }

        return min;
    }

    private int size(int x1, int x2, int y1, int y2, int[][] grid) {
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (grid[i][j] == 1) {
                    xMin = Math.min(xMin, j);
                    xMax = Math.max(xMax, j);
                    yMin = Math.min(yMin, i);
                    yMax = Math.max(yMax, i);
                }
            }
        }

        if (xMin > xMax || yMin > yMax) {
            return 1000; // Grid size < 30 * 30
        }

        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }
}

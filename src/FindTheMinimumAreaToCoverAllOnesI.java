/**
 * You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area,
 * such that all the 1's in grid lie inside this rectangle.
 * <p>
 * Return the minimum possible area of the rectangle.
 */

public class FindTheMinimumAreaToCoverAllOnesI {
    public int minimumArea(int[][] grid) {
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xMin = Math.min(xMin, j);
                    xMax = Math.max(xMax, j);
                    yMin = Math.min(yMin, i);
                    yMax = Math.max(yMax, i);
                }
            }
        }

        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }
}

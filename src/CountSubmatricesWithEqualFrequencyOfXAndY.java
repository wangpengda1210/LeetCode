/**
 * Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices
 * that contains:
 * <p>
 * - grid[0][0]
 * - an equal frequency of 'X' and 'Y'.
 * - at least one 'X'.
 */

public class CountSubmatricesWithEqualFrequencyOfXAndY {
    public int numberOfSubmatrices(char[][] grid) {
        int[] colX = new int[grid[0].length];
        int[] colY = new int[grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            int rowX = 0;
            int rowY = 0;
            for (int j = 0; j < grid[0].length; j++) {
                int currX = colX[j];
                int currY = colY[j];

                if (grid[i][j] == 'X') {
                    rowX++;
                } else if (grid[i][j] == 'Y') {
                    rowY++;
                }

                currX += rowX;
                currY += rowY;
                colX[j] += rowX;
                colY[j] += rowY;

                if (currX == currY && currX > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

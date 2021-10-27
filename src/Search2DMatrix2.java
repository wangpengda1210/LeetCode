public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (true) {
            while (matrix[i][j] > target) {
                j--;
                if (j < 0) {
                    return false;
                }
            }
            while (matrix[i][j] < target) {
                i++;
                if (i >= m) {
                    return false;
                }
            }

            if (matrix[i][j] == target) {
                return true;
            }
        }
    }
}

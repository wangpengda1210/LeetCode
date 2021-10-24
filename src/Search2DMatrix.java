public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (target < matrix[i][0]) {
                continue;
            }

            for (int j = 0; j < matrix[0].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int layers = Math.min((int) Math.ceil(rows / 2.0), (int) Math.ceil(cols / 2.0));

        for (int i = 0; i < layers; i++) {
            for (int j = i; j < cols - i; j++) {
                result.add(matrix[i][j]);
            }

            for (int j = i + 1; j < rows - i; j++) {
                result.add(matrix[j][cols - i - 1]);
            }

            if (rows - i - 1 != i) {
                for (int j = cols - i - 2; j >= i; j--) {
                    result.add(matrix[rows - i - 1][j]);
                }
            }

            if (i != cols - i - 1) {
                for (int j = rows - i - 2; j >= i + 1; j--) {
                    result.add(matrix[j][i]);
                }
            }

        }

        return result;
    }
}

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int totalLayer = (n - 1) / 2;
        int layer = 0;
        int number = 1;

        while (layer <= totalLayer) {
            for (int i = layer; i < n - layer; i++, number++) {
                matrix[layer][i] = number;
            }

            for (int j = layer + 1; j < n - layer; j++, number++) {
                matrix[j][n - layer - 1] = number;
            }

            for (int i = n - layer - 2; i >= layer; i--, number++) {
                matrix[n - layer - 1][i] = number;
            }

            for (int j = n - layer - 2; j > layer; j--, number++) {
                matrix[j][layer] = number;
            }

            layer++;
        }

        return matrix;
    }
}

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int prevC = mat[0].length;
        int prevR = mat.length;

        if (r < 0 || c < 0 || prevC * prevR != r * c) {
            return mat;
        }

        int[][] newMatrix = new int[r][c];


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int numElement = i * c + j + 1;
                int rToFind = (numElement - 1) / prevC;
                int cToFind = (numElement - 1) % prevC;
                newMatrix[i][j] = mat[rToFind][cToFind];
            }
        }

        return newMatrix;
    }
}

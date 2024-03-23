import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        List<List<int[]>> compressed1 = compressMatrix(mat1);
        List<List<int[]>> compressed2 = compressMatrix(mat2);

        int[][] ans = new int[mat1.length][mat2[0].length];
        for (int mat1Row = 0; mat1Row < compressed1.size(); mat1Row++) {
            for (int[] mat1Pair : compressed1.get(mat1Row)) {
                int mat2Row = mat1Pair[0];
                int e1 = mat1Pair[1];

                for (int[] mat2Pair : compressed2.get(mat2Row)) {
                    int mat2Col = mat2Pair[0];
                    int e2 = mat2Pair[1];
                    ans[mat1Row][mat2Col] += e1 * e2;
                }
            }
        }

        return ans;
    }

    private List<List<int[]>> compressMatrix(int[][] mat) {
        List<List<int[]>> compressed = new ArrayList<>();

        for (int[] ints : mat) {
            ArrayList<int[]> row = new ArrayList<>();
            for (int j = 0; j < mat[0].length; j++) {
                if (ints[j] != 0) {
                    row.add(new int[]{j, ints[j]});
                }
            }
            compressed.add(row);
        }

        return compressed;
    }
}

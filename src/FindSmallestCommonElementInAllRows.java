import java.util.HashMap;

public class FindSmallestCommonElementInAllRows {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                count.put(mat[i][j], count.getOrDefault(mat[i][j], 0) + 1);
                if (count.get(mat[i][j]) == m) {
                    return mat[i][j];
                }
            }
        }

        return -1;
    }
}

import java.util.HashSet;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] roots = new int[n];
        int[] sizes = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    mergeRoot(roots, sizes, i, j);
                }
            }
        }

        HashSet<Integer> islands = new HashSet<>();
        for (int i = 0; i < roots.length; i++) {
            islands.add(root(roots, i));
        }

        return islands.size();
    }

    public void mergeRoot(int[] roots, int[] sizes, int i, int j) {
        int rootI = root(roots, i);
        int rootJ = root(roots, j);

        if (sizes[rootI] < sizes[rootJ]) {
            roots[rootI] = rootJ;
            sizes[rootI] += sizes[rootJ];
        } else {
            roots[rootJ] = rootI;
            sizes[rootJ] += sizes[rootI];
        }
    }

    private int root(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}

public class MostStonesRemovedWithSameRowOrColumn {
    private int find(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }

    private boolean union(int i, int j, int[] parent, int[] size) {
        int rootI = find(i, parent);
        int rootJ = find(j, parent);

        if (rootJ == rootI) {
            return false;
        }

        if (size[rootI] > size[rootJ]) {
            parent[rootJ] = rootI;
            size[rootI] += size[rootJ];
        } else {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        }

        return true;
    }

    public int removeStones(int[][] stones) {
        int count = stones.length;
        int[] parent = new int[count];
        int[] size = new int[count];

        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    boolean result = union(i, j, parent, size);
                    if (result) {
                        count -= 1;
                    }
                }
            }
        }

        return stones.length - count;
    }
}

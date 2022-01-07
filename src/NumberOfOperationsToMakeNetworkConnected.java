public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int components = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] conn : connections) {
            int parent1 = getParent(parent, conn[0]);
            int parent2 = getParent(parent, conn[1]);

            if (parent1 != parent2) {
                parent[parent1] = parent2;
                components--;
            }
        }

        return components - 1;
    }

    private int getParent(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }
}

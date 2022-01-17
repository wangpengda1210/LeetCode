public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int components = n;
        for (int[] edge : edges) {
            int p1 = findParent(parents, edge[0]);
            int p2 = findParent(parents, edge[1]);

            if (p1 != p2) {
                parents[p1] = p2;
                components--;
            }
        }

        return components;
    }

    private int findParent(int[] parents, int curr) {
        while (curr != parents[curr]) {
            parents[curr] = parents[parents[curr]];
            curr = parents[curr];
        }

        return curr;
    }
}

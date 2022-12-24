public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] roots = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], roots, size);
        }

        return find(source, roots) == find(destination, roots);
    }

    private int find(int num, int[] roots) {
        while (num != roots[num]) {
            roots[num] = roots[roots[num]];
            num = roots[num];
        }

        return num;
    }

    private void union(int first, int second, int[] roots, int[] size) {
        int firstRoot = find(first, roots);
        int secondRoot = find(second, roots);

        if (firstRoot == secondRoot) {
            return;
        }

        if (size[firstRoot] > size[secondRoot]) {
            roots[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
        } else {
            roots[firstRoot] = secondRoot;
            size[secondRoot] += size[firstRoot];
        }
    }
}

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] count = new int[n];
        count[0] = 1;

        return findTree(n, count);
    }

    private int findTree(int n, int[] count) {
        if (n <= 0) {
            return 0;
        }

        if (count[n - 1] != 0) {
            return count[n - 1];
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += findTree(i - 1, count) * findTree(n - i, count);
        }

        count[n - 1] = result;
        return count[n - 1];
    }
}

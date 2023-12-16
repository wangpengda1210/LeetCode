public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] indices = new int[n + 2];

        for (int citation : citations) {
            int i = Math.min(citation, n);
            indices[i]++;
        }

        for (int i = n; i >= 0; i--) {
            indices[i] += indices[i + 1];
            if (indices[i] >= i) return i;
        }

        return 0;
    }
}

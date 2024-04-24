public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        int last = k;
        int curr = k * k;

        for (int i = 3; i <= n; i++) {
            int temp = (k - 1) * (curr + last);
            last = curr;
            curr = temp;
        }

        return curr;
    }
}

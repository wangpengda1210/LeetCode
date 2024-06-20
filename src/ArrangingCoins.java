/**
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 */

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        // (1 + k) * k / 2 <= n
        // (k + k^2) / 2 <= n
        // k^2 + k - 2n <= 0
        // k^2 + k + 1/4 <= 2n + 1/4
        // (k + 1/2) ^ 2 <= 2n + 1/4
        // k <= sqrt(2n + 1/4) - 1/2
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}

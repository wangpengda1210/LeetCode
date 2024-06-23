/**
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 * <p>
 * You need to implement the function pickIndex(),
 * which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 * <p>
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%),
 * and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 */

public class RandomPickWithWeight {
    class Solution {
        int[] weight;
        int sum;

        public Solution(int[] w) {
            this.weight = new int[w.length];
            this.sum = 0;
            for (int i = 0; i < w.length; i++) {
                this.sum += w[i];
                this.weight[i] = this.sum;
            }
        }

        public int pickIndex() {
            double random = Math.random() * this.sum;
            int start = 0;
            int end = this.weight.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (this.weight[mid] >= random) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
}

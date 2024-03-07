import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (o1, o2) -> o2[1] - o1[1]);

        PriorityQueue<Integer> topK = new PriorityQueue<>();

        long sum = 0;
        int next;

        for (next = 0; next < k; next++) {
            topK.add(pairs[next][0]);
            sum += pairs[next][0];
        }
        long max = sum * pairs[next - 1][1];

        while (next < nums1.length) {
            sum -= topK.poll();
            topK.add(pairs[next][0]);
            sum += pairs[next][0];
            max = Math.max(max, pairs[next][1] * sum);
            next++;
        }

        return max;
    }
}

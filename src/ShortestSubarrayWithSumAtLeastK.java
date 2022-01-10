import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        long[] prefix = new long[A.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        int min = Integer.MAX_VALUE;

        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < prefix.length; i++) {
            long curr = prefix[i];

            while (!numbers.isEmpty() && prefix[numbers.peekLast()] > curr) {
                numbers.removeLast();
            }

            while (!numbers.isEmpty() && curr - prefix[numbers.peekFirst()] >= K) {
                min = Math.min(min, i - numbers.peekFirst());
                numbers.removeFirst();
            }

            numbers.addLast(i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

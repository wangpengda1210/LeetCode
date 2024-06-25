import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * <p>
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * <p>
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * <p>
 * Note: You cannot rotate an envelope.
 */

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        ArrayList<Integer> count = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            if (count.isEmpty() || count.get(count.size() - 1) < height) {
                count.add(height);
            } else {
                int start = 0;
                int end = count.size();
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (count.get(mid) >= height) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                count.set(start, height);
            }
        }

        return count.size();
    }
}

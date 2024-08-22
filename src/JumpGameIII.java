import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 */

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        arr[start] = -arr[start];
        Queue<Integer> pos = new LinkedList<>();
        pos.add(start);

        while (!pos.isEmpty()) {
            int next = pos.poll();
            int right = next - arr[next];
            int left = next + arr[next];

            if (right < arr.length && arr[right] >= 0) {
                if (arr[right] == 0) {
                    return true;
                }
                arr[right] = -arr[right];
                pos.add(right);
            }

            if (left >= 0 && arr[left] >= 0) {
                if (arr[left] == 0) {
                    return true;
                }
                arr[left] = -arr[left];
                pos.add(left);
            }
        }

        return false;
    }
}

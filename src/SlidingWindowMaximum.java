import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numWindow = nums.length - k + 1;

        int[] maxWindow = new int[numWindow];
        Deque<Integer> windowElement = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!windowElement.isEmpty() && nums[i] > nums[windowElement.peekLast()]) {
                windowElement.removeLast();
            }

            if (!windowElement.isEmpty() && windowElement.peekFirst() == i - k) {
                windowElement.removeFirst();
            }

            windowElement.addLast(i);
            if (i + 1 >= k) {
                maxWindow[i - k + 1] = nums[windowElement.peekFirst()];
            }
        }

        return maxWindow;
    }
}

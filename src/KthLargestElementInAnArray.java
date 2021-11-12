import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (k <= 0 || nums.length < k) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (minHeap.peek() < num) {
                minHeap.remove();
                minHeap.add(num);
            }
        }

        return minHeap.peek();
    }
}

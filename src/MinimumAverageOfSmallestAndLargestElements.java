import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You have an array of floating point numbers averages which is initially empty. You are given an array nums of n integers where n is even.
 * <p>
 * You repeat the following procedure n / 2 times:
 * <p>
 * Remove the smallest element, minElement, and the largest element maxElement, from nums.
 * Add (minElement + maxElement) / 2 to averages.
 * Return the minimum element in averages.
 */

public class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] nums) {
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Double> averages = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add((double) num);
            maxHeap.add((double) num);
        }

        for (int i = 0; i < nums.length / 2; i++) {
            double next = (minHeap.poll() + maxHeap.poll()) / 2;
            averages.add(next);
        }

        return averages.poll();
    }
}

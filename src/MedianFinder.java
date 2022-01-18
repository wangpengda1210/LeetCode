import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    boolean first;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (first) {
            minheap.add(num);
            first = false;
            return;
        }

        if (minheap.isEmpty() || num >= minheap.peek()) {
            minheap.add(num);

            if (minheap.size() > maxheap.size() + 1) {
                maxheap.add(minheap.poll());
            }
        } else {
            maxheap.add(num);

            if (maxheap.size() > minheap.size()) {
                minheap.add(maxheap.poll());
            }
        }
    }

    public double findMedian() {
        if (minheap.isEmpty()) {
            return -1;
        }

        if (maxheap.size() == minheap.size()) {
            return ((double) maxheap.peek() + (double) minheap.peek()) / 2;
        } else {
            return minheap.peek();
        }
    }
}

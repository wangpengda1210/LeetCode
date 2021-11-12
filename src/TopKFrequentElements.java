import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequents = new HashMap<>();

        for (int num : nums) {
            if (frequents.containsKey(num)) {
                frequents.put(num, frequents.get(num) + 1);
            } else {
                frequents.put(num, 1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequents::get));
        for (int key : frequents.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else if (minHeap.peek() != null && frequents.get(minHeap.peek()) < frequents.get(key)) {
                minHeap.remove();
                minHeap.add(key);
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.remove();
        }

        return topK;
    }
}

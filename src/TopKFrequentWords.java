import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o2.getValue(), o1.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue() - o2.getValue();
        });

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            pq.add(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> topWords = new ArrayList<>();
        while (!pq.isEmpty()) {
            topWords.add(0, pq.poll().getKey());
        }

        return topWords;
    }
}

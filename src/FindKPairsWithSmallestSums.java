import java.util.*;

public class FindKPairsWithSmallestSums {
    static class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        HashSet<Pair<Integer, Integer>> seen = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));

        seen.add(new Pair<>(0, 0));
        minHeap.add(new int[] { nums1[0] + nums2[0], 0, 0 });

        List<List<Integer>> result = new ArrayList<>();
        while (k > 0 && !minHeap.isEmpty()) {
            int[] next = minHeap.poll();
            int pos1 = next[1];
            int pos2 = next[2];
            result.add(List.of(nums1[pos1], nums2[pos2]));

            if (pos1 + 1 < nums1.length && !seen.contains(new Pair<>(pos1 + 1, pos2))) {
                seen.add(new Pair<>(pos1 + 1, pos2));
                minHeap.add(new int[] { nums1[pos1 + 1] + nums2[pos2], pos1 + 1, pos2 });
            }

            if (pos2 + 1 < nums2.length && !seen.contains(new Pair<>(pos1, pos2 + 1))) {
                seen.add(new Pair<>(pos1, pos2 + 1));
                minHeap.add(new int[] { nums1[pos1] + nums2[pos2 + 1], pos1, pos2 + 1 });
            }

            k--;
        }

        return result;
    }
}

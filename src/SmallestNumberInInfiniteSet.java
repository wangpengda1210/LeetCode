import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    class SmallestInfiniteSet {

        int next;
        PriorityQueue<Integer> added;
        HashSet<Integer> addedSet;

        public SmallestInfiniteSet() {
            next = 1;
            added = new PriorityQueue<>();
            addedSet = new HashSet<>();
        }

        public int popSmallest() {
            if (!added.isEmpty()) {
                int res = added.poll();
                addedSet.remove(res);
                return res;
            }

            return next++;
        }

        public void addBack(int num) {
            if (num < next && !addedSet.contains(num)) {
                added.add(num);
                addedSet.add(num);
            }
        }
    }
}

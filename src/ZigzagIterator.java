import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    Queue<Integer> nums = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < v1.size() && p2 < v2.size()) {
            nums.offer(v1.get(p1));
            nums.offer(v2.get(p2));
            p1++;
            p2++;
        }

        while (p1 < v1.size()) {
            nums.offer(v1.get(p1));
            p1++;
        }

        while (p2 < v2.size()) {
            nums.offer(v2.get(p2));
            p2++;
        }
    }

    public int next() {
        return nums.poll();
    }

    public boolean hasNext() {
        return !nums.isEmpty();
    }
}

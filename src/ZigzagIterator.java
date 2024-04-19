import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    Queue<int[]> nums;
    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.nums = new LinkedList<>();
        this.addNumber(new int[] { 0, 0, 1 });
        this.addNumber(new int[] { 0, 0, 2 });
    }

    public int next() {
        int[] next = nums.poll();
        addNumber(next);
        return next[0];
    }

    public boolean hasNext() {
        return !nums.isEmpty();
    }

    private void addNumber(int[] prev) {
        int pos = prev[1];
        int from = prev[2];
        if (from == 1 && pos < v1.size()) {
            nums.add(new int[] { v1.get(pos), pos + 1, 1 });
        } else if (from == 2 && pos < v2.size()) {
            nums.add(new int[] { v2.get(pos), pos + 1, 2 });
        }
    }
}

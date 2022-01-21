import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(e -> schedule.get(e[0]).get(e[1]).start));
        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).size() > 0) {
                minheap.add(new int[] { i, 0 });
            }
        }

        List<Interval> result = new ArrayList<>();

        if (minheap.isEmpty()) {
            return result;
        }

        int currEnd = schedule.get(minheap.peek()[0]).get(minheap.peek()[1]).end;

        while (!minheap.isEmpty()) {
            int[] next = minheap.poll();

            Interval nextInterval = schedule.get(next[0]).get(next[1]);
            if (nextInterval.start > currEnd) {
                result.add(new Interval(currEnd, nextInterval.start));
            }

            currEnd = Math.max(currEnd, nextInterval.end);

            if (next[1] < schedule.get(next[0]).size() - 1) {
                minheap.add(new int[] { next[0], next[1] + 1 });
            }
        }

        return result;
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        PriorityQueue<Integer> endTime = new PriorityQueue<>(Comparator.comparingInt(e -> e));

        for (int[] interval : intervals) {
            if (!endTime.isEmpty() && endTime.peek() <= interval[0]) {
                endTime.poll();
            }
            endTime.add(interval[1]);
        }

        return endTime.size();
    }
}

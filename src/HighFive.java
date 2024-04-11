import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> students = new TreeMap<>();

        for (int[] item : items) {
            if (!students.containsKey(item[0])) {
                students.put(item[0], new PriorityQueue<>((a, b) -> b - a));
            }
            students.get(item[0]).add(item[1]);
        }

        int[][] ans = new int[students.size()][2];
        int i = 0;
        for (int id : students.keySet()) {
            ans[i][0] = id;
            PriorityQueue<Integer> pq = students.get(id);
            int sum = 0;
            for (int j = 0; j < 5; j++){
                sum += pq.poll();
            }
            ans[i][1] = sum / 5;
            i++;
        }

        return ans;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
 * <p>
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee,
 * manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the company employees of an urgent piece of news.
 * He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes,
 * all his direct subordinates can start spreading the news).
 * <p>
 * Return the number of minutes needed to inform all the employees about the urgent news.
 */

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (i != headID) {
                graph[manager[i]].add(i);
            }
        }

        int totalTime = 0;
        Queue<int[]> informs = new LinkedList<>();
        boolean[] informed = new boolean[n];

        informs.add(new int[] { headID, 0 });
        informed[headID] = true;

        while (!informs.isEmpty()) {
            int[] next = informs.poll();
            int id = next[0];
            int time = next[1];
            totalTime = Math.max(totalTime, time);

            for (int sub : graph[id]) {
                if (!informed[sub]) {
                    informs.add(new int[] { sub, time + informTime[id] });
                }
            }
        }

        return totalTime;
    }
}

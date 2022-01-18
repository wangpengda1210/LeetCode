import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int y = prerequisite[1];

            List<Integer> preList = graph.getOrDefault(y, new ArrayList<>());
            preList.add(prerequisite[0]);
            graph.put(y, preList);
        }

        boolean[] seen = new boolean[numCourses];
        boolean[] finished = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, seen, finished, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, boolean[] seen, boolean[] finished, int curr) {
        if (finished[curr]) {
            return true;
        }

        if (seen[curr]) {
            return false;
        }

        if (!graph.containsKey(curr)) {
            return true;
        }

        seen[curr] = true;
        for (int nei : graph.get(curr)) {
            if (!dfs(graph, seen, finished, nei)) {
                return false;
            }
        }

        finished[curr] = true;
        return true;
    }
}

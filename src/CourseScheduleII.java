import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int y = prerequisite[1];

            List<Integer> preList = graph.getOrDefault(y, new ArrayList<>());
            preList.add(prerequisite[0]);
            graph.put(y, preList);
        }

        boolean[] seen = new boolean[numCourses];
        boolean[] finished = new boolean[numCourses];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, seen, finished, result, i)) {
                return new int[0];
            }
        }

        return result.stream().mapToInt(e -> e).toArray();
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, boolean[] seen, boolean[] finished, List<Integer> result, int curr) {
        if (finished[curr]) {
            return true;
        }

        if (seen[curr]) {
            return false;
        }

        if (!graph.containsKey(curr)) {
            result.add(curr);
            finished[curr] = true;
            return true;
        }

        seen[curr] = true;
        for (int nei : graph.get(curr)) {
            if (!dfs(graph, seen, finished, result, nei)) {
                return false;
            }
        }

        finished[curr] = true;
        result.add(0, curr);
        return true;
    }
}

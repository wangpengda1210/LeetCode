import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> sort = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                sort.add(i);
            }
        }

        while (!sort.isEmpty()) {
            int next = sort.poll();
            answer.add(next);
            for (int child : graph.get(next)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    sort.add(child);
                }
            }
        }

        return answer.size() == numCourses ? answer.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}

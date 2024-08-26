import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> sort = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                sort.add(i);
            }
        }

        int count = 0;
        while (!sort.isEmpty()) {
            int next = sort.poll();
            count++;
            for (int parent : graph.get(next)) {
                inDegree[parent]--;
                if (inDegree[parent] == 0) {
                    sort.add(parent);
                }
            }
        }

        return count == numCourses;
    }
}

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);
        getPath(paths, path, graph);

        return paths;
    }

    private void getPath(List<List<Integer>> paths, List<Integer> currentPath, int[][] graph) {
        int currentSize = currentPath.size() - 1;

        if (currentPath.get(currentSize) == graph.length - 1) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            for (int next : graph[currentPath.get(currentSize)]) {
                currentPath.add(next);
                getPath(paths, currentPath, graph);
                currentPath.remove(currentSize + 1);
            }
        }
    }
}

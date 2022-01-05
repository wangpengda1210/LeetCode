import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KillProcess {
    HashMap<Integer, List<Integer>> children = new HashMap<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < pid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);

            if (children.containsKey(parent)) {
                children.get(parent).add(child);
            } else {
                ArrayList<Integer> childList = new ArrayList<>();
                childList.add(child);
                children.put(parent, childList);
            }
        }

        ArrayList<Integer> killList = new ArrayList<>();
        dfs(kill, killList);
        return killList;
    }

    private void dfs(int kill, ArrayList<Integer> killList) {
        killList.add(kill);

        if (children.containsKey(kill)) {
            for (int child : children.get(kill)) {
                dfs(child, killList);
            }
        }
    }
}

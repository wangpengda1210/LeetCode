import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visitedRooms = new HashSet<>();
        visitedRooms.add(0);

        Queue<Integer> toVisit = new ArrayDeque<>(rooms.get(0));

        while (!toVisit.isEmpty()) {
            int next = toVisit.poll();

            for (int key : rooms.get(next)) {
                if (!visitedRooms.contains(key)) {
                    toVisit.add(key);
                }
            }

            visitedRooms.add(next);
        }

        return visitedRooms.size() == rooms.size();
    }
}

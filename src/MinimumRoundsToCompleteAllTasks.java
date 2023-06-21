import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> taskCount = new HashMap<>();

        for (int task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }

        int rounds = 0;

        for (int count : taskCount.values()) {
            if (count <= 1) {
                return -1;
            }

            if (count % 3 == 0) {
                rounds += count / 3;
            } else {
                rounds += (count / 3) + 1;
            }
        }

        return rounds;
    }
}

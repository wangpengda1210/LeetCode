import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> loseCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            if (!loseCount.containsKey(winner)) {
                loseCount.put(winner, 0);
            }

            loseCount.put(loser, loseCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> oneLose = new ArrayList<>();
        List<Integer> noLose = new ArrayList<>();

        for (int player : loseCount.keySet()) {
            if (loseCount.get(player) == 0) noLose.add(player);
            else if (loseCount.get(player) == 1) oneLose.add(player);
        }

        Collections.sort(oneLose);
        Collections.sort(noLose);

        return Arrays.asList(noLose, oneLose);
    }
}

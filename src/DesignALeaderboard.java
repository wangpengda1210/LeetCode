import java.util.HashMap;
import java.util.PriorityQueue;

public class DesignALeaderboard {
    class Leaderboard {
        HashMap<Integer, Integer> scores;

        public Leaderboard() {
            this.scores = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
        }

        public int top(int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int id : scores.keySet()) {
                pq.add(scores.get(id));
                if (pq.size() > K) {
                    pq.poll();
                }
            }

            int sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }

            return sum;
        }

        public void reset(int playerId) {
            scores.put(playerId, 0);
        }
    }
}

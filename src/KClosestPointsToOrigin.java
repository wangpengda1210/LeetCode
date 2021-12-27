import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> distance = new PriorityQueue<>((p1, p2) ->
                p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

        for (int[] point : points) {
            distance.offer(point);
            if (distance.size() > k) {
                distance.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = distance.poll();
            result[i] = point;
        }

        return result;
    }
}

import java.util.PriorityQueue;

public class MaximumNumberOfOnes {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                int count = ((width / sideLength) + (j < width % sideLength ? 1 : 0)) *
                        ((height / sideLength) + ((i < height % sideLength) ? 1 : 0));
                pq.add(count);
            }
        }

        int result = 0;
        for (int i = 0; i < maxOnes; i++) {
            result += pq.poll();
        }

        return result;
    }
}

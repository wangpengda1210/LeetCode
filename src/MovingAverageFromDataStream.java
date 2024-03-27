import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
    class MovingAverage {
        Queue<Integer> queue;
        int size;
        double sum;

        public MovingAverage(int size) {
            this.size = size;
            this.queue = new LinkedList<>();
            this.sum = 0;
        }

        public double next(int val) {
            if (queue.size() == this.size) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }
}

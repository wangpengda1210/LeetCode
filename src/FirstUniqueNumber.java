import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueNumber {
    class FirstUnique {
        HashMap<Integer, Integer> count;
        Queue<Integer> numbers;

        public FirstUnique(int[] nums) {
            count = new HashMap<>();
            numbers = new LinkedList<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            while (!numbers.isEmpty()) {
                if (count.get(numbers.peek()) == 1) {
                    return numbers.peek();
                }
                numbers.poll();
            }
            return -1;
        }

        public void add(int value) {
            if (!count.containsKey(value)) {
                count.put(value, 1);
                numbers.add(value);
            } else {
                count.put(value, count.get(value) + 1);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    static class RandomizedSet {
        HashMap<Integer, Integer> map;
        ArrayList<Integer> values;
        int size;
        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            values = new ArrayList<>();
            size = 0;
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, size);
            if (values.size() >= size + 1) {
                values.set(size, val);
            } else {
                values.add(val);
            }
            size++;

            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int lastValue = values.get(size - 1);
            values.set(map.get(val), lastValue);
            map.put(lastValue, map.get(val));
            map.remove(val);
            size--;

            return true;
        }

        public int getRandom() {
            int randomInt = random.nextInt(size);
            return values.get(randomInt);
        }
    }
}

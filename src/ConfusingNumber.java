import java.util.HashMap;

public class ConfusingNumber {
    public boolean confusingNumber(int n) {
        HashMap<Integer, Integer> pair = new HashMap<>();
        pair.put(1, 1);
        pair.put(6, 9);
        pair.put(9, 6);
        pair.put(8, 8);
        pair.put(0, 0);

        int number = n;
        int newNumber = 0;
        while (number > 0) {
            int next = number % 10;
            newNumber *= 10;
            if (!pair.containsKey(next)) {
                return false;
            }
            newNumber += pair.get(next);
            number /= 10;
        }

        return newNumber != n;
    }
}

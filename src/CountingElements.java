import java.util.HashMap;
import java.util.HashSet;

public class CountingElements {
    public int countElements(int[] arr) {
        HashSet<Integer> elements = new HashSet<>();
        for (int num : arr) {
            elements.add(num);
        }

        int count = 0;
        for (int num : arr) {
            if (elements.contains(num + 1)) {
                count++;
            }
        }

        return count;
    }
}

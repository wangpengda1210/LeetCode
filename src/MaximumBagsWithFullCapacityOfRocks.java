import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remain = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            remain[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(remain);

        int fullCount = 0;
        for (int i : remain) {
            if (additionalRocks >= i) {
                fullCount++;
                additionalRocks -= i;
            } else {
                break;
            }
        }

        return fullCount;
    }
}

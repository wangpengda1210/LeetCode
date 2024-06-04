import java.util.HashSet;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (arr.length - 1);

        if (diff == 0) {
            return true;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if ((num - min) % diff != 0) {
                return false;
            }
            set.add(num);
        }

        return set.size() == arr.length;
    }
}

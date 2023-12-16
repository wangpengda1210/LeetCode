import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];

        Arrays.fill(count, 1);

        for (int i = 1; i < count.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }

        int sum = count[count.length - 1];

        for (int i = count.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
            sum += count[i];
        }

        return sum;
    }
}

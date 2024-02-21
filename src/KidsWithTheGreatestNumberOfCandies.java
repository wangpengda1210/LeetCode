import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        Boolean[] isMax = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            isMax[i] = candies[i] + extraCandies >= max;
        }

        return Arrays.asList(isMax);
    }
}

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int start = 0;
            int end = potions.length;
            long spell = spells[i];

            while (start < end) {
                int mid = start + (end - start) / 2;
                long strength = spell * potions[mid];
                if (strength >= success) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            pairs[i] = potions.length - start;
        }

        return pairs;
    }
}

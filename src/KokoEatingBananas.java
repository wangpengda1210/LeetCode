public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (int) Math.ceil((double) pile / mid);
            }
            if (hours > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}

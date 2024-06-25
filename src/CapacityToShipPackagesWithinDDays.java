/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 */

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canShip(weights, days, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currDay = 0;
        int currItem = 0;
        while (currDay < days) {
            int currWeight = 0;
            while (currItem < weights.length && currWeight + weights[currItem] <= capacity) {
                currWeight += weights[currItem];
                currItem++;
            }
            if (currItem == weights.length) {
                return true;
            }
            currDay++;
        }
        return false;
    }
}

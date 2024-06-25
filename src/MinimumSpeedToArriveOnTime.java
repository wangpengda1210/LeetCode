/**
 * You are given a floating-point number hour, representing the amount of time you have to reach the office.
 * To commute to the office, you must take n trains in sequential order.
 * You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.
 * <p>
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 * <p>
 * For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time,
 * or -1 if it is impossible to be on time.
 * <p>
 * Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
 */

public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) {
            return -1;
        }

        int start = 1;
        int end = 10000001;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (commuteTime(dist, mid) <= hour) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end >= 10000001 ? -1 : end;
    }

    private double commuteTime(int[] dist, int speed) {
        double totalTime = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            totalTime += Math.ceil((double) dist[i] / speed);
        }
        totalTime += (double) dist[dist.length - 1] / speed;

        return totalTime;
    }
}

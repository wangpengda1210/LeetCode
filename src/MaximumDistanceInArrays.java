import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int currMin = curr.get(0);
            int currMax = curr.get(curr.size() - 1);

            maxDistance = Math.max(maxDistance, Math.max(currMax - min, max - currMin));
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }

        return maxDistance;
    }
}

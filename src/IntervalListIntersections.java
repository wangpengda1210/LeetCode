import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < firstList.length && p2 < secondList.length) {
            int firstStart = firstList[p1][0];
            int firstEnd = firstList[p1][1];
            int secondStart = secondList[p2][0];
            int secondEnd = secondList[p2][1];

            if (firstEnd < secondStart) {
                p1++;
            } else if (firstStart > secondEnd) {
                p2++;
            } else {
                intersections.add(new int[] { Math.max(firstStart, secondStart),
                        Math.min(firstEnd, secondEnd) });

                if (firstEnd > secondEnd) {
                    p2++;
                } else if (firstEnd < secondEnd) {
                    p1++;
                } else {
                    p1++;
                    p2++;
                }
            }
        }

        return intersections.toArray(new int[intersections.size()][2]);
    }
}

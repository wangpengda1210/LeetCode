import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> minimum = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(triangle.get(0).get(0));
        minimum.add(firstRow);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                int current = triangle.get(i).get(j);
                if (j == 0) {
                    row.add(minimum.get(i - 1).get(0) + current);
                } else if (j == i) {
                    row.add(minimum.get(i - 1).get(i - 1) + current);
                } else {
                    row.add(Math.min(minimum.get(i - 1).get(j - 1), minimum.get(i - 1).get(j)) + current);
                }
            }

            minimum.add(row);
        }

        int min = Integer.MAX_VALUE;

        for (int number : minimum.get(minimum.size() - 1)) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}

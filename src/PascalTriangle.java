import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 2; j < i; j++) {
                row.add(result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }
}

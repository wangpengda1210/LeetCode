import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfTwoRunLengthEncodedArrays {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int p1 = 0;
        int p2 = 0;

        int c1 = encoded1[0][1];
        int c2 = encoded2[0][1];

        int product = encoded1[0][0] * encoded2[0][0];
        int count = 0;

        ArrayList<List<Integer>> result = new ArrayList<>();
        while (p1 < encoded1.length && p2 < encoded2.length) {
            if (product != encoded1[p1][0] * encoded2[p2][0]) {
                result.add(Arrays.asList(product, count));
                product = encoded1[p1][0] * encoded2[p2][0];
                count = 0;
            }
            int num = Math.min(c1, c2);
            count += num;
            c1 -= num;
            c2 -= num;

            if (c1 == 0) {
                p1++;

                if (p1 < encoded1.length) {
                    c1 = encoded1[p1][1];
                }
            }
            if (c2 == 0) {
                p2++;
                if (p2 < encoded2.length) {
                    c2 = encoded2[p2][1];
                }
            }
        }

        result.add(Arrays.asList(product, count));

        return result;
    }
}

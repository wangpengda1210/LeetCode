import java.util.ArrayList;
import java.util.List;

/**
 * You are given a positive integer n.
 * <p>
 * A binary string x is valid if all substrings of x of length 2 contain at least one "1".
 * <p>
 * Return all valid strings with length n, in any order.
 */

public class GenerateBinaryStringsWithoutAdjacentZeros {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        findStrings(result, "", n, 1);
        return result;
    }

    private void findStrings(List<String> result, String curr, int n, int last) {
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        if (last == 0) {
            findStrings(result, curr + "1", n, 1);
        } else {
            findStrings(result, curr + "0", n, 0);
            findStrings(result, curr + "1", n, 1);
        }
    }
}

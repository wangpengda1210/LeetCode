import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList<>();

        remove(result, s, 0, 0, '(', ')');

        return result;
    }

    private void remove(ArrayList<String> result, String s, int iStart, int jStart, char startParen, char endParen) {
        int startCount = 0;
        int endCount = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == startParen) {
                startCount++;
            } else if (s.charAt(i) == endParen) {
                endCount++;
            }

            if (endCount > startCount) {
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == endParen && (j == jStart || s.charAt(j - 1) != endParen)) {
                        remove(result, s.substring(0, j) + s.substring(j + 1), i, j, startParen, endParen);
                    }
                }
                return;
            }
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if (startParen == '(') {
            remove(result, reverse, 0, 0, ')', '(');
        } else {
            result.add(reverse);
        }
    }
}

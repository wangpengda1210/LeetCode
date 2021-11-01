import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();

        getParenthesis(parenthesis, new StringBuilder("("), n - 1, n);

        return parenthesis;
    }

    private void getParenthesis(List<String> parenthesis, StringBuilder parentheses, int numOpen, int numClose) {
        if (numOpen == 0) {
            parentheses.append(")".repeat(Math.max(0, numClose)));
            parenthesis.add(parentheses.toString());
            parentheses.delete(parentheses.length() - numClose, parentheses.length());
            return;
        }

        if (numOpen > 0) {
            parentheses.append("(");
            getParenthesis(parenthesis, parentheses, numOpen - 1, numClose);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }

        if (numClose > 0 && numClose > numOpen) {
            parentheses.append(")");
            getParenthesis(parenthesis, parentheses, numOpen, numClose - 1);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
    }
}

import java.util.Stack;

public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char next = expression.charAt(i);
            if (next >= '0' && next <= '9' || next == 'T' || next == 'F') {
                stack.push(next);
            } else if (next == '?') {
                char first = stack.pop();
                char second = stack.pop();
                stack.push(expression.charAt(i - 1) == 'T' ? first : second);
                i--;
            }
        }

        return String.valueOf(stack.pop());
    }
}

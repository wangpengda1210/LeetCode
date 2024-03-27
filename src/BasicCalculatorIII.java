import java.util.HashSet;
import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        Stack<String> symbols = new Stack<>();
        char prevOp = '+';
        StringBuilder number = new StringBuilder();
        HashSet<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        s += "+";

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else if (c == '(') {
                symbols.push("" + prevOp);
                prevOp = '+';
            } else {
                if (!number.isEmpty()) {
                    int num = Integer.parseInt(number.toString());
                    if (prevOp == '-') {
                        num = -num;
                    } else if (prevOp == '*') {
                        num *= Integer.parseInt(symbols.pop());
                    } else if (prevOp == '/') {
                        num = Integer.parseInt(symbols.pop()) / num;
                    }
                    symbols.push(String.valueOf(num));
                    number.setLength(0);
                }
                prevOp = c;

                if (c == ')') {
                    int bracketSum = 0;
                    while (!ops.contains(symbols.peek())) {
                        bracketSum += Integer.parseInt(symbols.pop());
                    }
                    prevOp = symbols.pop().charAt(0);
                    number = new StringBuilder(String.valueOf(bracketSum));
                }
            }
        }

        int ans = 0;
        while (!symbols.isEmpty()) {
            ans += Integer.parseInt(symbols.pop());
        }

        return ans;
    }
}

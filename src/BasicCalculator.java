import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> symbols = new Stack<>();

        StringBuilder number = new StringBuilder();
        int result = 0;
        int operand = 1;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (!number.isEmpty()) {
                    result += operand * Integer.parseInt(number.toString());
                    number = new StringBuilder();
                }

                if (c == '+') {
                    operand = 1;
                } else if (c == '-') {
                    operand = -1;
                } else if (c == '(') {
                    symbols.push(result);
                    symbols.push(operand);

                    result = 0;
                    operand = 1;
                } else if (c == ')') {
                    result *= symbols.pop();
                    result += symbols.pop();
                }
            }
        }

        if (!number.isEmpty()) {
            result += operand * Integer.parseInt(number.toString());
        }

        return result;
    }
}

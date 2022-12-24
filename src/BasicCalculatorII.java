import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        char operand = ' ';
        StringBuilder number = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                int currNumber = Integer.parseInt(number.toString());
                number = new StringBuilder();

                if (operand != ' ') {
                    if (operand == '*') {
                        numbers.push(numbers.pop() * currNumber);
                    } else if (operand == '/') {
                        numbers.push(numbers.pop() / currNumber);
                    } else if (operand == '-') {
                        numbers.push(-currNumber);
                    } else {
                        numbers.push(currNumber);
                    }
                } else {
                    numbers.push(currNumber);
                }

                operand = c;
            }
        }

        int currNumber = Integer.parseInt(number.toString());

        if (!numbers.isEmpty()) {
            if (operand == '*') {
                numbers.push(numbers.pop() * currNumber);
            } else if (operand == '/') {
                numbers.push(numbers.pop() / currNumber);
            } else if (operand == '-') {
                numbers.push(-currNumber);
            } else {
                numbers.push(currNumber);
            }
        } else {
            return currNumber;
        }

        int result = 0;
        while (!numbers.isEmpty()) {
            result += numbers.pop();
        }

        return result;
    }
}

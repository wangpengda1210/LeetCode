import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                numbers.push(number);
            } catch (NumberFormatException e) {
                int newNumber = 0;
                int secondNumber = numbers.pop();
                int firstNumber = numbers.pop();

                char operand = token.charAt(0);
                if (operand == '+') {
                    newNumber = firstNumber + secondNumber;
                } else if (operand == '-') {
                    newNumber = firstNumber - secondNumber;
                } else if (operand == '*') {
                    newNumber = firstNumber * secondNumber;
                } else {
                    newNumber = firstNumber / secondNumber;
                }

                numbers.push(newNumber);
            }
        }

        return numbers.peek();
    }
}

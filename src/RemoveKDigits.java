import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }

        Stack<Character> digits = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (!digits.isEmpty() && c < digits.peek() && k > 0) {
                digits.pop();
                k--;
            }

            digits.push(c);
        }

        while (k > 0) {
            digits.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!digits.isEmpty()) {
            sb.append(digits.pop());
        }

        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.replace(0, 1, "");
        }

        String result = sb.toString();
        return result.length() == 0 ? "0" : result;
    }
}

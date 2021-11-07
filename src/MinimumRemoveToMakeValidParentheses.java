import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> leftParentheses = new Stack<>();
        StringBuilder validString = new StringBuilder();

        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftParentheses.push(length);
                validString.append(c);
                length++;
            } else if (c == ')') {
                if (!leftParentheses.isEmpty()) {
                    leftParentheses.pop();
                    validString.append(c);
                    length++;
                }
            } else {
                validString.append(c);
                length++;
            }
        }

        while (!leftParentheses.isEmpty()) {
            int toRemove = leftParentheses.pop();
            validString.delete(toRemove, toRemove + 1);
        }

        return validString.toString();
    }
}

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return generateString(s).equals(generateString(t));
    }

    private String generateString(String s) {
        Stack<Character> sStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sStack.push(c);
            } else if (!sStack.isEmpty()) {
                sStack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!sStack.isEmpty()) {
            sb.append(sStack.pop());
        }

        return sb.toString();
    }
}

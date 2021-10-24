import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> leftParent = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> leftParent.push(c);
                case ')' -> {
                    if (leftParent.isEmpty() || leftParent.peek() != '(') {
                        return false;
                    }
                    leftParent.pop();
                }
                case ']' -> {
                    if (leftParent.isEmpty() || leftParent.peek() != '[') {
                        return false;
                    }
                    leftParent.pop();
                }
                case '}' -> {
                    if (leftParent.isEmpty() || leftParent.peek() != '{') {
                        return false;
                    }
                    leftParent.pop();
                }
            }
        }

        return leftParent.isEmpty();
    }
}

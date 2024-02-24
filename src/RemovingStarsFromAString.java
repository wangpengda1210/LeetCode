import java.util.Stack;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        Stack<Character> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                characters.pop();
            } else {
                characters.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!characters.isEmpty()) {
            sb.append(characters.pop());
        }

        return sb.reverse().toString();
    }
}

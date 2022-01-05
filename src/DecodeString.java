import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                num.append(c);
            } else {
                if (c == '[') {
                    numStack.push(Integer.parseInt(num.toString()));
                    strStack.push(str);
                    num = new StringBuilder();
                    str = new StringBuilder();
                } else if (c == ']') {
                    int repeat = numStack.pop();
                    StringBuilder decodedStr = strStack.pop();

                    decodedStr.append(String.valueOf(str).repeat(Math.max(0, repeat)));
                    str = decodedStr;
                } else {
                    str.append(c);
                }
            }
        }

        return str.toString();
    }
}

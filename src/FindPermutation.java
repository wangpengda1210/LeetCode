import java.util.Stack;

public class FindPermutation {
    public int[] findPermutation(String s) {
        int[] answer = new int[s.length() + 1];

        Stack<Integer> numbers = new Stack<>();
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                answer[curr] = i + 1;
                curr++;
                while (!numbers.isEmpty()) {
                    answer[curr] = numbers.pop();
                    curr++;
                }
            } else {
                numbers.push(i + 1);
            }
        }

        answer[curr] = s.length() + 1;
        curr++;
        while (!numbers.isEmpty()) {
            answer[curr] = numbers.pop();
            curr++;
        }

        return answer;
    }
}

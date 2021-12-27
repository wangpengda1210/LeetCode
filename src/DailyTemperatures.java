import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> days = new Stack<>();
        int[] nextHot = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!days.isEmpty() && temperatures[days.peek()] < temperatures[i]) {
                days.pop();
            }
            if (!days.isEmpty()) {
                nextHot[i] = days.peek() - i;
            }

            days.push(i);
        }

        return nextHot;
    }
}

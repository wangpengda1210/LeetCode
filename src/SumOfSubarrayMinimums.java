import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int modulo = 1000000007;

        Stack<Integer> monoStack = new Stack<>();
        int[] sum = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            while (!monoStack.isEmpty() && num <= arr[monoStack.peek()]) {
                monoStack.pop();
            }

            if (monoStack.isEmpty()) {
                sum[i] = num * (i + 1);
            } else {
                sum[i] = (i - monoStack.peek()) * num + sum[monoStack.peek()];
            }

            monoStack.push(i);
        }

        int result = 0;
        for (int num : sum) {
            result += num;
            result %= modulo;
        }

        return result;
    }
}

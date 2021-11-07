import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minimums;

    public MinStack() {
        stack = new Stack<>();
        minimums = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minimums.isEmpty() || minimums.peek() >= val) {
            minimums.push(val);
        }
    }

    public void pop() {
        int value = stack.pop();
        if (minimums.peek() == value) {
            minimums.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}

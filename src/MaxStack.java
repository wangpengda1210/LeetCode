import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

class MaxStack {
    Stack<int[]> stack;
    PriorityQueue<int[]> max;
    HashSet<Integer> removed;
    int currId;

    public MaxStack() {
        this.stack = new Stack<>();
        this.max = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        this.removed = new HashSet<>();
        this.currId = 0;
    }

    public void push(int x) {
        int id = currId;
        stack.push(new int[] { x, id });
        max.add(new int[] { x, id });
        currId++;
    }

    public int pop() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        int[] top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }

    public int top() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        return stack.peek()[0];
    }

    public int peekMax() {
        while (removed.contains(max.peek()[1])) {
            max.poll();
        }
        return max.peek()[0];
    }

    public int popMax() {
        while (removed.contains(max.peek()[1])) {
            max.poll();
        }
        int[] top = max.poll();
        removed.add(top[1]);
        return top[0];
    }
}

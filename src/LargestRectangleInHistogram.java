import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int currentHeight = heights[stack.pop()];

                int left = stack.isEmpty() ? -1 : stack.peek();

                int currentWidth = i - left - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int currentHeight = heights[stack.pop()];

            int left = stack.isEmpty() ? -1 : stack.peek();

            int currentWidth = heights.length - left - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}

import java.util.Stack;

/**
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
 * <p>
 * You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
 * <p>
 * An integer x.
 * Record a new score of x.
 * '+'.
 * Record a new score that is the sum of the previous two scores.
 * 'D'.
 * Record a new score that is the double of the previous score.
 * 'C'.
 * Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the operations.
 * <p>
 * The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
 */

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> points = new Stack<>();
        for (String op : operations) {
            switch (op) {
                case "+":
                    int first = points.pop();
                    int second = points.peek();
                    points.push(first);
                    points.push(first + second);
                    break;
                case "D":
                    points.push(points.peek() * 2);
                    break;
                case "C":
                    points.pop();
                    break;
                default:
                    points.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        while (!points.isEmpty()) {
            sum += points.pop();
        }

        return sum;
    }
}

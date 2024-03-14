import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {
        Stack<Integer> prices;
        Stack<Integer> days;

        public StockSpanner() {
            prices = new Stack<>();
            days = new Stack<>();
        }

        public int next(int price) {
            int answer = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                answer += days.pop();
            }

            prices.push(price);
            days.push(answer);
            return answer;
        }
    }
}

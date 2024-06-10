import java.util.Stack;

/**
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * <p>
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * <p>
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * <p>
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x,
 * you will return only x steps. Return the current url after moving back in history at most steps.
 * <p>
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x,
 * you will forward only x steps. Return the current url after forwarding in history at most steps.
 */

public class DesignBrowserHistory {
    class BrowserHistory {
        Stack<String> forward;
        Stack<String> backward;
        String currUrl;

        public BrowserHistory(String homepage) {
            this.forward = new Stack<>();
            this.backward = new Stack<>();
            this.currUrl = homepage;
        }

        public void visit(String url) {
            forward.clear();
            if (currUrl != null) {
                backward.push(currUrl);
            }
            currUrl = url;
        }

        public String back(int steps) {
            for (int i = 0; i < steps; i++) {
                if (backward.isEmpty()) {
                    return currUrl;
                }
                forward.push(currUrl);
                currUrl = backward.pop();
            }

            return currUrl;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps; i++) {
                if (forward.isEmpty()) {
                    return currUrl;
                }
                backward.push(currUrl);
                currUrl = forward.pop();
            }

            return currUrl;
        }
    }
}

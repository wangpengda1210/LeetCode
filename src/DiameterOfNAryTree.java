import java.util.ArrayList;
import java.util.List;

public class DiameterOfNAryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int maxDia = 0;

    public int diameter(Node root) {
        getDia(root, 0);
        return maxDia;
    }

    private int getDia(Node root, int dia) {
        if (root.children.isEmpty()) {
            return dia;
        }

        int max = dia;
        int max2 = 0;

        for (Node child : root.children) {
            int curr = getDia(child, dia + 1);
            if (curr > max) {
                max2 = max;
                max = curr;
            } else if (curr > max2) {
                max2 = curr;
            }
        }

        int currDia = max + max2 - 2 * dia;
        if (currDia > maxDia) {
            maxDia = currDia;
        }

        return max;
    }
}

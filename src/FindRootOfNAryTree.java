import java.util.ArrayList;
import java.util.List;

public class FindRootOfNAryTree {
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

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node findRoot(List<Node> tree) {
        int single = 0;
        for (Node node : tree) {
            single ^= node.val;
            for (Node child : node.children) {
                single ^= child.val;
            }
        }

        for (Node node : tree) {
            if (node.val == single) {
                return node;
            }
        }

        return null;
    }
}

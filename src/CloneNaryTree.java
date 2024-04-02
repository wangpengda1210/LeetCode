import java.util.*;

public class CloneNaryTree {
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
    }

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        HashMap<Node, Node> pairs = new HashMap<>();
        Queue<Node> nodes = new LinkedList<>();

        nodes.add(root);
        Node newRoot = new Node(root.val);
        pairs.put(root, newRoot);

        while (!nodes.isEmpty()) {
            Node next = nodes.poll();
            Node newNext = pairs.get(next);

            newNext.children = new ArrayList<>();
            for (Node child : next.children) {
                Node newChild = new Node(child.val);
                newNext.children.add(newChild);
                pairs.put(child, newChild);
                nodes.add(child);
            }
        }

        return newRoot;
    }
}

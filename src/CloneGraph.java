import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> nodes = new LinkedList<>();

        nodes.offer(node);
        Node head = new Node(node.val);
        visited.put(node, head);

        while (!nodes.isEmpty()) {
            Node curr = nodes.poll();
            Node currClone = visited.get(curr);
            for (Node next : curr.neighbors) {
                if (visited.containsKey(next)) {
                    currClone.neighbors.add(visited.get(next));
                } else {
                    Node newNode = new Node(next.val);
                    visited.put(next, newNode);
                    currClone.neighbors.add(newNode);
                    nodes.offer(next);
                }
            }
        }

        return head;
    }
}

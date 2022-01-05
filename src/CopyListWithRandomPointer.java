import java.util.HashMap;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node temp = new Node(head.val);
        visited.put(head, temp);

        temp.next = copyRandomList(head.next);
        temp.random = copyRandomList(head.random);

        return temp;
    }
}

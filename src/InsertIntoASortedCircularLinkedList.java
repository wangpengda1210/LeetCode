public class InsertIntoASortedCircularLinkedList {
    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;

        do {
            if (curr.val <= insertVal && curr.next.val >= insertVal) {
                curr.next = new Node(insertVal, curr.next);
                return head;
            } else if (curr.val > curr.next.val && (insertVal >= curr.val || insertVal <= curr.next.val)) {
                curr.next = new Node(insertVal, curr.next);
                return head;
            }
            curr = curr.next;
        } while (curr != head);

        curr.next = new Node(insertVal, curr.next);
        return head;
    }
}

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node p = head;

        while (p != null) {
            if (p.child != null) {
                Node temp = p.next;
                Node childList = flatten(p.child);

                p.child = null;

                p.next = childList;
                childList.prev = p;

                while (p.next != null) {
                    p = p.next;
                }

                p.next = temp;

                if (temp != null) {
                    temp.prev = p;
                }
            }

            p = p.next;
        }

        return head;
    }
}

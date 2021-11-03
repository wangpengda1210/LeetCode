public class MyLinkedList {
    class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    int length;
    Node head;
    Node tail;

    public MyLinkedList() {
        length = 0;
    }

    private Node getNode(int index) {
        Node current = head;
        int count = 0;

        while (count < index && current != null) {
            count++;
            current = current.next;
        }

        return current;
    }

    public int get(int index) {
        if (index >= length) {
            return -1;
        }

        return getNode(index).val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            head = new Node(val, head);
        }

        length++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }

        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= length) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == length) {
                addAtTail(val);
            } else {
                Node prev = getNode(index - 1);
                prev.next = new Node(val, prev.next);
                length++;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < length) {
            if (index == 0) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                }
            } else {
                Node prev = getNode(index - 1);
                prev.next = prev.next.next;
                if (index == length - 1) {
                    tail = prev;
                }
            }

            length--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.val).append(" ");
            current = current.next;
        }
        sb.append("length: ").append(length);

        return sb.toString();
    }
}
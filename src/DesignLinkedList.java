/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * <p>
 * void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * <p>
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * <p>
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * <p>
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */

public class DesignLinkedList {
    class MyLinkedList {
        class Node {
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
                this.prev = null;
                this.next = null;
            }
        }

        Node head;
        Node tail;
        int size;

        public MyLinkedList() {
            this.head = new Node(0);
            this.tail = new Node(0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.size = 0;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            Node curr;
            if (index <= size - index) {
                curr = head.next;
                for (int i = 0; i < index; i++) {
                    curr = curr.next;
                }
            } else {
                curr = tail.prev;
                for (int i = size - 1; i > index; i--) {
                    curr = curr.prev;
                }
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            size++;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            Node prev;

            if (index <= size - index) {
                prev = head;
                for (int i = 0; i < index; i++) {
                    prev = prev.next;
                }
            } else {
                prev = tail;
                for (int i = 0; i <= size - index; i++) {
                    prev = prev.prev;
                }
            }

            Node newNode = new Node(val);
            newNode.next = prev.next;
            prev.next.prev = newNode;
            newNode.prev = prev;
            prev.next = newNode;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }

            Node prev;

            if (index <= size - index) {
                prev = head;
                for (int i = 0; i < index; i++) {
                    prev = prev.next;
                }
            } else {
                prev = tail;
                for (int i = 0; i <= size - index; i++) {
                    prev = prev.prev;
                }
            }

            prev.next = prev.next.next;
            prev.next.prev = prev;
            size--;
        }
    }
}

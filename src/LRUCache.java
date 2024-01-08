import java.util.HashMap;

class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int size;
    Node head;
    Node tail;
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.size = 0;
        cache = new HashMap<>();
    }

    private void moveToHead(Node node) {
        if (node != head) {
            if (node == tail) {
                tail = tail.prev;
            }
            Node temp = node.prev;
            temp.next = node.next;
            if (node.next != null) {
                node.next.prev = temp;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node result = cache.get(key);
        moveToHead(result);

        return result.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }

        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        cache.put(key, newNode);

        size++;
        if (size > capacity) {
            cache.remove(tail.key);

            if (size == 2) {
                tail = head;
                tail.prev = null;
            } else {
                tail = tail.prev;
            }
            tail.next = null;
            size--;
        }
    }
}

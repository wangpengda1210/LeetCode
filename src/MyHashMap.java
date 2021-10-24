public class MyHashMap {
    Node[] nodes = new Node[10];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        Node nodeFound = getPrevNode(key);
        if (nodeFound == null) {
            int index = getHashIndex(key);
            Node current = nodes[index];
            current.next = new Node(key, value, current.next);
        } else {
            nodeFound.next.value = value;
        }
    }

    public int get(int key) {
        Node nodeFound = getPrevNode(key);
        return nodeFound == null ? -1 : nodeFound.next.value;
    }

    private Node getPrevNode(int key) {
        int index = getHashIndex(key);
        Node current = nodes[index];

        if (current == null) {
            nodes[index] = new Node(-1, -1);
            return null;
        }

        while (current.next != null) {
            if (current.next.key == key) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(int key) {
        Node nodeFound = getPrevNode(key);
        if (nodeFound != null) {
            nodeFound.next = nodeFound.next.next;
        }
    }

    private int getHashIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

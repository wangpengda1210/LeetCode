public class MyCalendar {
    class Node {
        Node left;
        Node right;
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean insert(Node newNode) {
            if (newNode.end <= this.start) {
                if (this.left == null) {
                    this.left = newNode;
                    return true;
                } else {
                    return this.left.insert(newNode);
                }
            }

            if (newNode.start >= this.end) {
                if (this.right == null) {
                    this.right = newNode;
                    return true;
                } else {
                    return this.right.insert(newNode);
                }
            }

            return false;
        }
    }

    Node root;

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        Node newNode = new Node(start, end);
        if (root == null) {
            root = newNode;
            return true;
        }

        return root.insert(newNode);
    }
}

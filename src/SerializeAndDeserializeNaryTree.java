import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeNaryTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        public T getKey() {
            return t;
        }

        public S getValue() {
            return s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            if (root.children != null && !root.children.isEmpty()) {
                sb.append("[");
                for (int i = 0; i < root.children.size(); i++) {
                    Node child = root.children.get(i);
                    sb.append(serialize(child));
                    if (i != root.children.size() - 1) {
                        sb.append(" ");
                    }
                }
                sb.append("]");
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            return deserializeString(data, 0).getKey().get(0);
        }

        private Pair<List<Node>, Integer> deserializeString(String data, int start) {
            List<Node> nodeList = new ArrayList<>();
            int currIndex = start;

            StringBuilder sb = new StringBuilder();
            List<Node> child = new ArrayList<>();
            while (currIndex < data.length()) {
                char c = data.charAt(currIndex);
                if (c <= '9' && c >= '0') {
                    sb.append(c);
                } else if (c == ' ') {
                    nodeList.add(new Node(Integer.parseInt(sb.toString()), child));
                    child = new ArrayList<>();
                    sb = new StringBuilder();
                } else if (c == '[') {
                    Pair<List<Node>, Integer> next = deserializeString(data, currIndex + 1);
                    child = next.getKey();
                    currIndex = next.getValue();
                } else {
                    nodeList.add(new Node(Integer.parseInt(sb.toString()), child));
                    return new Pair<>(nodeList, currIndex);
                }
                currIndex++;
            }

            nodeList.add(new Node(Integer.parseInt(sb.toString()), child));
            return new Pair<>(nodeList, 0);
        }
    }

    public static void main(String[] args) {
        Node node14 = new Node(14);
        List<Node> child11 = new ArrayList<>();
        child11.add(node14);
        Node node11 = new Node(11, child11);
        List<Node> child7 = new ArrayList<>();
        child7.add(node11);
        Node node7 = new Node(7, child7);
        Node node6 = new Node(6);
        List<Node> child3 = new ArrayList<>();
        child3.add(node6);
        child3.add(node7);
        Node node3 = new Node(3, child3);

        Node node12 = new Node(12);
        List<Node> child8 = new ArrayList<>();
        child8.add(node12);
        Node node8 = new Node(8, child8);
        List<Node> child4 = new ArrayList<>();
        child4.add(node8);
        Node node4 = new Node(4, child4);

        Node node13 = new Node(13);
        List<Node> child9 = new ArrayList<>();
        child9.add(node13);
        Node node9 = new Node(9, child9);
        Node node10 = new Node(10);
        List<Node> child5 = new ArrayList<>();
        child5.add(node9);
        child5.add(node10);
        Node node5 = new Node(5, child5);

        Node node2 = new Node(2);

        List<Node> child1 = new ArrayList<>();
        child1.add(node2);
        child1.add(node3);
        child1.add(node4);
        child1.add(node5);
        Node node1 = new Node(1, child1);

        Codec codec = new Codec();
        String s = codec.serialize(node1);
        System.out.println(s);

        Node node = codec.deserialize(s);

        String s1 = codec.serialize(null);
     }
}

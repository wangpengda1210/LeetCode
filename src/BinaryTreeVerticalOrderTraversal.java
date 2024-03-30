import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
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
            if (!(obj instanceof Hello.Pair)) {
                return false;
            } else {
                return this.t.equals(((Hello.Pair<?, ?>) obj).t) && this.s.equals(((Hello.Pair<?, ?>) obj).s);
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;

        Queue<Pair<TreeNode, Integer>> nodePairs = new LinkedList<>();
        nodePairs.add(new Pair<>(root, 0));

        while (!nodePairs.isEmpty()) {
            Pair<TreeNode, Integer> next = nodePairs.poll();
            TreeNode node = next.getKey();
            int col = next.getValue();

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (!nodes.containsKey(col)) {
                nodes.put(col, new ArrayList<>());
            }
            nodes.get(col).add(node.val);

            if (node.left != null) {
                nodePairs.add(new Pair<>(node.left, col - 1));
            }
            if (node.right != null) {
                nodePairs.add(new Pair<>(node.right, col + 1));
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            answer.add(nodes.get(i));
        }

        return answer;
    }
}

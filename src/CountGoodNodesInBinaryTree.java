public class CountGoodNodesInBinaryTree {
    public class TreeNode {
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

    int count = 0;

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    private void countGoodNodes(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }

        if (root.val >= maxSoFar) {
            count++;
        }

        maxSoFar = Math.max(maxSoFar, root.val);
        countGoodNodes(root.left, maxSoFar);
        countGoodNodes(root.right, maxSoFar);
    }
}

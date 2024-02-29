public class LongestZigZagPathInABinaryTree {
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

    int longest = 0;

    public int longestZigZag(TreeNode root) {
        int left = findZigZag(root.left, true) + 1;
        int right = findZigZag(root.right, false) + 1;
        longest = Math.max(longest, Math.max(left, right));
        return longest - 1;
    }

    private int findZigZag(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        int left = findZigZag(root.left, true) + 1;
        int right = findZigZag(root.right, false) + 1;
        longest = Math.max(longest, Math.max(left, right));

        return isLeft ? right : left;
    }
}

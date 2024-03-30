public class BinaryTreeLongestConsecutiveSequence {
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

    int max = 0;

    public int longestConsecutive(TreeNode root) {
        findLongestConsecutive(root);
        return max;
    }

    private int findLongestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currMax = 1;
        int leftMax = findLongestConsecutive(root.left);
        int rightMax = findLongestConsecutive(root.right);
        if (root.left != null && root.left.val == root.val + 1) {
            currMax = Math.max(currMax, leftMax + 1);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            currMax = Math.max(currMax, rightMax + 1);
        }

        max = Math.max(max, currMax);
        return currMax;
    }
}

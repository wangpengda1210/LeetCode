public class BinaryTreeLongestConsecutiveSequenceII {
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

    private int[] findLongestConsecutive(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int inc = 1;
        int dec = 1;
        int[] leftMax = findLongestConsecutive(root.left);
        int[] rightMax = findLongestConsecutive(root.right);

        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                inc = Math.max(inc, leftMax[0] + 1);
            } else if (root.left.val == root.val - 1) {
                dec = Math.max(dec, leftMax[1] + 1);
            }
        }

        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                inc = Math.max(inc, rightMax[0] + 1);
            } else if (root.right.val == root.val - 1) {
                dec = Math.max(dec, rightMax[1] + 1);
            }
        }

        max = Math.max(max, inc + dec - 1);
        return new int[] { inc, dec };
    }
}

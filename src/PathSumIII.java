public class PathSumIII {
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

    int initialSum;

    public int pathSum(TreeNode root, int targetSum) {
        initialSum = targetSum;
        return numPathSum(root, targetSum, true);
    }

    private int numPathSum(TreeNode node, long targetSum, boolean start) {
        if (node == null) {
            return 0;
        }

        int currPath = 0;
        if (targetSum == node.val) {
            currPath = 1;
        }

        int leftSum = numPathSum(node.left, targetSum - node.val, false);
        int rightSum = numPathSum(node.right, targetSum - node.val, false);
        if (start) {
            leftSum += numPathSum(node.left, initialSum, true);
            rightSum += numPathSum(node.right, initialSum, true);
        }

        return leftSum + rightSum + currPath;
    }
}

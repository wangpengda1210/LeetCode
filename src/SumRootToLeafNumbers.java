public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        pathSum(root, 0);
        return sum;
    }

    private void pathSum(TreeNode root, int prevSum) {
        int currSum = prevSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += currSum;
        }

        if (root.left != null) {
            pathSum(root.left, currSum);
        }

        if (root.right != null) {
            pathSum(root.right, currSum);
        }
    }
}

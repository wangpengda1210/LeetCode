import java.util.ArrayList;

public class MaximumProductOfSplittedBinaryTree {
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

    ArrayList<Integer> sums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        int totalSum = sum(root);
        long max = 0;

        for (int sum : sums) {
            max = Math.max(max, (long) (totalSum - sum) * sum);
        }

        return (int) (max % 1000000007);
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        int totalSum = leftSum + rightSum + root.val;
        sums.add(totalSum);

        return totalSum;
    }
}

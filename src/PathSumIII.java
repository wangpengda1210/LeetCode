import java.util.HashMap;

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

    int count = 0;
    HashMap<Long, Integer> sumCount = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        countPathSum(root, targetSum, 0);
        return count;
    }

    private void countPathSum(TreeNode root, int targetSum, long currSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;
        if (currSum == targetSum) {
            count++;
        }

        count += sumCount.getOrDefault(currSum - targetSum, 0);
        sumCount.put(currSum, sumCount.getOrDefault(currSum, 0) + 1);

        countPathSum(root.left, targetSum, currSum);
        countPathSum(root.right, targetSum, currSum);

        sumCount.put(currSum, sumCount.get(currSum) - 1);
    }
}

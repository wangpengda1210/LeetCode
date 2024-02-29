import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
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

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int maxLevel = -1;

        nodes.add(root);
        int nodesRemain = 1;
        int level = 1;
        int sum = 0;

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.poll();
            if (next.left != null) {
                nodes.add(next.left);
            }
            if (next.right != null) {
                nodes.add(next.right);
            }

            sum += next.val;
            nodesRemain--;
            if (nodesRemain == 0) {
                if (sum > max) {
                    max = sum;
                    maxLevel = level;
                }
                nodesRemain = nodes.size();
                level++;
                sum = 0;
            }
        }

        return maxLevel;
    }
}

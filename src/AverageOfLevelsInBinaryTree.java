import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
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

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> averages = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();

        nodes.offer(root);
        int nodesAdded = 0;
        int nodesToAdd = 1;
        long sum = 0;

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.poll();
            nodesAdded++;
            nodesToAdd--;
            sum += next.val;

            if (next.left != null) nodes.offer(next.left);
            if (next.right != null) nodes.offer(next.right);

            if (nodesToAdd == 0) {
                averages.add((double) sum / nodesAdded);
                sum = 0;
                nodesToAdd = nodes.size();
                nodesAdded = 0;
            }
        }

        return averages;
    }
}

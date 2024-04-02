import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSumBSTs {
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

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> vals = new HashSet<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root1);

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.poll();
            vals.add(next.val);
            if (next.left != null) {
                nodes.add(next.left);
            }
            if (next.right != null) {
                nodes.add(next.right);
            }
        }

        nodes.add(root2);

        while (!nodes.isEmpty()) {
            TreeNode next = nodes.poll();

            if (vals.contains(target - next.val)) {
                return true;
            }

            if (next.left != null) {
                nodes.add(next.left);
            }
            if (next.right != null) {
                nodes.add(next.right);
            }
        }

        return false;
    }
}

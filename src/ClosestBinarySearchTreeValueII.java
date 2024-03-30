import java.util.ArrayList;
import java.util.List;

public class ClosestBinarySearchTreeValueII {
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

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);

        double minDiff = Double.MAX_VALUE;
        int minDiffPos = 0;

        for (int i = 0; i < values.size(); i++) {
            if (Math.abs(values.get(i) - target) < minDiff) {
                minDiff = Math.abs(values.get(i) - target);
                minDiffPos = i;
            }
        }

        int left = minDiffPos;
        int right = minDiffPos;

        while (right - left + 1 < k) {
            if (left == 0) {
                right++;
            } else if (right == values.size() - 1) {
                left--;
            } else if (Math.abs(values.get(left - 1) - target) < Math.abs(values.get(right + 1) - target)) {
                left--;
            } else {
                right++;
            }
        }

        return values.subList(left, right + 1);
    }

    private void inOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inOrder(root.left, values);
        values.add(root.val);
        inOrder(root.right, values);
    }
}

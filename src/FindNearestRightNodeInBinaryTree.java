import java.util.LinkedList;
import java.util.Queue;

public class FindNearestRightNodeInBinaryTree {
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

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int layerCount = 0;

        while (!queue.isEmpty()) {
            if (layerCount == 0) {
                layerCount = queue.size();
            }

            TreeNode curr = queue.poll();
            layerCount--;

            if (curr.val == u.val) {
                if (layerCount == 0) {
                    return null;
                } else {
                    return queue.peek();
                }
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return null;
    }
}

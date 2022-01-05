import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {
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

    public List<Integer> getLonelyNodes(TreeNode root) {
        ArrayList<Integer> lonelyNodes = new ArrayList<>();
        lonely(root, lonelyNodes);
        return lonelyNodes;
    }

    private void lonely(TreeNode root, List<Integer> lonelyNodes) {
        if (root == null) {
            return;
        }

        if (root.right != null && root.left == null) {
            lonelyNodes.add(root.right.val);
        }

        if (root.left != null && root.right == null) {
            lonelyNodes.add(root.left.val);
        }

        lonely(root.left, lonelyNodes);
        lonely(root.right, lonelyNodes);
    }
}

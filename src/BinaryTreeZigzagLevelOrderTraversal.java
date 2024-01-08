import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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

    List<List<Integer>> result;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        addNodes(root, 0);
        return result;
    }

    private void addNodes(TreeNode root, int level) {
        if (root == null) return;

        int val = root.val;
        if (result.size() <= level) result.add(new ArrayList<>());
        if (level % 2 == 0) {
            result.get(level).add(val);
        } else {
            result.get(level).add(0, val);
        }

        addNodes(root.left, level + 1);
        addNodes(root.right, level + 1);
    }
}

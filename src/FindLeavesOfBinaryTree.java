import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(result, root);
        return result;
    }

    private int height(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return -1;
        }

        int height = Math.max(height(result, root.left), height(result, root.right)) + 1;
        if (result.size() == height) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(root.val);

        return height;
    }
}

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    // Definition for a binary tree node.
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        getPaths(paths, path, root, targetSum);
        return paths;
    }

    private void getPaths(List<List<Integer>> paths, List<Integer> path, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (target - root.val == 0 && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }

        getPaths(paths, path, root.left, target - root.val);
        getPaths(paths, path, root.right, target - root.val);
        path.remove(path.size() - 1);
    }
}

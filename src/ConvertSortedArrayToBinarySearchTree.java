public class ConvertSortedArrayToBinarySearchTree {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start < end) {
            return null;
        }

        int mid = (start + end) / 2;
        return new TreeNode(nums[mid], buildTree(nums, start, mid - 1), buildTree(nums, mid + 1, end));
    }
}

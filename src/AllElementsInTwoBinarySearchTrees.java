import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(list1, root1);
        inOrder(list2, root2);

        int l1 = list1.size();
        int l2 = list2.size();
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();
        while (i < l1 && j < l2) {
            int e1 = list1.get(i);
            int e2 = list2.get(j);

            if (e1 < e2) {
                result.add(e1);
                i++;
            } else {
                result.add(e2);
                j++;
            }
        }

        while (i < l1) {
            result.add(list1.get(i));
            i++;
        }

        while (j < l2) {
            result.add(list2.get(j));
            j++;
        }

        return result;
    }

    private void inOrder(List<Integer> currentList, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(currentList, root.left);
        currentList.add(root.val);
        inOrder(currentList, root.right);
    }
}

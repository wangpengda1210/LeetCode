import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        int[] count = new int[n];
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, 0, n - 1, indices, count);

        List<Integer> result = new ArrayList<>();
        for (int num : count) {
            result.add(num);
        }

        return result;
    }

    private void mergeSort(int[] nums, int left, int right, int[] indices, int[] count) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, indices, count);
        mergeSort(nums, mid + 1, right, indices, count);
        merge(nums, left, right, mid, indices, count);
    }

    private void merge(int[] nums, int left, int right, int mid, int[] indices, int[] count) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> tempIndex = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                tempIndex.add(indices[i]);
                count[indices[i]] += j - mid - 1;
                i++;
            } else {
                temp.add(nums[j]);
                tempIndex.add(indices[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(nums[i]);
            tempIndex.add(indices[i]);
            count[indices[i]] += j - mid - 1;
            i++;
        }

        while (j <= right) {
            temp.add(nums[j]);
            tempIndex.add(indices[j]);
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            nums[left + k] = temp.get(k);
            indices[left + k] = tempIndex.get(k);
        }
    }
}

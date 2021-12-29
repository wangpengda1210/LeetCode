import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] numbers = new boolean[nums.length];

        for (int num : nums) {
            numbers[num - 1] = true;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numbers[i - 1]) {
                result.add(i);
            }
        }

        return result;
    }
}

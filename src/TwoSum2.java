public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length - 1;

        while (numbers[first] + numbers[second] != target) {
            if (numbers[first] + numbers[second] < target) {
                first++;
            } else {
                second--;
            }
        }

        return new int[] {first + 1, second + 1};
    }
}

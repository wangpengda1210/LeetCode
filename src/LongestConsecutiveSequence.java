import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }

        int longestSeq = 0;
        for (int num : nums) {
            if (!numbers.contains(num - 1)) {
                int curr = num;
                int currSeq = 1;

                while (numbers.contains(curr + 1)) {
                    curr++;
                    currSeq++;
                }

                longestSeq = Math.max(currSeq, longestSeq);
            }
        }

        return longestSeq;
    }
}

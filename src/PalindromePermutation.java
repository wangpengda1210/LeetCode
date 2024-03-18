public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        int oddCount = 0;

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return oddCount <= 1;
    }
}

public class CountSubstringsWithOnlyOneDistinctLetter {
    public int countLetters(String s) {
        int count = 0;
        int start = 0;
        char prev = ' ';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                count += substringNum(i - start);
                start = i;
                prev = s.charAt(i);
            }
        }

        count += substringNum(s.length() - start);

        return count;
    }

    private int substringNum(int length) {
        return (1 + length) * length / 2;
    }
}

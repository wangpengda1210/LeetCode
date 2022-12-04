public class DetermineIfStringHalvesAreAlike {
    String vowels = "aeiouAEIOU";

    private boolean isVowel(char c) {
        return vowels.indexOf(c) != -1;
    }

    public boolean halvesAreAlike(String s) {
        int i = 0;
        int j = s.length() - 1;

        int count = 0;

        while (i < j) {
            if (isVowel(s.charAt(i))) {
                count++;
            }

            if (isVowel(s.charAt(j))) {
                count--;
            }

            i++;
            j--;
        }

        return count == 0;
    }
}

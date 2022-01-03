import java.util.Arrays;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();

        String kmpS = s + "#" + reverse;
        int[] kmp = new int[kmpS.length()];

        for (int i = 1; i < kmp.length; i++) {
            int find = i - 1;
            while (find > 0 && kmpS.charAt(find) != kmpS.charAt(i)) {
                find = kmp[find];
            }

            if (kmpS.charAt(find) == kmpS.charAt(i)) {
                kmp[i] = find + 1;
            }
        }

        System.out.println(Arrays.toString(kmp));
        return reverse.substring(0, reverse.length() - kmp[kmp.length - 1]) + s;
    }
}

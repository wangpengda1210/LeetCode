import java.util.Arrays;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder str1 = new StringBuilder(num1).reverse();
        StringBuilder str2 = new StringBuilder(num2).reverse();

        char[] ans = new char[num1.length() + num2.length()];
        Arrays.fill(ans, '0');

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                int mul = (str1.charAt(j) - '0') * (str2.charAt(i) - '0') + (ans[i + j] - '0');
                ans[i + j] = (char) ('0' + mul % 10);
                ans[i + j + 1] = (char) (((ans[i + j + 1] - '0') + mul / 10) + '0');
            }
        }

        String mulStr = new StringBuilder(String.valueOf(ans)).reverse().toString();
        int firstNonZero = -1;
        for (int i = 0; i < mulStr.length(); i++) {
            if (mulStr.charAt(i) != '0') {
                firstNonZero = i;
                break;
            }
        }

        return firstNonZero == -1 ? "0" : mulStr.substring(firstNonZero);
    }
}

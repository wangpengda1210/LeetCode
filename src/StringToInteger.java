/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
 * If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then round the integer to remain in the range.
 * Specifically, integers less than -2^31 should be rounded to -2^31, and integers greater than 2^31 - 1 should be rounded to 2^31 - 1.
 * Return the integer as the final result.
 */

public class StringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 0;
        int num = 0;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' && sign == 0) {
                sign = 1;
            } else if (c == '-' && sign == 0) {
                sign = -1;
            } else if (c >= '0' && c <= '9') {
                if (sign == 0) {
                    sign = 1;
                }
                int next = c - '0';
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && next > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num *= 10;
                num += next;
            } else {
                return num * sign;
            }
        }

        return num * sign;
    }
}

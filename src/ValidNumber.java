/**
 * Given a string s, return whether s is a valid number.
 * <p>
 * For example, all the following are valid numbers:
 * "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789",
 * while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".
 * <p>
 * Formally, a valid number is defined using one of the following definitions:
 * <p>
 * An integer number followed by an optional exponent.
 * A decimal number followed by an optional exponent.
 * An integer number is defined with an optional sign '-' or '+' followed by digits.
 * <p>
 * A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
 * <p>
 * Digits followed by a dot '.'.
 * Digits followed by a dot '.' followed by digits.
 * A dot '.' followed by digits.
 * An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.
 * <p>
 * The digits are defined as one or more digits.
 */

public class ValidNumber {
    public boolean isNumber(String s) {
        boolean hasNumber = false;
        boolean hasSign = false;
        boolean hasExponent = false;
        boolean hasDot = false;

        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (hasSign || hasNumber || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (c >= '0' && c <= '9') {
                hasNumber = true;
            } else if (c == '.') {
                if (hasExponent || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (!hasNumber || hasExponent) {
                    return false;
                }
                hasExponent = true;
                hasNumber = false;
                hasSign = false;
                hasDot = false;
            } else {
                return false;
            }
        }

        return hasNumber;
    }
}

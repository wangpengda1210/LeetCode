/**
 * You are given a string s and an integer k. Encrypt the string using the following algorithm:
 * <p>
 * For each character c in s, replace c with the kth character after c in the string (in a cyclic manner).
 * Return the encrypted string.
 */

public class FindTheEncryptedString {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt((i + k) % s.length()));
        }
        return sb.toString();
    }
}

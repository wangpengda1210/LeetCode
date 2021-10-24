public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] count = new char[26];
        for (char sChar : s.toCharArray()) {
            count[sChar - 'a']++;
        }

        for (char tChar : t.toCharArray()) {
            count[tChar - 'a']--;
        }

        for (char letter : count) {
            if (letter != 0) {
                return false;
            }
        }

        return true;
    }
}

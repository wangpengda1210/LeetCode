import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> letters = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) != t.charAt(i)) {
                    return false;
                }
            } else if (letters.contains(t.charAt(i))) {
                return false;
            } else {
                map.put(c, t.charAt(i));
                letters.add(t.charAt(i));
            }
        }

        return true;
    }
}

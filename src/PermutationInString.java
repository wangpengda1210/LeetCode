import java.util.HashMap;

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char letter = s1.charAt(i);
            if (count.containsKey(letter)) {
                count.put(letter, count.get(letter) + 1);
            } else {
                count.put(letter, 1);
            }
        }

        HashMap<Character, Integer> count2 = new HashMap<>();
        for (int i = 0, j = 0; j < s2.length(); j++) {
            char letter = s2.charAt(j);
            if (count2.containsKey(letter)) {
                count2.put(letter, count2.get(letter) + 1);
            } else {
                count2.put(letter, 1);
            }

            if (j - i + 1 == s1.length()) {
                if (include(count, count2)) {
                    return true;
                }
                char letterToRemove = s2.charAt(i);
                count2.put(letterToRemove, count2.get(letterToRemove) - 1);
                i++;
            }
        }

        return false;
    }

    private boolean include(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for (char key : map1.keySet()) {
            if (!map2.containsKey(key) || map2.get(key) < map1.get(key)) {
                return false;
            }
        }
        return true;
    }
}
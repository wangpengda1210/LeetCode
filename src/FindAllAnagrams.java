import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();

        if (s.length() < p.length()) {
            return answer;
        }

        HashMap<Character, Integer> letterCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            putLetter(c, letterCount);
        }

        int p1 = 0;
        int p2 = p.length() - 1;
        HashMap<Character, Integer> anagramCount = new HashMap<>();

        for (int i = p1; i <= p2; i++) {
            char letter = s.charAt(i);
            putLetter(letter, anagramCount);
        }

        while (p2 < s.length() - 1) {
            if (checkAnagram(letterCount, anagramCount)) {
                answer.add(p1);
            }
            p2++;

            char letterToRemove = s.charAt(p1);
            char letterToAdd = s.charAt(p2);
            anagramCount.put(letterToRemove, anagramCount.get(letterToRemove) - 1);
            putLetter(letterToAdd, anagramCount);

            p1++;
        }

        if (checkAnagram(letterCount, anagramCount)) {
            answer.add(p1);
        }

        return answer;
    }

    private void putLetter(char letter, HashMap<Character, Integer> map) {
        if (map.containsKey(letter)) {
            map.put(letter, map.get(letter) + 1);
        } else {
            map.put(letter, 0);
        }
    }

    private boolean checkAnagram(HashMap<Character, Integer> letterCount, HashMap<Character, Integer> anagramCount) {
        for (char key : letterCount.keySet()) {
            if (!Objects.equals(letterCount.get(key), anagramCount.get(key))) {
                return false;
            }
        }

        return true;
    }
}

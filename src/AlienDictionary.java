import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> nextList = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!nextList.containsKey(c)) {
                    nextList.put(c, new ArrayList<>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    nextList.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        HashSet<Character> seen = new HashSet<>();
        HashSet<Character> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : nextList.keySet()) {
            if (!dfs(c, nextList, seen, visited, sb)) {
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(char curr, HashMap<Character, ArrayList<Character>> nextList, HashSet<Character> seen, HashSet<Character> visited, StringBuilder sb) {
        if (visited.contains(curr)) {
            return true;
        }

        if (seen.contains(curr)) {
            return false;
        }

        seen.add(curr);
        if (!nextList.containsKey(curr)) {
            visited.add(curr);
            return true;
        }

        for (char next : nextList.get(curr)) {
            if (!dfs(next, nextList, seen, visited, sb)) {
                return false;
            }
        }

        visited.add(curr);
        sb.append(curr);
        return true;
    }
}

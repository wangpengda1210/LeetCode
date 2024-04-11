import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        List<Character>[] graph = new List[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (graph[c - 'a'] == null) {
                    graph[c - 'a'] = new ArrayList<>();
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            if (curr.startsWith(next) && curr.length() > next.length()) {
                return "";
            }

            for (int j = 0; j < Math.min(curr.length(), next.length()); j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    graph[curr.charAt(j) - 'a'].add(next.charAt(j));
                    break;
                }
            }
        }

        boolean[] seen = new boolean[26];
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (char c = 'a'; c <= 'z'; c++) {
            if (graph[c - 'a'] == null) {
                continue;
            }

            if (!dfs(graph, seen, visited, sb, c)) {
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(List<Character>[] graph, boolean[] seen, boolean[] visited, StringBuilder sb, char c) {
        if (visited[c - 'a']) {
            return true;
        }

        if (seen[c - 'a']) {
            return false;
        }

        seen[c - 'a'] = true;
        for (char next : graph[c - 'a']) {
            if (!dfs(graph, seen, visited, sb, next)) {
                return false;
            }
        }
        visited[c - 'a'] = true;

        sb.append(c);
        return true;
    }
}

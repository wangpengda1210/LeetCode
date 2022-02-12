import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> nodes = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> neighbours = nodes.getOrDefault(newWord, new ArrayList<>());
                neighbours.add(word);
                nodes.put(newWord, neighbours);
            }
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(beginWord);

        int level = 0;
        int levelCount = 0;

        while (!queue.isEmpty()) {
            if (levelCount == 0) {
                level++;
                levelCount = queue.size();
            }

            String currWord = queue.poll();

            for (int i = 0; i < currWord.length(); i++) {
                String newWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1);
                if (nodes.containsKey(newWord)) {
                    for (String nextWord : nodes.get(newWord)) {
                        if (!visited.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return level + 1;
                            }

                            visited.add(nextWord);
                            queue.add(nextWord);
                        }
                    }
                }
            }

            levelCount--;
        }

        return 0;
    }
}

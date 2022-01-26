import java.util.*;

class AutocompleteSystem {
    class Node {
        HashMap<Character, Node> children = new HashMap<>();
        HashMap<String, Integer> autoWords = new HashMap<>();
        boolean isEnd = false;
    }

    Node root;
    Node currInput;
    String prefix;

    private void addWord(String sentence, int time) {
        Node curr = root;

        for (char c : sentence.toCharArray()) {
            int currCount = curr.autoWords.getOrDefault(sentence, 0);
            curr.autoWords.put(sentence, currCount + time);

            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }

            curr = curr.children.get(c);
        }

        int currCount = curr.autoWords.getOrDefault(sentence, 0);
        curr.autoWords.put(sentence, currCount + time);
        curr.isEnd = true;
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        currInput = root;
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            addWord(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addWord(prefix, 1);
            currInput = root;
            prefix = "";
            return new ArrayList<>();
        }

        prefix += c + "";
        if (currInput == null) {
            return new ArrayList<>();
        }

        if (!currInput.children.containsKey(c)) {
            currInput = null;
            return new ArrayList<>();
        }

        currInput = currInput.children.get(c);
        PriorityQueue<Map.Entry<String, Integer>> wordsPq = new PriorityQueue<>((o1, o2) -> {
            int v1 = o1.getValue();
            int v2 = o2.getValue();
            if (v1 == v2) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return v2 - v1;
        });

        wordsPq.addAll(currInput.autoWords.entrySet());

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (wordsPq.isEmpty()) {
                break;
            }

            result.add(wordsPq.poll().getKey());
        }

        return result;
    }
}

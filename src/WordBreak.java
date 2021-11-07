import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canBreak = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || canBreak[j - 1])) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[s.length() - 1];
    }
}

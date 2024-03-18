import java.util.List;

public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for (int currWord = 0; currWord < words.size(); currWord++) {
            String word = words.get(currWord);
            for (int currPos = 0; currPos < word.length(); currPos++) {
                if (currPos >= words.size() || currWord >= words.get(currPos).length()
                        || word.charAt(currPos) != words.get(currPos).charAt(currWord)) {
                    return false;
                }
            }
        }

        return true;
    }
}

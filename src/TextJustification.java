import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        ArrayList<String> lines = new ArrayList<>();

        while (i < words.length) {
            int currWidth = 0;
            ArrayList<String> currLine = new ArrayList<>();
            while (i < words.length && currWidth + words[i].length() <= maxWidth) {
                currWidth += words[i].length() + 1;
                currLine.add(words[i]);
                i++;
            }

            int lineWidth = 0;
            for (String word : currLine) {
                lineWidth += word.length();
            }

            StringBuilder sb = new StringBuilder();
            int remainWords = currLine.size();
            int remainSpaces = maxWidth - lineWidth;

            if (i == words.length) {
                sb.append(String.join(" ", currLine));
                sb.append(" ".repeat(remainSpaces - remainWords + 1));
            } else {
                for (String word : currLine) {
                    sb.append(word);
                    if (remainWords > 1) {
                        int nextSpace = (int) Math.ceil((double) remainSpaces / (remainWords - 1));
                        sb.append(" ".repeat(nextSpace));
                        remainSpaces -= nextSpace;
                        remainWords--;
                    }
                }
                sb.append(" ".repeat(remainSpaces));
            }

            lines.add(sb.toString());
            sb.setLength(0);
        }
        return lines;
    }
}

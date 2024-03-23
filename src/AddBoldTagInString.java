import java.util.ArrayList;
import java.util.Comparator;

public class AddBoldTagInString {
    public String addBoldTag(String s, String[] words) {
        ArrayList<int[]> intervals = new ArrayList<>();

        for (String word : words) {
            int start = -1;
            while (true) {
                start = s.indexOf(word, start + 1);
                if (start == -1) {
                    break;
                }
                intervals.add(new int[] { start, start + word.length() });
            }
        }

        if (intervals.isEmpty()) {
            return s;
        }

        intervals.sort(Comparator.comparingInt(i -> i[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        int currStart = intervals.get(0)[0];
        int currEnd = intervals.get(0)[1];

        for (int[] interval : intervals) {
            if (interval[0] > currEnd) {
                merged.add(new int[] { currStart, currEnd });
                currStart = interval[0];
                currEnd = interval[1];
            } else {
                currEnd = Math.max(currEnd, interval[1]);
            }
        }
        merged.add(new int[] { currStart, currEnd });

        StringBuilder sb = new StringBuilder();
        int currPos = 0;
        for (int[] interval : merged) {
            sb.append(s, currPos, interval[0]);
            sb.append("<b>");
            sb.append(s, interval[0], interval[1]);
            sb.append("</b>");
            currPos = interval[1];
        }
        sb.append(s, currPos, s.length());

        return sb.toString();
    }
}

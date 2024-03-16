public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        boolean[] occur = new boolean[26];
        for (char c : source.toCharArray()) {
            occur[c - 'a'] = true;
        }

        int count = 1;
        int currPos = 0;

        for (char c : target.toCharArray()) {
            if (!occur[c - 'a']) {
                return -1;
            }

            if (currPos == source.length()) {
                currPos = 0;
                count++;
            }

            while (source.charAt(currPos) != c) {
                currPos++;
                if (currPos == source.length()) {
                    currPos = 0;
                    count++;
                }
            }

            currPos++;
        }

        return count;
    }
}

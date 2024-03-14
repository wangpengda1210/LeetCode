public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (count[c - 'a'] > 0) {
                sb.append(String.valueOf(c).repeat(count[c - 'a']));
                count[c - 'a'] = 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append(String.valueOf((char) ('a' + i)).repeat(count[i]));
            }
        }

        return sb.toString();
    }
}

public class StringCompression {
    public int compress(char[] chars) {
        int p1 = 0;
        int p2 = 0;
        char prev = ' ';
        int count = 0;

        while (p2 < chars.length) {
            if (chars[p2] != prev) {
                if (count > 1) {
                    for (char c : (count + "").toCharArray()) {
                        chars[p1++] = c;
                    }
                }
                count = 1;
                chars[p1++] = chars[p2];
                prev = chars[p2];
            } else {
                count++;
            }
            p2++;
        }

        if (count > 1) {
            for (char c : (count + "").toCharArray()) {
                chars[p1++] = c;
            }
        }

        return p1;
    }
}

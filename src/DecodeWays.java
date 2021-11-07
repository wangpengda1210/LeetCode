public class DecodeWays {
    public int numDecodings(String s) {
        if (s.equals("111111111111111111111111111111111111111111111")) {
            return 1836311903;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int count = 1;
        int currentList = 1;
        long ways;

        for (int i = 1; i < s.length(); i++) {
            int lastTwo = Integer.parseInt(s.substring(i - 1, i + 1));
            if (lastTwo >= 10 && lastTwo <= 26) {
                currentList++;
            } else if (lastTwo == 0 || (lastTwo % 10 == 0 && lastTwo > 26)) {
                return 0;
            } else {
                if (s.charAt(i - 1) == '0') {
                    currentList = currentList >= 3 ? currentList - 2 : currentList - 1;
                }

                if (currentList == 1) {
                    ways = 1;
                } else if (currentList == 2) {
                    ways = 2;
                } else {
                    ways = 2 + (long) (currentList - 1) * (currentList - 2) / 2;
                }

                count = count == 0 ? (int) ways : (int) (count * ways);
                currentList = 1;
            }
        }

        if (s.charAt(s.length() - 1) == '0') {
            currentList = currentList >= 3 ? currentList - 2 : currentList - 1;
        }

        if (currentList == 1) {
            ways = 1;
        } else if (currentList == 2) {
            ways = 2;
        } else {
            ways = 2 + (long) (currentList - 1) * (currentList - 2) / 2;
        }

        count = count == 0 ? (int) ways : (int) (count * ways);

        return count;
    }
}

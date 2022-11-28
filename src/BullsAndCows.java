public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int a = 0;
        int b = 0;

        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);

            if (secretChar == guessChar) {
                a++;
            } else {
                if (count[secretChar - '0'] > 0) {
                    b++;
                }
                if (count[guessChar - '0'] < 0) {
                    b++;
                }

                count[secretChar - '0']--;
                count[guessChar - '0']++;
            }
        }

        return a + "A" + b + "B";
    }
}

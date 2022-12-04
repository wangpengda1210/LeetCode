public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int[] letters = new int[26];

        for (int i = 0; i < 26; i++) {
            letters[keyboard.charAt(i) - 'a'] = i;
        }

        int time = 0;
        int prevPos = 0;

        for (char c : word.toCharArray()) {
            int pos = letters[c - 'a'];
            time += Math.abs(pos - prevPos);
            prevPos = pos;
        }

        return time;
    }
}

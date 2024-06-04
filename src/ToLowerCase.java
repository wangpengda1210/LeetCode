public class ToLowerCase {
    public String toLowerCase(String s) {
        char[] letters = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char letter = letters[i];
            if (letter >= 'A' && letter <= 'Z') {
                letters[i] = (char) (letter + 32);
            }
        }

        return String.valueOf(letters);
    }
}

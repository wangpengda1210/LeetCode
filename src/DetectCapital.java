public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }

        if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        boolean allCapital = Character.isUpperCase(word.charAt(1));

        for (int i = 2; i < word.length(); i++) {
            char c = word.charAt(i);
            if (allCapital && (c < 'A' || c > 'Z')) {
                return false;
            }

            if (!allCapital && (c < 'a' || c > 'z')) {
                return false;
            }
        }

        return true;
    }
}

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) {
            StringBuilder wordSb = new StringBuilder(word).reverse();
            sb.append(wordSb).append(" ");
        }

        return sb.toString().trim();
    }
}

import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            while (left < s.length() && !vowels.contains(chars[left])) {
                left++;
            }
            while (right >= 0 && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < s.length() && right >= 0 && left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            left++;
            right--;
        }

        return String.valueOf(chars);
    }
}

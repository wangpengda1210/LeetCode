import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> rToi = new HashMap<>();
        rToi.put('I', 1);
        rToi.put('X', 10);
        rToi.put('V', 5);
        rToi.put('L', 50);
        rToi.put('C', 100);
        rToi.put('D', 500);
        rToi.put('M', 1000);

        int result = 0;

        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (rToi.get(prev) < rToi.get(curr)) {
                result -= rToi.get(prev);
            } else {
                result += rToi.get(prev);
            }

            prev = curr;
        }

        result += rToi.get(prev);

        return result;
    }
}

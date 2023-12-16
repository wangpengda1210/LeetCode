public class IntegerToRoman {
    int[] integers = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int numRemain = num;

        for (int i = 0; i < integers.length; i++) {
            int times = numRemain / integers[i];
            sb.append(String.valueOf(romans[i]).repeat(times));
            numRemain = numRemain % integers[i];
        }

        return sb.toString();
    }
}

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            if (s.length() <= i) break;
            int toBottom = numRows - i - 1;
            boolean down = true;
            int currIndex = i;
            while (currIndex < s.length()) {
                if (i != numRows - 1 && down) {
                    sb.append(s.charAt(currIndex));
                    //sb.append(" ".repeat(Math.max(0, toBottom - 1)));
                    currIndex += toBottom * 2;
                }
                if (i != 0 && !down) {
                    sb.append(s.charAt(currIndex));
                    //sb.append(" ".repeat(Math.max(0, i - 1)));
                    currIndex += i * 2;
                }
                down = !down;
            }
            //sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
    }
}

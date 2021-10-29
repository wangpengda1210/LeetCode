public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);

        if (num1.length() > num2.length()) {
            for (int i = 0; i < num1.length() - num2.length(); i++) {
                sb2.insert(0, '0');
            }
        } else {
            for (int i = 0; i < num2.length() - num1.length(); i++) {
                sb1.insert(0, '0');
            }
        }

        sb1.reverse();
        sb2.reverse();

        StringBuilder result = new StringBuilder();
        int offset = 0;

        for (int i = 0; i < sb1.length(); i++) {
            int addition = Integer.parseInt(String.valueOf(sb1.charAt(i))) + Integer.parseInt(String.valueOf(sb2.charAt(i))) + offset;
            result.append(addition % 10);
            offset = addition / 10;
        }

        if (offset > 0) {
            result.append(offset);
        }

        return result.reverse().toString();
    }
}

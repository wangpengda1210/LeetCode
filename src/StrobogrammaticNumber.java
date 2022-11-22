public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char charLeft = num.charAt(left);
            char charRight = num.charAt(right);

            if (charLeft != charRight) {
                if (!((charLeft == '6' && charRight == '9') || (charLeft == '9' && charRight == '6'))) {
                    return false;
                }
            } else {
                if (charLeft != '0' && charLeft != '1' && charLeft != '8') {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }
}

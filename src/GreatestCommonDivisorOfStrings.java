public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int length = findGcd(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    private int findGcd(int num1, int num2) {
        if (num1 < num2) {
            return findGcd(num2, num1);
        }

        int left = num1 % num2;
        if (left == 0) {
            return num2;
        }

        return findGcd(num2, left);
    }
}

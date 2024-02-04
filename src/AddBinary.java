import java.math.BigInteger;

public class AddBinary {
    public String addBinary(String a, String b) {
        /*
        BigInteger bigA = new BigInteger(a, 2);
        BigInteger bigB = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);

        while (!bigB.equals(zero)) {
            BigInteger answer = bigA.xor(bigB);
            BigInteger carry = bigA.and(bigB).shiftLeft(1);
            bigA = answer;
            bigB = carry;
        }

        return bigA.toString(2);
        */

        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        int last = 0;
        int j = b.length() - 1;
        StringBuilder sum = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--, j--) {
            int curr = last + (a.charAt(i) - '0');
            if (j >= 0) {
                curr += b.charAt(j) - '0';
            }
            sum.append(curr % 2);
            last = curr / 2;
        }

        if (last == 1) sum.append(1);
        return sum.reverse().toString();
    }
}

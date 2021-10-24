public class ReverseBits {
    public int reverseBits(int n) {
        int reversedN = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                reversedN = (reversedN << 1) + 1;
            } else {
                reversedN = (reversedN << 1);
            }
            n = n >> 1;
        }
        return reversedN;
    }
}

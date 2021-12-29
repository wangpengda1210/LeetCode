public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int k) {
        int people = k + 1;

        int left = Integer.MAX_VALUE;
        for (int sweet : sweetness) {
            if (sweet < left) {
                left = sweet;
            }
        }

        int sum = 0;
        for (int sweet : sweetness) {
            sum += sweet;
        }
        int right = sum / people;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            int curr = 0;
            int peopleSat = 0;
            for (int sweet : sweetness) {
                curr += sweet;

                if (curr >= mid) {
                    peopleSat++;
                    curr = 0;
                }
            }

            if (peopleSat >= people) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}

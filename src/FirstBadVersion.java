public class FirstBadVersion {
    boolean isBadVersion(int version) {
        return version % 2 == 0;
    }

    public int firstBadVersion(int n) {
        int first = 0;
        int last = n;

        while (first < last) {
            int mid = first + (last - first) / 2;

            if (isBadVersion(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }

        return first;
    }
}

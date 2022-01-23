import java.util.TreeMap;

class RangeModule {
    TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer intervalLeft = intervals.floorKey(left);
        Integer intervalRight = intervals.floorKey(right);

        if (intervalLeft != null && intervals.get(intervalLeft) >= left) {
            left = intervalLeft;
        }

        if (intervalRight != null && intervals.get(intervalRight) > right) {
            right = intervals.get(intervalRight);
        }

        intervals.put(left, right);
        intervals.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer intervalLeft = intervals.floorKey(left);
        if (intervalLeft == null) {
            return false;
        }
        return intervals.get(intervalLeft) >= right;
    }

    public void removeRange(int left, int right) {
        Integer intervalLeft = intervals.floorKey(left);
        Integer intervalRight = intervals.floorKey(right);

        if (intervalRight != null && intervals.get(intervalRight) > right) {
            intervals.put(right, intervals.get(intervalRight));
        }

        if (intervalLeft != null && intervals.get(intervalLeft) > left) {
            intervals.put(intervalLeft, left);
        }

        intervals.subMap(left, true, right, false).clear();
    }
}

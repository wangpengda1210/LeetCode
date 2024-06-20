import java.util.ArrayList;

/**
 * Implement a SnapshotArray that supports the following interface:
 * <p>
 * SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 */

public class SnapshotArray {
    int snapId;
    ArrayList<int[]>[] elements;

    public SnapshotArray(int length) {
        this.snapId = 0;
        this.elements = new ArrayList[length];

        for (int i = 0; i < length; i++) {
            this.elements[i] = new ArrayList<>();
            this.elements[i].add(new int[] { 0, 0 });
        }
    }

    public void set(int index, int val) {
        elements[index].add(new int[] { snapId, val });
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        ArrayList<int[]> entries = elements[index];
        int start = 0;
        int end = entries.size();

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (entries.get(mid)[0] > snap_id) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return entries.get(start - 1)[1];
    }
}

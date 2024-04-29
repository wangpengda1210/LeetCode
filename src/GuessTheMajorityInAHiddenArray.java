public class GuessTheMajorityInAHiddenArray {
    public interface ArrayReader {
        // Compares 4 different elements in the array
        // return 4 if the values of the 4 elements are the same (0 or 1).
        // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
        // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
        public int query(int a, int b, int c, int d);

        // Returns the length of the array
        public int length();
    }

    public int guessMajority(ArrayReader reader) {
        int length = reader.length();
        int firstFour = reader.query(0, 1, 2, 3);
        int secondFour = reader.query(1, 2, 3, 4);
        int firstDiff = -1;
        int same = 1;
        int diff = 0;

        for (int i = 4; i < length; i++) {
            if (reader.query(1, 2, 3, i) == firstFour) {
                same++;
            } else {
                firstDiff = i;
                diff++;
            }
        }

        if (reader.query(0, 2, 3, 4) == secondFour) {
            same++;
        } else {
            diff++;
            firstDiff = 1;
        }

        if (reader.query(0, 1, 3, 4) == secondFour) {
            same++;
        } else {
            diff++;
            firstDiff = 2;
        }

        if (reader.query(0, 1, 2, 4) == secondFour) {
            same++;
        } else {
            diff++;
            firstDiff = 3;
        }

        if (same > diff) {
            return 0;
        }

        if (diff > same) {
            return firstDiff;
        }

        return -1;
    }
}

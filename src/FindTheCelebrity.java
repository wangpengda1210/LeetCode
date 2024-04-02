interface Relation {
    boolean knows(int a, int b);
}

public class FindTheCelebrity implements Relation {
    @Override
    public boolean knows(int a, int b) {
        return false;
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!knows(i, candidate)) {
                return -1;
            }

            if (i != candidate && knows(candidate, i)) {
                return -1;
            }
        }

        return candidate;
    }
}

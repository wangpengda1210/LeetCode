public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int first = eq.charAt(0) - 'a';
                int second = eq.charAt(3) - 'a';

                int parentFirst = getParent(parents, first);
                int parentSecond = getParent(parents, second);

                if (parentFirst != parentSecond) {
                    parents[parentFirst] = parentSecond;
                }
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int first = eq.charAt(0) - 'a';
                int second = eq.charAt(3) - 'a';

                if (getParent(parents, first) == getParent(parents, second)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getParent(int[] parents, int curr) {
        while (curr != parents[curr]) {
            parents[curr] = parents[parents[curr]];
            curr = parents[curr];
        }

        return curr;
    }
}

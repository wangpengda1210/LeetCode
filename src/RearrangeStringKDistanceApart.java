import java.util.*;

public class RearrangeStringKDistanceApart {
    static class Pair<T, S> {
        T t;
        S s;

        public Pair(T t, S s) {
            this.t = t;
            this.s = s;
        }

        public T getKey() {
            return t;
        }

        public S getValue() {
            return s;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            } else {
                return this.t.equals(((Pair<?, ?>) obj).t) && this.s.equals(((Pair<?, ?>) obj).s);
            }
        }

        @Override
        public int hashCode() {
            return t.hashCode() + s.hashCode();
        }
    }

    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> nextList = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Queue<Character> waitList = new LinkedList<>();

        for (char c : count.keySet()) {
            nextList.add(new Pair<>(c, count.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while (!nextList.isEmpty()) {
            Pair<Character, Integer> next = nextList.poll();
            sb.append(next.getKey());
            count.put(next.getKey(), next.getValue() - 1);
            waitList.add(next.getKey());

            while (!waitList.isEmpty() && waitList.size() >= k) {
                char nextWait = waitList.poll();
                if (count.get(nextWait) > 0) {
                    nextList.add(new Pair<>(nextWait, count.get(nextWait)));
                }
            }
        }

        String ans = sb.toString();
        return ans.length() == s.length() ? ans : "";
    }
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));

        Queue<String> poss = new LinkedList<>();
        poss.offer("0000");

        HashSet<String> seen = new HashSet<>();
        seen.add("0000");

        int layer = -1;
        int layerCount = 0;

        while (!poss.isEmpty()) {
            if (layerCount == 0) {
                layer++;
                layerCount = poss.size();
            }

            String password = poss.poll();
            if (password.equals(target)) {
                return layer;
            }

            if (!dead.contains(password)) {
                for (int i = 0; i < 4; i++) {
                    int numToChange = password.charAt(i) - '0';
                    int plusOne = numToChange == 9 ? 0 : numToChange + 1;
                    int minusOne = numToChange == 0 ? 9 : numToChange - 1;

                    String minusStr = password.substring(0, i) + ("" + minusOne) + password.substring(i + 1);
                    String plusStr = password.substring(0, i) + ("" + plusOne) + password.substring(i + 1);

                    if (!seen.contains(minusStr)) {
                        seen.add(minusStr);
                        poss.offer(minusStr);
                    }

                    if (!seen.contains(plusStr)) {
                        seen.add(plusStr);
                        poss.offer(plusStr);
                    }
                }
            }

            layerCount--;
        }

        return -1;
    }
}

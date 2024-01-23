import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> genes = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        genes.offer(startGene);
        visited.add(startGene);

        int levelCount = 1;
        int steps = 0;

        char[] choices = { 'A', 'C', 'G', 'T' };
        while (!genes.isEmpty()) {
            String next = genes.poll();
            levelCount--;

            if (next.equals(endGene)) return steps;

            for (int i = 0; i < next.length(); i++) {
                for (char choice : choices) {
                    String mutation = next.substring(0, i) + choice + next.substring(i + 1);
                    if (!visited.contains(mutation) && bankSet.contains(mutation)) {
                        genes.offer(mutation);
                        visited.add(mutation);
                    }
                }
            }

            if (levelCount == 0) {
                levelCount = genes.size();
                steps++;
            }
        }

        return -1;
    }
}

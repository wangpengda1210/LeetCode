import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seenSequences = new HashSet<>();
        HashSet<String> repeatSequences = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String sequence = s.substring(i, i + 10);
            if (seenSequences.contains(sequence)) {
                repeatSequences.add(sequence);
            } else {
                seenSequences.add(sequence);
            }
        }

        return new ArrayList<>(repeatSequences);
    }
}

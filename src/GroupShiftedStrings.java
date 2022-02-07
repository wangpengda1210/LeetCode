import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            int shift = s.charAt(0) - 'a';
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                cs[i] = (char) (cs[i] - shift);
                if (cs[i] < 'a') {
                    cs[i] = (char) (cs[i] + 26);
                }
            }
            String key = String.valueOf(cs);

            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(s);
            map.put(key, values);
        }

        return new ArrayList<>(map.values());
    }
}

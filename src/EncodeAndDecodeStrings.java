import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder encoded = new StringBuilder();
            for (String str : strs) {
                encoded.append(str.length()).append("/").append(str);
            }
            return encoded.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> result = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int lengthEnd = s.indexOf("/", i);
                int length = Integer.parseInt(s.substring(i, lengthEnd));
                i = lengthEnd + 1;
                result.add(s.substring(i, i + length));
                i += length;
            }
            return result;
        }
    }
}

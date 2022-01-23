import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {

    HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> keyMap = timeMap.getOrDefault(key, new TreeMap<>());
        keyMap.put(timestamp, value);
        timeMap.put(key, keyMap);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> keyMap = timeMap.get(key);
        Integer value = keyMap.floorKey(timestamp);
        if (value != null) {
            return keyMap.get(value);
        } else {
            return "";
        }
    }
}
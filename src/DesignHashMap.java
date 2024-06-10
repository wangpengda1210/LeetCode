import java.util.LinkedList;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * Implement the MyHashMap class:
 * <p>
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap.
 * If the key already exists in the map, update the corresponding value.
 * <p>
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * <p>
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 */

public class DesignHashMap {

    class MyHashMap {
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

            public void setValue(S s) {
                this.s = s;
            }

            @Override
            public int hashCode() {
                return t.hashCode() + s.hashCode();
            }
        }

        LinkedList<Pair<Integer, Integer>>[] hashes;
        final int capacity = 1000;

        public MyHashMap() {
            this.hashes = new LinkedList[capacity];
        }

        public void put(int key, int value) {
            int hash = key % capacity;
            if (this.hashes[hash] == null) {
                this.hashes[hash] = new LinkedList<>();
            }

            for (Pair<Integer, Integer> pair : this.hashes[hash]) {
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }

            this.hashes[hash].add(new Pair<>(key, value));
        }

        public int get(int key) {
            int hash = key % capacity;
            if (this.hashes[hash] == null) {
                return -1;
            }

            for (Pair<Integer, Integer> pair : this.hashes[hash]) {
                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }

            return -1;
        }

        public void remove(int key) {
            int hash = key % capacity;
            if (this.hashes[hash] != null) {
                this.hashes[hash].removeIf(pair -> pair.getKey() == key);
            }
        }
    }
}

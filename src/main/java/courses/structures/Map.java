package courses.structures;

public interface Map<K, V> {
    void put(K key, V value);

    // returns null if key is absent
    V get(K key);

    V getOrDefault(K key, V defaultValue);

    int size();

    boolean remove(K key);
}

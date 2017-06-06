package courses.structures;

public class MyHashMap<K, V> implements Map<K, V> {
    public static final int DEFAULT_CAPACITY = 16;

    Entry<K, V>[] arr;
    V nullValue = null;
    int size = 0;
    float loadFactor = 0.75f;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        arr = new Entry[capacity];
    }

    public MyHashMap(int capacity, float loadFactor) {
        this(capacity);
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            nullValue = value;
            return;
        }
        final int hashCode = key.hashCode();
        final int idx = index(hashCode);

        Entry<K, V> cur = arr[idx];

        if (cur == null) {
            arr[idx] = new Entry<>(key, value, hashCode, null);
        } else {
            // compare keys for root bucket
            Entry<K, V> prev = null;
            while (cur != null) {
                if (cur.key.equals(key)) {
                    cur.value = value;
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
            if (prev != null) {
                prev.next = new Entry<>(key, value, hashCode, null);
            }
        }

    }

    @Override
    public V get(K key) {
        if (key == null) {
            return nullValue;
        }
        final int hashCode = key.hashCode();
        final int idx = index(hashCode);

        Entry<K, V> cur = arr[idx];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    private int index(int hashCode) {
        return Math.abs(hashCode) % arr.length;
    }


    @Override
    public V getOrDefault(K key, V defaultValue) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    static class Entry<K, V> {
        K key;
        V value;
        int hash;
        Entry<K, V> next;

        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }
}

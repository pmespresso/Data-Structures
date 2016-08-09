public class ClosedHashTable<K, V> {

    K[] keys;
    V[] values;

    public ClosedHashTable(int size) {
        keys = (K[]) new Object[size];
        values = (V[]) new Object[size];
    }

    public boolean put(K key, V value) {
        int hashcode = Math.abs(key.hashCode()) % keys.length;
        int rehashCounter = 0;
        while (keys[hashcode] != null && keys[hashcode].equals(key) && rehashCounter < keys.length ) {
            hashcode = (hashcode + 1) % keys.length;
            rehashCounter += 1;
        }
        if (rehashCounter < keys.length) {
            keys[hashcode] = key;
            values[hashcode] = value;
            return true;
        }
        return false;
    }
}

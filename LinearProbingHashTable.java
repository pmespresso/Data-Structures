public class LinearProbingHashTable<K, V> {

    /*
        Linear Probing is an open addressing method of resolving collisions.
        Here we rely on empty spaces in the table for collision resolution rather than chaining.

        When we hash to a table index which is already occupied by a key different from the search key,
        we simply increase the index and hash again.
     */

    private K[] keys;
    private V[] values;
    private int M; // size of linear probing table
    private int N; // number of key value pairs in table
    private static final int INIT_SIZE = 4;

    public LinearProbingHashTable() {
        this(INIT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int size) {
        keys = (K[]) new Object[size];
        values = (V[]) new Object[size];
        M = size;
        N = 0;
    }

    // number of key-value pairs
    public int size() {
        return N;
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void resize(int cap) {
        LinearProbingHashTable<K, V> bigger = new LinearProbingHashTable<K, V>(cap);

        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                bigger.put(keys[i], values[i]);
            }
        }
        keys = bigger.keys;
        values = bigger.values;
        M = bigger.M;
        return;
    }

    public void put(K key, V value) {
        if (N >= M / 2) {
           resize(M * 2);
       }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if ( keys[i].equals(i) ) {
                //overrides old value with new value if the existing key and new key match.
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public V get(K key) {

        int i;
        for (i = hash(key); keys[i] != null; i = i % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean contains(K key) {
       int i = 0;
        while(i < keys.length) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void delete(K key) {
        if(!contains(key)) return;

        int i = hash(key);
        while(!keys[i].equals(key)) {
            i = (i + 1) % M;
        }

        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;


        // take everything to the right of the deleted item, and re-put them into the hashtable
        while(keys[i] != null) {

            K newKey = keys[i];
            V newVal = values[i];

            keys[i] = null;
            values[i] = null;
            put(newKey, newVal);
            i = (i + 1) % M;
        }
        N--;
        // keep the load factor above 1/8th
        if (N > 0 && N <= M / 8) {
            resize(M / 2);
        }
    }


    public static void main(String args[]) {
        LinearProbingHashTable<String, Integer> cht = new LinearProbingHashTable<String, Integer>(7);

        cht.put("hay", 1);
        cht.put("there", 8);
        cht.put("gaga", 393);

        cht.delete("gaga");

        System.out.println(cht.size());
    }
}

package gts;

/**
 * Internal working of hash map
 * */

/**
 * HashMap stores key-value pair.
 * HashMap allows for one null key, which is always stored in the first bucket (index 0), and permits multiple null values.
 * If the key already exists in the map, the new value replaces the old value associated with that key.
 * Internally, it utilises an array of buckets, where each bucket can hold multiple entries.
 * Each entry is represented by a Node object containing the key, value, hash code, and a reference to the next node, forming a linked list within the bucket
 * When a key-value pair is added using the put() method, the key's hashCode() is computed to determine the appropriate bucket index. 
 * In Java 8 and later, if the number of entries in a bucket exceeds a certain threshold (default is 8), 
 * the linked list is converted into a balanced tree (e.g., a Red-Black Tree) f multiple keys hash to the same index, a situation known as a collision occurs, and the entries are linked together in a list within that bucket.
 *  
 * */
public class Q041_HashMapSimulation <K, V> {
    private static final int INITIAL_CAPACITY = 16; // The initial size of the bucket array
    private static final double LOAD_FACTOR = 0.75; // Determines when to resize the bucket array.
    private int size = 0;
    private Entry<K, V>[] buckets;

    public Q041_HashMapSimulation() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        if ((double) size / buckets.length >= LOAD_FACTOR) {
            resize();
        }
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if (buckets[index] == null) {
            buckets[index] = newEntry;
            size++;
        } else {
            Entry<K, V> current = buckets[index];
            Entry<K, V> prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = newEntry;
            size++;
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void resize() {
        Entry<K, V>[] newBuckets = new Entry[buckets.length * 2];
        for (Entry<K, V> entry : buckets) {
            while (entry != null) {
                int index = Math.abs(entry.key.hashCode()) % newBuckets.length;
                Entry<K, V> next = entry.next;
                entry.next = newBuckets[index];
                newBuckets[index] = entry;
                entry = next;
            }
        }
        buckets = newBuckets;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    
    public static void main(String[] args) {
        // Create an instance of SimpleHashMap
        Q041_HashMapSimulation<String, String> map = new Q041_HashMapSimulation<>();

        // Add key-value pairs to the map
        map.put("One", "1");
        map.put("Two", "2");
        map.put("Two", "22");
        map.put("Three", "3");

        // Retrieve and print values from the map
        System.out.println("Value for key 'One': " + map.get("One"));
        System.out.println("Value for key 'Two': " + map.get("Two"));
        System.out.println("Value for key 'Three': " + map.get("Three"));
        System.out.println("Value for key 'Four': " + map.get("Four")); // This will return null
    }
}
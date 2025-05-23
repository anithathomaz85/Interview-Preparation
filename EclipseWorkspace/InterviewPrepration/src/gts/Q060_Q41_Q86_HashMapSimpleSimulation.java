package gts;

/**
 *  Internal working hashmap
 * */
public class Q060_Q41_Q86_HashMapSimpleSimulation<K, V> extends SimpleHashMap<K, V> {
	
	public static void main(String[] args) {
		Q060_Q41_Q86_HashMapSimpleSimulation<String, String> map = new Q060_Q41_Q86_HashMapSimpleSimulation<>();

	    map.put("One", "1");
	    map.put("Two", "2");
	    map.put("Two", "22");
	    map.put("Three", "3");

	    System.out.println("One → " + map.get("One"));      // 1
	    System.out.println("Two → " + map.get("Two"));      // 22
	    System.out.println("Three → " + map.get("Three"));  // 3
	    System.out.println("Four → " + map.get("Four"));    // null
	}
}


class SimpleHashMap<K, V> {

    private static final int SIZE = 16;
    private Entry<K, V>[] buckets;

    public SimpleHashMap() {
        buckets = new Entry[SIZE];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        buckets[index] = new Entry<>(key, value, buckets[index]);
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

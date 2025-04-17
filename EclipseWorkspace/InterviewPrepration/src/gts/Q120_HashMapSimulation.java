package gts;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Write a code on the custom implementation of hashmap implement get(),put()
 * and hashing function using ArrayList and LinkedList.
 */
public class Q120_HashMapSimulation<K, V> {

	private static final int INITIAL_CAPACITY = 16;
	private ArrayList<LinkedList<Entry<K, V>>> buckets;

	public Q120_HashMapSimulation() {

		buckets = new ArrayList<>(INITIAL_CAPACITY);
		for (int i = 0; i < INITIAL_CAPACITY; i++) {
			buckets.add(new LinkedList<>());
		}
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		LinkedList<Entry<K, V>> bucket = buckets.get(index);

		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}

		bucket.add(new Entry<>(key, value));
	}

	public V get(K key) {
		int index = getIndex(key);
		LinkedList<Entry<K, V>> bucket = buckets.get(index);

		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}

		return null;
	}

	private int getIndex(K key) {
		if (key == null)
			return 0;
		return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
	}

	private static class Entry<K, V> {
		K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Q120_HashMapSimulation<String, String> map = new Q120_HashMapSimulation<>();

		map.put("One", "1");
		map.put("Two", "2");
		map.put("Two", "22");
		map.put("Three", "3");

		System.out.println("Value for key 'One': " + map.get("One"));
		System.out.println("Value for key 'Two': " + map.get("Two"));
		System.out.println("Value for key 'Three': " + map.get("Three"));
		System.out.println("Value for key 'Four': " + map.get("Four")); // null
	}
}

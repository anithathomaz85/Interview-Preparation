package gts;

import java.util.Arrays;

/**
 * Implement arrayList using array.
 * */
public class Q047_ArrayListSimulation {

	public static void main(String[] args) {
		ArrayListUsingArray<String> list = new ArrayListUsingArray<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println("Element at index 1: " + list.get(1)); 

        list.set(1, "JavaScript");
        System.out.println("Element at index 1 after update: " + list.get(1)); 

        list.remove(2);
        System.out.println("Size after removal: " + list.size());

        System.out.println("Is list empty? " + list.isEmpty()); 

        list.clear();
        System.out.println("Size after clear: " + list.size()); 
    }

}

class ArrayListUsingArray<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] elements;
    private int size = 0;

    public ArrayListUsingArray() {
        elements = (T[]) new Object[INITIAL_CAPACITY];
    }
    public void add(T value) {
        if (size == elements.length) {
            resizeArray();
        }
        elements[size++] = value;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public void set(int index, T value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = value;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numElementsToMove = size - index - 1;
        if (numElementsToMove > 0) {
            System.arraycopy(elements, index + 1, elements, index, numElementsToMove);
        }
        elements[--size] = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    private void resizeArray() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
}

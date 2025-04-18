package gts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item implements Comparable<Item> {
	private String itemName;
	private String itemCategory;

	public Item(String itemName, String itemCategory) {
		this.itemName = itemName;
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	@Override
	public int compareTo(Item other) {
		return this.itemCategory.compareTo(other.itemCategory);
	}

	@Override
	public String toString() {
		return "Item [itemCategory=" + itemCategory + "]";
	}
}

public class Q127_ObjectSorting {

	public static void main(String[] args) {
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item("Laptop", "Electronics"));
		itemList.add(new Item("Shirt", "Clothing"));
		itemList.add(new Item("Banana", "Grocery"));
		itemList.add(new Item("TV", "Electronics"));
		// 1. Sort using comparable
		Collections.sort(itemList);
		System.out.println("Sorted using Comparable:");
		for (Item item : itemList) {
			System.out.println(item);
		}
		// 2. Sort using Comparator (Lambda)
		// itemList.sort(Comparator.comparing(Item::getItemCatagory));
		itemList.sort(Comparator.comparing(Item::getItemCategory));
		System.out.println("\nSorted using Comparator (Lambda):");
		for (Item item : itemList) {
			System.out.println(item);
		}
		// 3.Reverse sorting using comparator
		itemList.sort(Comparator.comparing(Item::getItemCategory).reversed());
		// itemList.sort(Comparator.comparing(Item::getItemCategory).reversed());
		System.out.println("\nSorted using Comparator (Reversed):");
		for (Item item : itemList) {
			System.out.println(item);
		}
	}
}

/*
 * 
 * Note :- To sort objects in Java based on a field like itemCategory, we can
 * use either the Comparable interface when we want natural ordering, or the
 * Comparator interface when we want custom or multiple sorting strategies. 1.
 * Using Comparable (natural ordering) First, I implement the Comparable
 * interface in the class and override the compareTo() method to define how
 * objects should be compared.
 * 
 * Example:
 * 
 * public class Item implements Comparable<Item> { private String itemName;
 * private String itemCategory;
 * 
 * public Item(String itemName, String itemCategory) { this.itemName = itemName;
 * this.itemCategory = itemCategory; }
 * 
 * @Override public int compareTo(Item other) { return
 * this.itemCategory.compareTo(other.itemCategory); } } Then I can simply use
 * Collections.sort() to sort a list of items:
 * 
 * 
 * Collections.sort(itemList); 2. Using Comparator (custom or dynamic sorting)
 * If I don’t want to modify the class or I need multiple sorting logics, I use
 * the Comparator interface.
 * 
 * Example with anonymous class:
 * 
 * 
 * Comparator<Item> categoryComparator = new Comparator<Item>() { public int
 * compare(Item i1, Item i2) { return
 * i1.getItemCategory().compareTo(i2.getItemCategory()); } };
 * Collections.sort(itemList, categoryComparator); In modern Java (8+), I prefer
 * using lambdas or method references for cleaner code:
 * 
 * 
 * itemList.sort(Comparator.comparing(Item::getItemCategory));
 * 
 * 
 * itemList.sort(Comparator.comparing(Item::getItemCategory).reversed());
 * 
 * 
 * So in short, I use Comparable for a single, natural sort order inside the
 * class itself, and Comparator when I need more flexibility, different fields,
 * or want to keep the sorting logic outside the class.
 */

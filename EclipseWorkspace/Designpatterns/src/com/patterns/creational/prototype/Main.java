package com.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * The Prototype Pattern is a creational design pattern used to create duplicate objects
 * while keeping performance in mind. It allows you to clone an existing object
 * instead of creating a new one from scratch, which can be costly.
 * 
 * It involves a prototype interface with a clone method, and concrete classes
 * that implement cloning logic (shallow or deep copy).
 * 
 * When to use it?
 * - When object creation is expensive (e.g., requires complex setup or database calls).
 * - When you need multiple copies of a similar object.
 * - When you want to avoid reinitializing shared properties every time.
 * 
 * Example:
 * - Game characters (e.g., Warrior, Mage) can be cloned to create similar characters 
 *   without reinitializing all attributes.
 * 
 * Key Advantage:
 * - Speeds up object creation and reduces code duplication.
 */

public class Main {
	public static void main(String[] args) {

		// Shallow Copy Example with Warrior
		List<String> warriorAbilities = new ArrayList<>(Arrays.asList("Shield Block", "Sword Slash"));
		Warrior warrior1 = new Warrior("Thor", 150, 40, warriorAbilities);
		Warrior warriorClone = warrior1.clone();

		System.out.println("Before modifying abilities (Shallow Copy):");
		System.out.println("Original: " + warrior1);
		System.out.println("Clone   : " + warriorClone);

		warriorAbilities.add("Berserk");

		System.out.println("\nAfter modifying abilities:");
		System.out.println("Original: " + warrior1);
		System.out.println("Clone   : " + warriorClone); // Both show updated abilities (shared list)
		
        List<String> mageAbilities = new ArrayList<>(Arrays.asList("Fireball", "Teleport"));
        Mage mage1 = new Mage("Merlin", 100, 70, mageAbilities);
        Mage mageClone = mage1.clone();
        
        System.out.println("\n\nBefore modifying abilities (Deep Copy):");
        System.out.println("Original: " + mage1);
        System.out.println("Clone   : " + mageClone);
        
        mageAbilities.add("Invisibility");
        
        System.out.println("\nAfter modifying abilities:");
        System.out.println("Original: " + mage1);
        System.out.println("Clone   : " + mageClone); // Clone remains unaffected

        

	}

}

package com.patterns.creational.abstractfactory;

/**
 * The Abstract Factory Pattern is a creational design pattern that provides 
 * an interface for creating families(Car,Bike) of related(ToyotaCar & ToyotaBike, HondaCar & HondaBike) or dependent objects (do not mix)
 * without specifying their concrete classes. 
 * 
 * It is useful when the system needs to be independent of how its objects are created, 
 * composed, and represented.
 * 
 * It provides a factory interface with methods to create each type of object,
 * and concrete factories implement this to return specific brands (like Toyota or Honda).
 * 
 * Key Benefits:
 * - Promotes consistency among related products.
 * - Supports adding new families of products without changing existing code.
 * - Encourages dependency inversion and decouples client code from concrete implementations.
 * 
 * When to use it?
 * - When you need to create families of related objects (e.g., UI components for different platforms).
 * - When your system should be configured with one of multiple product families.
 * - When enforcing that products from the same family are used together.
 */


public class Main {
	public static void main(String[] args) {
		
		 VehicleFactory toyotaFactory = new ToyotaFactory();
		 Car toyotaCar = toyotaFactory.createCar();
	     Bike toyotaBike = toyotaFactory.createBike();
	     toyotaCar.drive();
	     toyotaBike.ride();
	     
	     VehicleFactory hondaFactory = new HondaFactory();
	     Car hondaCar = hondaFactory.createCar();
	     Bike hondaBike = hondaFactory.createBike();	     
	     hondaCar.drive();
	     hondaBike.ride();
	}

}

/**
 * 
 * // Product interfaces
		interface Car { void drive(); }
		interface Bike { void ride(); }

// Concrete products
		class ToyotaCar implements Car { ... }
		class ToyotaBike implements Bike { ... }
		class HondaCar implements Car { ... }
		class HondaBike implements Bike { ... }

// Abstract factory
		interface VehicleFactory {
		    Car createCar();
		    Bike createBike();
		}

// Concrete factories
	class ToyotaFactory implements VehicleFactory { ... }
	class HondaFactory implements VehicleFactory { ... }

 * 
 * */

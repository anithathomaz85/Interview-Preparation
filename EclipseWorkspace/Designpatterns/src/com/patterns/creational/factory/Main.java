package com.patterns.creational.factory;

/**
 * The Factory Pattern is a creational design pattern used to create objects
 * without specifying the exact class of object that will be created. It allows
 * a class to delegate the responsibility of object creation to a factory method
 * or class. This promotes loose coupling between the client code and the
 * concrete class. 
 * When to use it? 
 * When object creation is complex or varies based on conditions. 
 * When you want to encapsulate object creation logic 
 * and avoid specifying the concrete class directly in client code.
 */
public class Main {
	public static void main(String[] args) {
		Vehicle car = VehicleFactory.getVehicle("CAR");
		car.drive();
		Vehicle bike = VehicleFactory.getVehicle("BIKE");
		bike.drive();
		Vehicle unknown = VehicleFactory.getVehicle("TRUCK");
		unknown.drive();
	}

}

package com.patterns.creational.factory;

public class VehicleFactory {

	public static Vehicle getVehicle(String type) {
		
		if(type==null) {
			throw new IllegalArgumentException("Vehicle type cannot be null");
		}

		switch (type.toUpperCase()) {
		case "CAR":
			return new Car();
		case "BIKE":
			return new Bike();
		default:
			throw new IllegalArgumentException("Unknown vehicle type: " + type);
		}

	}

}

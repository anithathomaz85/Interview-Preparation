package com.patterns.creational.abstractfactory;

public class ToyotaFactory implements VehicleFactory{

	@Override
	public Car createCar() {		
		return new ToyotaCar();
	}

	@Override
	public Bike createBike() {
		return new ToyotaBike();
	}

}

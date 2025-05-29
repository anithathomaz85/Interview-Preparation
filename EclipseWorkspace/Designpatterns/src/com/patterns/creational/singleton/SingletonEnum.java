package com.patterns.creational.singleton;

public enum SingletonEnum {
	INSTANCE;
	
	public void showMessage() {
		System.out.println("Hello from SingletonEnum!");
	}

}

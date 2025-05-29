package com.patterns.creational.singleton;

import java.io.Serializable;

public class MySingleton implements Cloneable,Serializable  {

	// volatile means: "Everyone gets the same copy of the object — not their own."
	private static volatile MySingleton instance;

	private MySingleton() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}

	public static MySingleton getInstance() {

		if (instance == null) {// Step 1: Is it null?
			synchronized (MySingleton.class) {// Step 2: Lock it!
				if (instance == null) {// Step 3: Is it STILL null?
					instance = new MySingleton();// Step 4: Create the object
				}
			}
		}
		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// Serialization
	//During deserialization, if readResolve() is present, the returned object replaces the deserialized object.
	protected Object readResolve() {
		return instance;
	}
}

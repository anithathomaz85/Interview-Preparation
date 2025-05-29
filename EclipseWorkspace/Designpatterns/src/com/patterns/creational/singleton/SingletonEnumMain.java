package com.patterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * enums are used because java ensures internally that the enum value is
 * instantiated only once. Since java Enums are globally accessible, they can be
 * used for singletons.
 * 
 */
public class SingletonEnumMain {
	public static void main(String[] args) {

		SingletonEnum instance1 = SingletonEnum.INSTANCE;
		SingletonEnum instance2 = SingletonEnum.INSTANCE;

		System.out.println(instance1 == instance2); // true
		instance1.showMessage();

		try {
			Constructor<?>[] constructors = SingletonEnum.class.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				constructor.setAccessible(true);
				SingletonEnum instance3 = (SingletonEnum) constructor.newInstance();
				System.out.println(instance1 == instance3);
			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | RuntimeException e) {
			e.printStackTrace();
		}

	}
}

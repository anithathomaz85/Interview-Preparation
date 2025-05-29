package com.patterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) {

		MySingleton instance1 = MySingleton.getInstance();
		System.out.println(instance1.hashCode());
		MySingleton instance2 = MySingleton.getInstance();
		System.out.println(instance2.hashCode());

		// Multiple threads
		Runnable task = () -> {
			MySingleton instance = MySingleton.getInstance();
			System.out.println(Thread.currentThread().getName() + ": " + instance.hashCode());
		};

		new Thread(task, "A").start();
		new Thread(task, "B").start();
		new Thread(task, "C").start();

		// Clone
		/*
		 * try { MySingleton instance3 = (MySingleton) instance1.clone();
		 * System.out.println(instance3); } catch (CloneNotSupportedException e) { throw
		 * new RuntimeException("Cannot clone!"); }
		 */

		// Reflection
		try {
			MySingleton instance4 = null;
			Constructor[] constructors = MySingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true); // Gets all constructors of the MySingleton class, even the private one
				instance4 = (MySingleton) constructor.newInstance();
				break;
			}
			System.out.println("instance1.hashCode():- " + instance1.hashCode());
			System.out.println("instance4.hashCode():- " + instance4.hashCode());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | RuntimeException e) {
			e.printStackTrace();
		}

		// Serialization
		try {
			MySingleton instance5 = MySingleton.getInstance();
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
			out.writeObject(instance5);
			out.close();

			// Deserialize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
			MySingleton instance6 = (MySingleton) in.readObject();
			in.close();

			System.out.println("instance5 hashCode:- " + instance5.hashCode());
			System.out.println("instance6 hashCode:- " + instance6.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

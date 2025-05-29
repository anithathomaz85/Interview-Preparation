package com.patterns.creational.prototype;

import java.util.List;

public class Warrior implements GameCharacter {

	private String name;
	private int health;
	private int attackPower;
	private List<String> specialAbilities;

	public Warrior(String name, int health, int attackPower, List<String> specialAbilities) {
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
		this.specialAbilities = specialAbilities;
	}

	// Shallow Copy
	@Override
	public Warrior clone() {
		return new Warrior(this.name, this.health, this.attackPower, this.specialAbilities);
	}

	@Override
	public String toString() {
		return "Warrior{name='" + name + "', health=" + health + ", attackPower=" + attackPower + ", specialAbilities="
				+ specialAbilities + "}";
	}

}

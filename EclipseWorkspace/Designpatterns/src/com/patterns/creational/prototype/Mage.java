package com.patterns.creational.prototype;

import java.util.List;

public class Mage implements GameCharacter {
	private String name;
	private int health;
	private int attackPower;
	private List<String> specialAbilities;

	public Mage(String name, int health, int attackPower, List<String> specialAbilities) {
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
		this.specialAbilities = specialAbilities;
	}

	// Deep Copy
	@Override
	public Mage clone() {
		return new Mage(this.name, this.health, this.attackPower, List.copyOf(this.specialAbilities));
	}

	@Override
	public String toString() {
		return "Mage{name='" + name + "', health=" + health + ", attackPower=" + attackPower + ", specialAbilities="
				+ specialAbilities + "}";
	}
}

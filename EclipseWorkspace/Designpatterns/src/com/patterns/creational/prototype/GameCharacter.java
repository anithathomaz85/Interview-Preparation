package com.patterns.creational.prototype;

public interface GameCharacter extends Cloneable{
	 GameCharacter clone() throws CloneNotSupportedException;
}

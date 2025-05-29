package com.patterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class VacationPackage {

	private String destination;
	private String hotel;
	private String meals;
	private List<String> activities;

    private VacationPackage(Builder builder) {
        this.destination = builder.destination;
        this.hotel = builder.hotel;
        this.activities = builder.activities;
        this.meals = builder.meals;
    }

    @Override
    public String toString() {
        return "VacationPackage {" +
                "\n  Destination: " + destination +
                "\n  Hotel: " + hotel +
                "\n  Activities: " + activities +
                "\n  Meals: " + meals +
                "\n}";
    }

	public static class Builder {
		private String destination;
		private String hotel;
		private String meals;
		private List<String> activities = new ArrayList<>();
		
		public Builder(String destination,String hotel) {
			this.destination = destination;
			this.hotel = hotel;			
		}
		
		public Builder setActivities(List<String> activities) {
			this.activities=activities;
			return this;
		}

		public Builder setMeals(String meals) {
			this.meals = meals;
			return this;
		}

		public VacationPackage build() {
			return new VacationPackage(this);
		}
	}
}

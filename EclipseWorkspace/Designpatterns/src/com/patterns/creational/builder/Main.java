package com.patterns.creational.builder;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {

        VacationPackage budgetFriendly = new VacationPackage.Builder("Lonawala","Budget Stay")
                .build();
		System.out.println(budgetFriendly);
		
		List<String> activities = Arrays.asList("Scuba diving","Paragliding");
		VacationPackage luxury = new VacationPackage.Builder("Maldives","5 Star")
				.setActivities(activities)
				.setMeals("5 star full package meals").build();
		System.out.println(luxury);
	}
}

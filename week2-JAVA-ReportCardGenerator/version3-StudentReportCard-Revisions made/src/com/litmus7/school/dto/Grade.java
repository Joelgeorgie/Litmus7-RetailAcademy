package com.litmus7.school.dto;

// Enum representing student grades with associated descriptions
public enum Grade {
	A("Excellent"),
	B("Good"),
	C("Average"),
	D("Pass"),
	F("Fail");

	private final String description;

	// Constructor to initialize grade with a description
	private Grade(String description) {
		this.description = description;
	}

	// Getter for the description
	public String getDescription() {
		return description;
	}
}

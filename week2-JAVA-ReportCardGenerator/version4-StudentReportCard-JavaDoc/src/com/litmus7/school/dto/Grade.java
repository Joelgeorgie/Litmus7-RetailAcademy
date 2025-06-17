package com.litmus7.school.dto;

/**
 * Enum representing student grades, each associated with a descriptive remark
 * such as "Excellent", "Good", etc.
 */
public enum Grade {
	A("Excellent"),
	B("Good"),
	C("Average"),
	D("Pass"),
	F("Fail");

	// Description associated with the grade 
	private final String description;

	/**
	 * Constructor to initialize a grade with its description.
	 * 
	 * @param description textual description of the grade
	 */
	private Grade(String description) {
		this.description = description;
	}

	/**
	 * Returns the description of the grade.
	 * 
	 * @return grade description
	 */
	public String getDescription() {
		return description;
	}
}

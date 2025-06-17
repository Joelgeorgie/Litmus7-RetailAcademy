package com.litmus7.school.dto;

import java.util.Scanner;

/**
 * Represents a Student with details such as name, roll number, marks,
 * and provides functionality to input data and generate a report card.
 */
public class Student {
	
	//Student attributes
	private String name;
	private int rollNumber;
	private double[] marks = new double[5];

	/**
	 * Takes input from the user for the student's name, roll number, and marks.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student name: ");
		name = scanner.nextLine();

		System.out.print("Enter roll number: ");
		rollNumber = scanner.nextInt();

		System.out.println("Enter marks in 5 subjects:");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextDouble();
		}
		System.out.println();
	}

	/**
	 * Calculates the total marks obtained by the student.
	 * 
	 * @return total marks
	 */
	private double calculateTotal() {
		double total = 0;
		for (double mark : marks) {
			total += mark;
		}
		return total;
	}

	/**
	 * Calculates the average marks of the student.
	 * 
	 * @return average marks
	 */
	private double calculateAverage() {
		return calculateTotal() / 5;
	}

	/**
	 * Determines the grade of the student based on average marks.
	 * 
	 * @return grade as an enum value
	 */
	private Grade getGrade() {
		double averageMarks = calculateAverage();

		if (averageMarks >= 90) {
			return Grade.A;
		} else if (averageMarks >= 75) {
			return Grade.B;
		} else if (averageMarks >= 60) {
			return Grade.C;
		} else if (averageMarks >= 50) {
			return Grade.D;
		} else {
			return Grade.F;
		}
	}

	/**
	 * Displays the report card of the student including name, roll number,
	 * total and average marks, and the grade with description.
	 */
	public void printReportCard() {
		System.out.println("--- Report Card ---");
		System.out.println("Name : " + name);
		System.out.println("Roll Number : " + rollNumber);
		System.out.println("Total Marks : " + calculateTotal());
		System.out.println("Average Marks : " + calculateAverage());

		Grade grade = getGrade(); 
		System.out.println("Grade : " + grade + " (" + grade.getDescription() + ")");
		System.out.println("-------------------");
	}
}

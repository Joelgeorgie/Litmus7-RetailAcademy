package com.litmus7.school.dto;

import java.util.Scanner;

/**
 * Student DTO class representing student details and report card generation
 * logic.
 */
public class Student {
	private String name;
	private int rollNumber;
	private double[] marks = new double[5];

	// Inputs the student's name, roll number, and marks in 5 subjects
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

	// Calculates the total marks obtained by the student
	private double calculateTotal() {
		double total = 0;
		for (double mark : marks) {
			total += mark;
		}
		return total;
	}

	// Calculates the average of the 5 subject marks
	private double calculateAverage() {
		return calculateTotal() / 5;
	}

	// Determines the grade based on the average marks
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

	// Prints the report card with all details
	public void printReportCard() {
		System.out.println("--- Report Card ---");
		System.out.println("Name : " + name);
		System.out.println("Roll Number : " + rollNumber);
		System.out.println("Total Marks : " + calculateTotal());
		System.out.println("Average Marks : " + calculateAverage());

		Grade grade = getGrade();  // Get grade
		System.out.println("Grade : " + grade + " (" + grade.getDescription() + ")");
		System.out.println("-------------------");
	}

}

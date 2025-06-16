package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

// Main application to input student details and print report cards
public class StudentApp {

	public static void main(String[] args) {

		// Scanner to read input from user
		Scanner scanner = new Scanner(System.in);

		// Read number of students
		System.out.print("Enter the number of students: ");
		int noOfStudents = scanner.nextInt();

		// Array to hold Student objects
		Student[] students = new Student[noOfStudents];

		// Input details for each student
		for (int i = 0; i < noOfStudents; i++) {
			System.out.println("Enter details of Student " + (i + 1));
			students[i] = new Student();
			students[i].inputDetails();
		}

		// Print report cards for all students
		System.out.println("\nPrinting the Report Cards:\n");

		for (int i = 0; i < noOfStudents; i++) {
			students[i].printReportCard();
			System.out.println();
		}
	}
}

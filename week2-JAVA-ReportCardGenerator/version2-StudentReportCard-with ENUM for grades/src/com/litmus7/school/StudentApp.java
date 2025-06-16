package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int noOfStudents = scanner.nextInt();
		
		Student students[] = new Student[noOfStudents];
		
		
		for(int i = 0; i<noOfStudents ; i++) {
			System.out.println("Enter details of Student "+(i+1));
			students[i]= new Student();
			students[i].inputDetails();
		}
		
		System.out.println("\nPrinting the Report Cards:\n");
		
		for(int i = 0; i<noOfStudents ; i++) {
			
			students[i].printReportCard();
			System.out.println();
		}

	}

}

package com.litmus7.school.dto;

import java.util.Scanner;

public class Student {
    private String name;
    private int rollNumber;
    private double[] marks = new double[5];

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

    private double calculateTotal() {
        double total = 0;
        for (int i = 0; i < 5; i++) {
            total += marks[i];
        }
        return total;
    }

    private double calculateAverage() {
        return calculateTotal() / 5;
    }

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

    public void printReportCard() {
        System.out.println("--- Report Card ---");
        System.out.println("Name : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Total Marks : " + calculateTotal());
        System.out.println("Average Marks : " + calculateAverage());
        System.out.println("Grade : " + getGrade());
        System.out.println("-------------------");
    }
}

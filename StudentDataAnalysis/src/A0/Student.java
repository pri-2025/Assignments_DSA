package A0;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	String name;
	int rollNo;
	float perc;
	int n;

	Student(String name, int rollNo, float perc) { // Initializing the constructor
		this.name = name;
		this.rollNo = rollNo;
		this.perc = perc;
	}

	public Student() { // Creating default constructor

	}

	Scanner sc = new Scanner(System.in);
	Student[] S; // Declaring Student array of objects as S

	// method for accepting astudent data
	public void acceptInfo() {
		try {
			System.out.print("Enter number of students: "); // prompting to enter number of students
			n = sc.nextInt();
			sc.nextLine();
			System.out.println();
			S = new Student[n]; // Initializing the array to size n
			for (int i = 0; i < n; i++) { // accepting n students' details
				System.out.print("Enter name of student " + (i + 1) + ": ");
				name = sc.nextLine(); // accepting Student's name
				System.out.print("Enter Roll No. of student " + (i + 1) + ": ");
				rollNo = sc.nextInt(); // accepting Student's roll no
				System.out.print("Enter percentage secured by student " + (i + 1) + ": ");
				perc = sc.nextFloat(); // accepting percentage scored by Student
				sc.nextLine();
				System.out.println();
				S[i] = new Student(name, rollNo, perc); // storing all the details in the array
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input! Please enter correct data types.");
			sc.nextLine();
		}
	}

	// method to display particular Student data
	public void displayInfo() {
		try {
			System.out.print("Enter roll number of the student: "); // prompting user to enter the roll no. of student
			int roll = sc.nextInt();
			boolean found = false;
			for (int i = 0; i < n; i++) { // checking whether the roll no matches with the existing data
				if (roll == S[i].rollNo) {
					System.out.println("Name of the student: " + S[i].name);
					System.out.println("Roll No.: " + S[i].rollNo);
					System.out.println("Percentage: " + S[i].perc);
					System.out.println();
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Student with roll number " + roll + " not found.\n");
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid roll number!");
			sc.nextLine();
		}
	}

	// method for finding topper of the class
	public void topper() {
		float max = S[0].perc;
		for (int i = 1; i < n; i++) {
			if (S[i].perc > max) {
				max = S[i].perc;
			}
		}
		for (int i = 0; i < n; i++) {
			if (S[i].perc == max) {
				System.out.println("Topper of the class is " + S[i].name + " with " + S[i].perc + "%.");
			}
		}
		System.out.println();
	}

	// method for calculating average percentage of the class
	public void avgPerc() {
		float sum = 0;
		for (int i = 0; i < n; i++) {
			sum += S[i].perc;
		}
		float avg = sum / n;
		System.out.println("Average percentage of the class is " + avg + "%.\n");
	}

	// method for calculating lowest percentage of the class
	public void lowestPerc() {

		float min = S[0].perc;
		for (int i = 1; i < n; i++) {
			if (S[i].perc < min) {
				min = S[i].perc;
			}
		}
		for (int i = 0; i < n; i++) {
			if (S[i].perc == min) {
				System.out.println("Lowest percentage scored in the class is " + S[i].perc + "%.");
			}
		}
		System.out.println();
	}

	// method for calculating failed students of the class
	public void failures() {
		if (S == null || S.length == 0) {
			System.out.println("No student data available.\n");
			return;
		}
		int count = 0;
		System.out.println("List of failed students (percentage < 35):");
		for (int i = 0; i < n; i++) {
			if (S[i].perc < 35.0) {
				System.out.println(S[i].name + " (" + S[i].perc + "%)");
				count++;
			}
		}
		System.out.println("Total number of failed students: " + count + "\n");
	}
}

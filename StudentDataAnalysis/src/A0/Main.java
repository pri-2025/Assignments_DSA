package A0;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Student S1 = new Student(); // creating object of Student class.
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Choose from the following:"); // Displaying the choices to user
			System.out.println("1. Enter Student Details");
			System.out.println("2. Display Student Details by Roll No.");
			System.out.println("3. Show Class Performance (Topper, Average, Lowest)");
			System.out.println("4. Show Failed Students");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			try {
				choice = sc.nextInt(); // input for the choice
				System.out.println();
				switch (choice) {
				case 1:
					S1.acceptInfo(); // Prompting user to enter student data in the system.
					break;
				case 2:
					S1.displayInfo(); // Displaying praticular student information as per his/her roll number.
					break;
				case 3:
					S1.topper(); // Name and percentage of topper of the class
					S1.avgPerc(); // Average percentage of the class
					S1.lowestPerc(); // Lowest percentage of the class
					break;
				case 4:
					S1.failures(); // List of failed students and their count
					break;
				case 5:
					System.out.println("Exiting program...");
					break;
				default:
					System.out.println("Invalid choice! Please enter a number between 1 and 5.\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number.\n");
				sc.nextLine();
				choice = 0;
			}
		} while (choice != 5);
	}
}

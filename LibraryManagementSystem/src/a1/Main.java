package a1;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Library ob = new Library(); // Creating object of Library class
		Scanner sc = new Scanner(System.in);
		int choice;

		// Menu-driven program using do-while loop
		do {
			// Displaying the menu
			System.out.println("---------Welcome to Library---------");
			System.out.println("1. Enter Book Details");
			System.out.println("2. Display Book Details");
			System.out.println("3. Sort books based on ISBN no.");
			System.out.println("4. List all books of specific author");
			System.out.println("5. Exit");
			System.out.println();

			System.out.print("Enter your choice: ");
			choice = sc.nextInt(); // Accepting user's choice
			System.out.println();

			switch (choice) {
			case 1:
				ob.Accept_Book_Details(); // Accept book details
				break;
			case 2:
				// Sub-menu for display
				System.out.println("1. All books \n2. Specific book");
				System.out.print("Enter your choice - ");
				int num = sc.nextInt();
				System.out.println();
				if (num == 1) {
					ob.Display_Book_Details(); // Display all books
				} else if (num == 2) {
					ob.searchBooks_ISBN(); // Display specific book by ISBN
				} else {
					System.out.println("Invalid choice!");
				}
				break;
			case 3:
				ob.sortBooks_ISBN(); // Sort and display books by ISBN
				break;
			case 4:
				ob.searchBooks_Author(); // Display books by a specific author
				break;
			case 5:
				System.out.println("Exiting!"); // Exit message
				break;
			default:
				System.out.println("Invalid Choice!");
				System.out.println();
			}
		} while (choice != 5); // Loop continues until Exit (choice = 5)
	}
}

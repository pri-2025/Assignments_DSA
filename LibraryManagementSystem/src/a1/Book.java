package a1;

import java.util.InputMismatchException;
import java.util.Scanner;

// Book class - represents a single book
public class Book {
	String BookName;
	String AuthorName;
	int ISBNNo;

	// Parameterized constructor
	public Book(String BookName, String AuthorName, int ISBNNo) {
		this.BookName = BookName;
		this.AuthorName = AuthorName;
		this.ISBNNo = ISBNNo;
	}

	// Default constructor
	Book() {
	}
}

// Library class - inherits from Book, manages multiple books
class Library extends Book {
	public Library(String BookName, String AuthorName, int ISBNNo) {
		super(BookName, AuthorName, ISBNNo);
	}

	public Library() {
	}

	Scanner sc = new Scanner(System.in);
	int n; // number of books
	Book B[]; // array to store Book objects

	// Method to accept details of 'n' books
	void Accept_Book_Details() {
		try {
			System.out.print("Enter number of books : ");
			n = sc.nextInt();
			sc.nextLine(); // clear input buffer
			System.out.println();
			B = new Book[n]; // allocate array size
			for (int i = 0; i < n; i++) {
				System.out.print("Enter name of book " + (i + 1) + ": ");
				BookName = sc.nextLine();
				System.out.print("Enter author name of the book " + (i + 1) + ": ");
				AuthorName = sc.nextLine();
				System.out.print("Enter ISBN no. of book " + (i + 1) + ": ");
				ISBNNo = sc.nextInt();
				sc.nextLine();
				System.out.println();
				B[i] = new Book(BookName, AuthorName, ISBNNo); // store book object
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input! Please enter correct data types.");
			sc.nextLine(); // clear scanner buffer
		}
	}

	// Method to display all books
	void Display_Book_Details() {
		for (int i = 0; i < n; i++) {
			System.out.println("Name of the book : " + B[i].BookName);
			System.out.println("Name of the author : " + B[i].AuthorName);
			System.out.println("ISBN no. of the book : " + B[i].ISBNNo);
			System.out.println();
		}
	}

	// Method to search book by ISBN number
	void searchBooks_ISBN() {
		try {
			System.out.print("Enter the ISBN no. : ");
			int ISBNNo_search = sc.nextInt();
			System.out.println();
			boolean found = false;

			for (int i = 0; i < n; i++) {
				if (ISBNNo_search == B[i].ISBNNo) {
					System.out.println("ISBN no. of the book : " + B[i].ISBNNo);
					System.out.println("Name of the book : " + B[i].BookName);
					System.out.println("Name of the author : " + B[i].AuthorName);
					System.out.println();
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Book with " + ISBNNo_search + " does not exist.");
				System.out.println();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input! Please enter correct data types.");
			sc.nextLine();
		}
	}

	// Method to search all books by an author
	void searchBooks_Author() {
		try {
			System.out.print("Enter the author name : ");
			String author_search = sc.nextLine();
			boolean found = false;

			for (int i = 0; i < n; i++) {
				if (author_search.equals(B[i].AuthorName)) {
					System.out.println("Name of the book : " + B[i].BookName);
					System.out.println("ISBN no. of the book : " + B[i].ISBNNo);
					System.out.println();
					found = true;
				}
			}

			if (!found) {
				System.out.println("Book of " + author_search + " does not exist.");
				System.out.println();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input! Please enter correct data types.");
			sc.nextLine();
		}
	}

	// Method to sort and display books by ISBN number using bubble sort
	void sortBooks_ISBN() {
		try {
			// Bubble sort on ISBN numbers
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if (B[j].ISBNNo > B[j + 1].ISBNNo) {
						Book temp = B[j];
						B[j] = B[j + 1];
						B[j + 1] = temp;
					}
				}
			}

			// Display sorted books
			System.out.println("Books sorted by ISBN No:");
			for (int i = 0; i < n; i++) {
				System.out.println("ISBN no. of the book : " + B[i].ISBNNo);
				System.out.println("Name of the book : " + B[i].BookName);
				System.out.println("Name of the author : " + B[i].AuthorName);
				System.out.println();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input! Please enter correct data types.");
			sc.nextLine();
		}
	}
}

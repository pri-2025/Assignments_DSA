package A1_LibraryManagementSystem_Arrays_Searching_Sorting;

import java.util.Scanner;

public class Library extends Books {

	Library(String bn, int id, String an) {
		super(bn, id, an);
		// TODO Auto-generated constructor stub
	}

	public Library() {
		// TODO Auto-generated constructor stub
	}

	Books B[];
	int n;

	Scanner sc = new Scanner(System.in);

	// method to add books
	public void add() {
		System.out.print("Enter no. of books you want to add : ");
		n = sc.nextInt();

		B = new Books[n];

		for (int i = 0; i < n; i++) {

			System.out.print("Enter name of book " + (i + 1) + ": ");
			b_name = sc.nextLine();
			System.out.print("Enter ISBN no. of book " + (i + 1) + ": ");
			b_id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter author name of the book " + (i + 1) + ": ");
			a_name = sc.nextLine();

			B[i] = new Books(b_name, b_id, a_name);
		}
	}

	// method to display books
	public void display() {
		for (int i = 0; i < n; i++) {
			System.out.print("Name of book " + (i + 1) + ": " + B[i].b_name);
			System.out.print("ISBN no. of book " + (i + 1) + ": " + B[i].b_id);
			sc.nextLine();
			System.out.print("Author name of the book " + (i + 1) + ": " + B[i].a_name);
			System.out.println();
		}
	}

	// method to search books - binary search
	public void search_id_bs() {

		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (B[j].b_id > B[j + 1].b_id) {
					temp = B[j].b_id;
					B[j].b_id = B[j + 1].b_id;
					B[j + 1].b_id = temp;
				}
			}
		}

		System.out.print("Enter ISBN no. of the book : ");
		int key_id = sc.nextInt();

		int start = B[0].b_id, end = B[n - 1].b_id, mid = 0;

		for (int i = 0; i < n; i++) {
			mid = start + ((end - start) / 2);

			if (key_id == mid) {
				System.out.println("Name of the book : " + B[mid].b_name);
				System.out.println("ISBN no. of the book : " + B[mid].b_id);
				System.out.println("Name of the author of the book : " + B[mid].a_name);
			} else if (key_id < mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
	}

	// method to sort books - bubble sort
	public void sort_id_bubble() {
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (B[j].b_id > B[j + 1].b_id) {
					temp = B[j].b_id;
					B[j].b_id = B[j + 1].b_id;
					B[j + 1].b_id = temp;
				}
			}
		}
		display();
	}

	// method to sort books - insertion sort
	public void sort_id_insertion() {
		int j = 0;
		for (int i = 0; i < n; i++) {
			Books key = B[i];
			j = i - 1;
			while (j >= 0 && B[j].b_id > key.b_id) {
				B[j + 1] = B[j];
				j--;
			}
			B[j + 1] = key;
		}
		display();
	}

	// method to sort books - quick sort
	// quick sort wrapper
	public void sort_id_quick() {
		quickSort(0, n - 1);
		display();
	}

	// quick sort implementation
	private void quickSort(int low, int high) {
		if (low < high) {
			int p = partition(low, high);
			quickSort(low, p - 1);
			quickSort(p + 1, high);
		}
	}

	// partition based on b_id of Books
	private int partition(int low, int high) {
		int pivot = B[high].b_id;
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (B[j].b_id <= pivot) {
				i++;

				// swap Books objects, not only ID!
				Books temp = B[i];
				B[i] = B[j];
				B[j] = temp;
			}
		}

		// swap pivot into correct position
		Books temp = B[i + 1];
		B[i + 1] = B[high];
		B[high] = temp;

		return i + 1;
	}

	// method to search books of a author - linear search
	public void bks_auth_ls() {
		System.out.print("Enter author name : ");
		String key = sc.nextLine();
		for (int i = 0; i < n; i++) {
			if (B[i].a_name.equalsIgnoreCase(key)) {
				System.out.print("Name of the book : " + B[i].b_name);
				System.out.print("ISBN no. of the book : " + B[i].b_id);
				System.out.println();
			}
		}
	}

}

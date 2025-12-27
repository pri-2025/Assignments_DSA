package A1_LibraryManagementSystem_Arrays_Searching_Sorting;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Library Lib = new Library();

		Scanner sc = new Scanner(System.in);
		int opt;

		do {
			System.out.println("-------------Welcome to Library------------");
			System.out.println("1. Add books");
			System.out.println("2. Search book by ISBN no. (binary search)");
			System.out.println("3. Sort Books (bubble sort)");
			System.out.println("4. Sort Books (insertion sort)");
			System.out.println("5. Sort Books (quick sort)");
			System.out.println("6. List all books of particular author (linear search) ");
			System.out.println("7. Exit");
			System.out.println();
			System.out.print("Choose among the folllowing : ");
			opt = sc.nextInt();
			System.out.println();

			switch (opt) {
			case 1:
				Lib.add();
				System.out.println();
				break;
			case 2:
				Lib.search_id_bs();
				System.out.println();
				break;
			case 3:
				Lib.sort_id_bubble();
				System.out.println();
				break;
			case 4:
				Lib.sort_id_insertion();
				System.out.println();
				break;
			case 5:
				Lib.sort_id_quick();
				System.out.println();
				break;
			case 6:
				Lib.bks_auth_ls();
				System.out.println();
				break;
			case 7:
				System.out.println("Exiting...");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice!! \nPlease enter between 1 to 6");
				System.out.println();
				break;
			}

		} while (opt != 7);
	}

}

package A9_MobileContact_Hashing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ContactList Cl = new ContactList();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("----------MOBILE CONTACT LIST-----------");
			System.out.println("1. INSERT CONTACT");
			System.out.println("2. DISPLAY CONTACTS");
			System.out.println("3. SEARCH CONTACT");
			System.out.println("4. DELETE CONTACT");
			System.out.println("5. EXIT");
			System.out.println();
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				Cl.create();
				System.out.println();
				break;
			case 2:
				Cl.display();
				System.out.println();
				break;
			case 3:
				Cl.search();
				System.out.println();
				break;
			case 4:
				Cl.delete();
				System.out.println();
				break;
			case 5:
				System.out.println("Exiting...");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice!");
				System.out.println();
			}
		} while (choice != 5);
	}

}

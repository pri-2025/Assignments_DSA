package A9_MobileContact_Hashing;

import java.util.Scanner;

public class ContactList {

	int n; // size of hash table
	Contact[] h_table; // hash table array
	Scanner sc = new Scanner(System.in);

	// Hash function
	int hash(String key) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += key.charAt(i);
		}
		return sum % n;
	}

	// Create / Insert contacts
	public void create() {

		if (h_table == null) { // initialize only once
			System.out.print("Enter number of contacts you want to register : ");
			n = sc.nextInt();
			h_table = new Contact[n];
		}

		sc.nextLine(); // clear buffer

		System.out.print("Enter name of the person : ");
		String name = sc.nextLine();

		System.out.print("Enter mobile no. : ");
		long mob = sc.nextLong();

		sc.nextLine(); // clear buffer

		System.out.print("Enter email-id : ");
		String email = sc.nextLine();

		Contact C = new Contact(name, mob, email);
		int h_val = hash(name);

		int start = h_val;

		do {
			if (h_table[h_val] == null || h_table[h_val].name.equals("-1")) {

				h_table[h_val] = C;
				System.out.println("Inserted at index : " + h_val);
				return;
			} else {
				System.out.println("Collision at index " + h_val);
			}
			h_val = (h_val + 1) % n;

		} while (h_val != start);

		System.out.println("Hash Table Full. Cannot Insert!");
	}

	// Display contacts
	public void display() {
		System.out.println("\n---------- CONTACT LIST ----------");
		for (int i = 0; i < n; i++) {

			System.out.print("Index " + i + ": ");

			if (h_table[i] != null && !h_table[i].name.equals("-1")) {
				System.out.println();
				h_table[i].display();
			} else {
				System.out.println(" Empty");
			}
		}
	}

	// Search contact
	public void search() {
		System.out.print("Enter name to search : ");
		sc.nextLine();
		String key = sc.nextLine();

		int h_val = hash(key);
		int start = h_val;

		do {
			if (h_table[h_val] == null) {
				System.out.println("Contact not found.");
				return;
			}

			if (h_table[h_val].name.equals(key)) {
				System.out.println("Contact found at index " + h_val + ":\n");
				h_table[h_val].display();
				return;
			}

			h_val = (h_val + 1) % n;

		} while (h_val != start);

		System.out.println("Contact not found.");
	}

	// Delete contact
	public void delete() {

		System.out.print("Enter name to delete : ");
		sc.nextLine();
		String key = sc.nextLine();

		int h_val = hash(key);
		int start = h_val;

		do {
			if (h_table[h_val] == null) {
				System.out.println("Contact not found.");
				return;
			}

			if (h_table[h_val].name.equals(key)) {

				System.out.println("Deleting contact : " + h_table[h_val].name);
				h_table[h_val].name = "-1"; // mark deleted
				h_table[h_val].mob = 0;
				h_table[h_val].email = "";
				System.out.println("Contact deleted successfully.");
				return;
			}

			h_val = (h_val + 1) % n;

		} while (h_val != start);

		System.out.println("Contact not found.");
	}
}

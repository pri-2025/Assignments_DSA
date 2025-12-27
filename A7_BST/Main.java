package A7_BST;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		Scanner sm = new Scanner(System.in);
		int opt;
		do {
			System.out.println("************MENU***************");
			System.out.println("1. Create");
			System.out.println("2. Display");
			System.out.println("3. Search");
			System.out.println("4. Update");
			System.out.println("5. Delete");
			System.out.println("6. Exit");
			System.out.println();
			System.out.print("Enter your choice : ");
			opt = sm.nextInt();
			System.out.println();
			switch (opt) {
			case 1:
				d.create();
				System.out.println();
				break;
			case 2:
				d.display(d.root);
				System.out.println();
				break;
			case 3:
				d.search();
				System.out.println();
				break;
			case 4:
				d.update();
				System.out.println();
				break;
			case 5:
				d.delete();
				System.out.println();
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Wrong number! \nPlease choose between 1 to 5.");
				System.out.println();
				break;
			}
		} while (opt != 6);
		sm.close();
	}
}

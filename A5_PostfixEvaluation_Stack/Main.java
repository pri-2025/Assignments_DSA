package A5_PostfixEvaluation_Stack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack S = new Stack();
		Scanner sc = new Scanner(System.in);
		int opt;

		do {
			System.out.println("Choose among the following : ");
			System.out.println("1. Evaluate a postfix expression");
			System.out.println("2. Reverse a string");
			System.out.println("3. Exit");
			System.out.println();
			System.out.println("Enter your choice : ");
			opt = sc.nextInt();
			System.out.println();

			switch (opt) {
			case 1:
				S.postfix();
				System.out.println();
				break;
			case 2:
				S.reverse();
				System.out.println();
				break;
			case 3:
				System.out.println("Exiting...");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice! \nPlease choose between 1 and 2!");
				System.out.println();
				break;
			}
		} while (opt != 3);
	}

}

package A4_SubSetSum_Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int x;

		System.out.print("Enter number of elements: ");
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("Error: Number of elements must be positive.");
			return;
		}

		int set[] = new int[n];
		System.out.println("Enter elements of the set:");
		for (int i = 0; i < n; i++) {
			x = sc.nextInt();
			if (x < 0) {
				System.out.println("Error: Negative numbers are not allowed.");
				i--;
			} else {
				set[i] = x;
			}
		}
		int sum;
		while (true) {
			System.out.print("Enter target sum (non-negative): ");
			sum = sc.nextInt();
			if (sum < 0) {
				System.out.println("Error: Target sum cannot be negative. Please try again.");
			} else {
				break;
			}
		}

		if (sum == 0) {
			System.out.println("Subset with given sum: []");
			return;
		}

		SubSet S = new SubSet();
		ArrayList<Integer> curr = new ArrayList<>();
		System.out.println("Subsets with given sum are:");
		S.print(set, n, sum, curr);
		if (S.cnt == 0) {
			System.out.println("No subsets found.");
		}
	}

}

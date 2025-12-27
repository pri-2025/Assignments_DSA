package A6_JobSequencing_Queue;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter number of jobs: ");
		int n = in.nextInt();
		System.out.println();

		// Empty input validation
		if (n <= 0) {
			System.out.println("No jobs to schedule.");
			return;
		}

		Job[] job = new Job[n];

		// Accept jobs
		for (int i = 0; i < n; i++) {
			System.out.print("Enter Job ID(char): ");
			char id = Character.toUpperCase(in.next().charAt(0));

			// Validation for duplicate Job ID
			boolean exists = false;
			for (int j = 0; j < i; j++) {
				if (job[j].id == id) {
					exists = true;
					break;
				}
			}
			if (exists) {
				System.out.println("Job ID already exists. Enter again:");
				i--; // redo this iteration
				continue;
			}

			System.out.print("Enter Job Deadline: ");
			int deadline = in.nextInt();
			while (deadline < 1) {
				System.out.print("Invalid deadline! Enter again: ");
				deadline = in.nextInt();
			}

			System.out.print("Enter Job Profit: ");
			int profit = in.nextInt();
			while (profit < 0) {
				System.out.print("Invalid profit! Must be non-negative. Enter again: ");
				profit = in.nextInt();
			}

			job[i] = new Job(id, deadline, profit);
			System.out.println();
		}

		// Display entered jobs
		System.out.println("\nEntered Jobs:");
		for (int i = 0; i < n; i++) {
			System.out.println(
					"Job ID: " + job[i].id + " | Deadline: " + job[i].deadline + " | Profit: " + job[i].profit);
		}

		System.out.println("\nJob scheduling to maximize profit:");
		Job.printJobScheduling(job, n);
	}
}

package A6_JobSequencing_Queue;

import java.util.Scanner;

public class MainPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = in.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Job ID(char): ");
            char id = Character.toUpperCase(in.next().charAt(0));

            System.out.print("Enter Job Deadline: ");
            int deadline = in.nextInt();

            System.out.print("Enter Job Profit: ");
            int profit = in.nextInt();

            jobs[i] = new Job(id, deadline, profit);
            System.out.println();
        }

        JobSequencingPQ.printJobScheduling(jobs, n);

	}

}

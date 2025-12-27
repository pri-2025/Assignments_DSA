package A6_JobSequencing_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class JobSequencingPQ {
	static void printJobScheduling(Job[] jobs, int n) {

		// Step 1: Sort by deadline (ascending)
		Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);

		// Min-Heap based on profit
		PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.profit - b.profit);

		// Step 2: Traverse jobs
		for (int i = 0; i < n; i++) {
			pq.offer(jobs[i]); // include job

			// If heap size exceeds deadline → remove least profit job
			if (pq.size() > jobs[i].deadline) {
				pq.poll();
			}
		}

		// Step 3: Jobs in PQ are selected jobs
		int maxProfit = 0;
		List<Character> selectedJobs = new ArrayList<>();

		while (!pq.isEmpty()) {
			Job j = pq.poll();
			maxProfit += j.profit;
			selectedJobs.add(j.id);
		}

		// Print result
		System.out.println("\nScheduled Jobs (Optimal using PQ):");
		for (char c : selectedJobs)
			System.out.print(c + " ");
		System.out.println("\nMaximum Profit = " + maxProfit);
	}
}

package A6_JobSequencing_Queue;

class Job {
	char id;
	int deadline, profit;

	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	static void printJobScheduling(Job[] arr, int n) {
		// Sort in descending order of profit
		for (int x = 1; x < n; x++) {
			Job key = arr[x];
			int y = x - 1;
			while (y >= 0 && arr[y].profit < key.profit) {
				arr[y + 1] = arr[y];
				y--;
			}
			arr[y + 1] = key;
		}

		// Find max deadline
		int maxDeadline = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i].deadline > maxDeadline)
				maxDeadline = arr[i].deadline;
		}

		// Scheduling jobs to maximize profit
		int maxProfit = 0;
		char[] result = new char[maxDeadline];
		for (int i = 0; i < n; i++) {
			for (int j = arr[i].deadline - 1; j >= 0; j--) {
				if (result[j] == '\0') {
					result[j] = arr[i].id;
					maxProfit += arr[i].profit;
					break;
				}
			}
		}

		// Print scheduled jobs
		System.out.print("Scheduled Jobs: ");
		for (int i = 0; i < maxDeadline; i++) {
			if (result[i] != '\0')
				System.out.print(result[i] + " ");
		}
		System.out.println("\nMax Profit for this Schedule: " + maxProfit);
	}
}
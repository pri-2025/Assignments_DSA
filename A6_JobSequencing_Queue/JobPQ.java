package A6_JobSequencing_Queue;

public class JobPQ {
	char id;
	int deadline, profit;

	public JobPQ(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}

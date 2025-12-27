package A4_SubSetSum_Stack;

import java.util.ArrayList;

public class SubSet {
	int cnt=0;
	
	public void print(int[] set, int n, int sum, ArrayList<Integer> curr) {
		
		if(sum==0) {
			System.out.println(curr);
			cnt++;
			return;
		}
		if(n==0 || sum<0) {
			return;
		}
		curr.add(set[n-1]);
		print(set, n-1, sum-set[n-1], curr);
		
		curr.remove(curr.size()-1);
		
		print(set, n-1, sum, curr);
	}
}

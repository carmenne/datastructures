import java.util.Arrays;

public class Kadane {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {-2, 1, -9, -5};
		int[] B = {3, 2, -6, 4, 0};
		System.out.println(solution.solution(A));
		System.out.println(solution.solution(B));
	}
}

class Solution { 

	int[] A;
	Integer[] DP;
	
	public int solution(int[] A) {
		this.A = A;
		int N = A.length;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			sum = A[i] + Math.max(0, sum);
			max = Math.max(sum, max);
		}
		return max;
	}	
	
	
	
	/* Top down	
	public int solution(int[] A) {
		this.A = A;
		int N = A.length;
		DP = new Integer[N];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (DP[i] == null) {
				DP[i] = sum(i);
			}
			int val = DP[i];
			if (val > max) max = val;
		}
		return max;
	}	
	
	private int sum(int i) {
		if (i == 0) return A[i];
		return A[i] + Math.max(0, sum(i-1));
	}
	* */
}

import java.util.*;

public class MaxProfit {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		
		int N = A.length;
		if (N == 0) return 0;
		
		int max = Integer.MIN_VALUE;
		int min = A[0];

		for (int sell = 1; sell < N; sell++) {
			max = Math.max(max, A[sell] - min);
			min = Math.min(min, A[sell]);
		}
		
		return max < 0 ? 0 : max;
	}
}
	

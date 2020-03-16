import java.util.*;

public class MaxSliceSum {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {-2, 1, -9, -5};
		int[] B = {3, 2, -6, 4, 0};
		System.out.println(solution.solution(A));
		System.out.println(solution.solution(B));
	}
}

class Solution {
	public int solution(int[] A) {
		int N = A.length;
		int max = Integer.MIN_VALUE;
		int[] sums = new int[N];
		sums[0] = A[0];
		for (int i = 1; i < N; i++) {
			sums[i] = sums[i-1] + A[i];
		}
		
		System.out.println(Arrays.toString(sums));
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int sum = sums[j] - (i < 1 ? 0 : sums[i-1]);
				if (sum > max) max = sum;
			}
		}
		return max;
	}
}

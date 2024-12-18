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
		int max_slice = 0;
		
		for (int i = 0; i < N; i++) {
			max_slice = A[i] + Math.max(0, max_slice);
			max = Math.max(max, max_slice);
		}
		return max;
	}
}

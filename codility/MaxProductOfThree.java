import java.util.*;

public class MaxProductOfThree {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {-5, 5, -5, 4};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		int N = A.length;
		Arrays.sort(A);
		
		if (A[0] < 0 && A[1] < 0 && A[N-1] > 0) 
			return Math.max(A[0]*A[1], A[N-3]*A[N-2]) * A[N-1];
		else 
			return A[N-3]*A[N-2]*A[N-1];
		
	}
}

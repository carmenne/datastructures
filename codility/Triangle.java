import java.util.*;

public class Triangle {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		int N = A.length;
		Arrays.sort(A);
		for (int i = 2; i < N; i++) {
			if (A[i] < ((long)A[i-1] + (long)A[i-2])) {
				if (triangle(A[i], A[i-1], A[i-2])) {
					return 1;
				}
			}
		}
		
		return 0;
	}
	
	private boolean triangle(long a, long b, long c) {
		return b < a + c && c < a + b;
	}
}

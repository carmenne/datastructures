import java.util.*;

public class TapeEquilibrium {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {-1, 1};
		System.out.println(solution.solution(A));
	}
}

class Solution { 
	public int solution(int[] A) {
		int N = A.length;
		int S1 = 0;
		int S2 = 0;
		int diff = 0;
		for (int i = 0; i < N; i++) {
			S2 += A[i];
		}
		int min = Integer.MAX_VALUE; //Math.abs(S1-S2);		
		for (int i = 0; i < N - 1; i++) {
			S1 += A[i];
			S2 -= A[i];
			diff = Math.abs(S1-S2);
			if (diff < min) {
				min = diff;
			}
		}
		return min;
	}
}

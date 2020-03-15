import java.util.*;

public class MinAvgTwoSlice {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {10, 10, -1, 2, 4, -1, 2, -1};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	
	public int solution(int[] A) {
		int N = A.length;
		for (int i = 1; i < N; i++) {
			A[i] += A[i-1];
		}
		
		double avgMin = Integer.MAX_VALUE;
		int indexMin = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double newAvg = (A[j] - A[i == 0 ? 0 : i-1])/(j - i + 1.);
				if (newAvg < avgMin) {
					avgMin = newAvg;
					indexMin = i;
				}
			}
		}
		
		return indexMin;
	}
	
}


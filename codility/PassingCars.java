import java.util.*;

public class PassingCars {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {0, 1, 0, 1, 1};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	
	public int solution(int[] A) {
		int N = A.length;
		int east = 0;
		int result = 0;
				
		for (int i = 0; i < N; i++) {
			if (A[i] == 0) {
				++east;
			} else { 
				result += east;
				if (result > 1_000_000_000 ) {
					return -1;
				}
			}
		}	

		return result;
	}
}

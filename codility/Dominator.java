import java.util.*;

public class Dominator {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2, 1, 1, 3};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		
		
		int N = A.length;
		if (N == 0) return -1;
		int[] B = Arrays.copyOf(A, N);
		
		
		Arrays.sort(B);
		
		int half = N / 2;
				
		if (half(B, B[half], N)) {
			return indexOf(A, B[half]);
		} 
		
		return -1;
	}	
	
	private boolean half(int[] B, int b, int N) {
		int index = indexOf(B, b);
		if (index + N / 2 >= N) return false;
		return B[index + N / 2] == b;
	} 
	
	private int indexOf(int[] A, int b) {

		for (int i = 0; i < A.length; i++) {
			if (A[i] == b) 
				return i;
		}
		
		return -1;
	}
}

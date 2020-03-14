import java.util.*;

public class PermMissingElem {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2, 3, 1, 5};
		System.out.println(solution.solution(A));
	}
}

class Solution { 
	public int solution(int[] A) {
		int N = A.length;
		Set<Integer> numbers = new HashSet<>();
		
		for (int i = 1; i <= N + 1; i++) {
			numbers.add(i);
		}
		
		for (int i = 0; i < N; i++) {
			numbers.remove(A[i]);
		}
		
		return numbers.iterator().next();
	}
}

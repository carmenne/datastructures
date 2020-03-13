import java.util.*;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {9, 3, 9, 3, 9, 7, 9};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		Set<Integer> oddities = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			int element = A[i];
			if (oddities.contains(element)) {
				oddities.remove(element);
			} else {
				oddities.add(element);
			}
		}
		return oddities.iterator().next();
	}
}

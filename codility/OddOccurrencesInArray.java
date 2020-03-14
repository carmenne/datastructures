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
		int result = 0;
		for (int i : A) {
			result ^= i;
		}
		return result;
	}
}

import java.util.*;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {1, 3, 6, 4, 1, 2};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	
	public int solution(int[] A) {
		int n = A.length;
		Set<Integer> values = new HashSet<>();
		int min = 1;
		
		for (int el : A) {
			if (el > min && el <= n) {
				values.add(el);
			} else if (el == min) {
				while (values.remove(++min));
			}
		}
		
		return min;
	}
}

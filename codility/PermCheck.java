import java.util.*;

public class PermCheck {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {4, 5, 3, 2};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		int n = A.length;
		BitSet values = new BitSet(n + 1);
		for (int el : A) {
			if (el < 1 || el > n || values.get(el)) {
				return 0;
			}
			values.set(el);
		}		
		return 1;
	} 
}

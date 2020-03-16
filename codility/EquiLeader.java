import java.util.*;

public class EquiLeader {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//~ int[] A = {4, 3, 4, 4, 4, 2};
		//~ System.out.println(solution.solution(A));
		int[] A = {0, 0};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		int N = A.length;
		Map<Integer, Integer> apparitions = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int el = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int a = A[i];
			if (!apparitions.containsKey(a)) {
				apparitions.put(a, 0);
			}
			apparitions.put(a, apparitions.get(a) + 1);
			int val = apparitions.get(a);
			if (val > max) {
				el = a;
				max = val;
			}
		}
		
		if (max < N/2) return 0;
		
		int count = 0;
		int m1 = 0;
		int m2 = max;
		for (int i = 1; i < N; i++) {
			if (A[i-1] == el) {
				m1++;
				m2--;
			}
			if (m1 > i / 2 && m2 > (N - i) / 2) {
					count++;
			}
		}
		
		return count;
	}
}
		

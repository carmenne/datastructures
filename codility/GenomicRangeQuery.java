import java.util.*;

public class GenomicRangeQuery {
	public static void main(String[] args) {
		Solution solution = new Solution();
		// 'AC', [0, 0, 1], [0, 1, 1]
		//~ String S = "AC";
		//~ int[] P = {0, 0, 1};
		//~ int[] Q = {0, 1, 1};
		String S = "CAGCCTA";
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		System.out.println(Arrays.toString(solution.solution(S, P, Q)));
	}
}

class Solution {
	
	public int[] solution(String S, int[] P, int[] Q) {
		
		Map<Character, Integer> values = new HashMap<>();
		values.put('A', 1);
		values.put('C', 2);
		values.put('G', 3);
		values.put('T', 4);
		
		int N = S.length();
		int[][] mins = new int[N + 1][4];
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 4; j++) {
				mins[i][j] = mins[i-1][j];
			}
			int index = values.get(S.charAt(i-1)) - 1;
			mins[i][index]++;
		}
		
		int M = P.length;
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			result[i] = calculate(mins, P[i], Q[i] + 1);
		} 
		
		return result;
		
	}
	
	private int calculate(int[][] mins, int k, int l) {
		if (mins[l][0] - mins[k][0] > 0) {
			return 1;
		} else if (mins[l][1] - mins[k][1] > 0) {
			return 2;
		} else if (mins[l][2] - mins[k][2] > 0) {
			return 3;
		} else if (mins[l][3] - mins[k][3] > 0) {
			return 4;
		}
		
		return -1;
	}
}

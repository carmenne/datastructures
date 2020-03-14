import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class MaxCounters {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {1, 6, 1, 6, 6, 3, 6};
		System.out.println(Arrays.toString(solution.solution(5, A)));
	}
}

class Solution {
	
	int[] counters;
	int max_curr = 0;
	int max = 0;
	
	private int get(int i) {
		return Math.max(counters[i], max);
	}
	
	public int[] solution(int N, int[] A) {
		counters = new int[N];
		for (index : A) {
			if (index < N + 1) {
				int val = get(index - 1) + 1;
				counters[index - 1] = val;
				max_curr = Math.max(max_curr, val);
			} else {
				max = max_curr;
			}
		}
		
		for (int i = 0; i < N; i++) {
			counters[i] = get(i);
		}
		
		return counters;
	}
		
}


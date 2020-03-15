import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Distinct {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2, 1, 1, 2, 3, 1};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		int N = A.length;
		Integer[] B = new Integer[N];
		for (int i = 0; i < N; i++) B[i] = A[i];
	
		return new HashSet<Integer>(Arrays.asList(B)).size();
	}
}
